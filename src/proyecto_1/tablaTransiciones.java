/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author sergi
 */
public class tablaTransiciones {
    
    
    ArrayList<terminal> terminales;
    tablaSiguientes tbSig;
    ArrayList<transicion> transiciones;
    ArrayList<ArrayList<Integer>> estados;
    ArrayList<Integer> estadosAceptacion;
    String[][] tablaTransiciones;
    int centinela;
    
    public tablaTransiciones(tablaSiguientes tbSig) {
        this.terminales = new ArrayList<>();
        this.tbSig = tbSig;
        this.transiciones = new ArrayList();
        this.estados = new ArrayList<>();
        this.estadosAceptacion = new ArrayList<>();
    }
    
    public void calcularTransicionesDeUnEstado(ArrayList<Integer> estado){
        int estadoSig,estadoActual = this.estados.indexOf(estado);
        for (Integer nodo : estado) {
            if (this.centinela == nodo && !this.estadosAceptacion.contains(estadoActual)) {
                this.estadosAceptacion.add(estadoActual);
                continue;
            }
            hojaSig hsig = this.tbSig.hojasSig.get(nodo-1);
            //estadoActual = this.estados.indexOf(estado);
            //Se guardan los estados de aceptacion
            //Se pregunta si el estado ya existe
            if (this.estados.indexOf(hsig.siguientes) == -1) {
                estadoSig = this.estados.size();
                this.estados.add(hsig.siguientes);
            }else{
                estadoSig = this.estados.indexOf(hsig.siguientes);
            }
            if (hsig.siguientes.equals(new ArrayList<>(List.of(this.centinela))) && !this.estadosAceptacion.contains(estadoSig)  ) {
                this.estadosAceptacion.add(estadoSig);
            }
            this.transiciones.add(new transicion(estadoActual,new String[]{hsig.tipo,hsig.value},estadoSig));
        }     
    }   
    
    public boolean faltanEstados(){
        for (int i = 0; i < this.estados.size(); i++) {
            if (!this.transiciones.contains(new transicion(i, null, 0)) && !this.estados.get(i).equals(new ArrayList<>(List.of(this.centinela))) ) {
                return true;
            }
        }
        return false;
    }
    
    public int estadoQueFalta(){
        for (int i = 0; i < this.estados.size(); i++) {
            if (!this.transiciones.contains(new transicion(i, null, 0)) && !this.estados.get(i).equals(new ArrayList<>(List.of(this.centinela))) ) {
                return i;
            }
        }
        return -1; //Nunca va a devolver -1 porque el metodo nunca se va a ejecutar si todos los estados tienen transiciones
    }
    
    public void calcularTransiciones(ArrayList<Integer> estadoInicial){
        this.estados.add(estadoInicial);
        this.centinela = this.tbSig.hojasSig.size();
        while (faltanEstados()) {            
            calcularTransicionesDeUnEstado(this.estados.get(estadoQueFalta()));
        }
        obtenerTerminales();
        crearTabla();
    }
    
    public void crearTabla(){
        this.tablaTransiciones = new String[this.estados.size()][this.terminales.size()];
        for (transicion transicion : this.transiciones) {
            int posicion = this.terminales.indexOf(new terminal(new String[]{transicion.simbolo[0],transicion.simbolo[1]}));
            this.tablaTransiciones[transicion.estadoActual][posicion]= "S"+transicion.estadoSig;
        }
    }
    
    
    public void crearReporte(){
        String graphviz = "digraph {\n" +"  node [shape=plaintext]\n" +
                "  mytable [label=<<table border=\"0\" cellborder=\"1\" cellspacing=\"0\">\n"
                + "<tr><td colspan=\"1\" rowspan=\"2\"><b>Estado </b></td><td colspan=\""+this.terminales.size()+"\" ><b>Terminales</b></td></tr>\n"
                + "<tr>";
        for (terminal terminal : this.terminales) {
            graphviz += "<td>"+terminal.simbolo[1]+"</td>";
        }
        graphviz += "</tr>\n";
        for (int i = 0; i < this.estados.size(); i++) {
            if (this.estadosAceptacion.contains(i)) {
                graphviz += "<tr><td><b>S"+i+this.estados.get(i)+"</b></td>";
            }else{
                graphviz += "<tr><td>S"+i+this.estados.get(i)+"</td>";
            }
            for (String transicion : this.tablaTransiciones[i]) {
                if (transicion == null) {
                    graphviz += "<td>--</td>";
                    continue;
                }
                graphviz += "<td>"+transicion+"</td>";
            }
            graphviz += "</tr>\n";
        }
        graphviz += "  </table>>];\n" +
                "}";
        crearPNG.crearSalidaPNG(graphviz, "./TRANSICIONES_202103216/codigoDot.dot", "./TRANSICIONES_202103216/"+this.tbSig.id+".png");
        //*****AFD
        String graphvizAFD = "digraph finite_state_machine {\n" +
                "	fontname=\"Helvetica,Arial,sans-serif\"\n" +
                "	node [fontname=\"Helvetica,Arial,sans-serif\"]\n" +
                "	edge [fontname=\"Helvetica,Arial,sans-serif\"]\n" +
                "	rankdir=LR;\n" +
                "	node [shape = doublecircle];";
        for (Integer aceptacion : this.estadosAceptacion) {
            graphvizAFD += " S"+aceptacion+" ";
        }
        graphvizAFD += ";\n node [shape = circle];\n"
                + "inicio[label=\"\" shape=\"rectangule\" color=\"white\"];\n" +
                "    inicio -> S0 [label = \"Inicio\"];\n";
        for (transicion transicion : this.transiciones) {
            graphvizAFD += "S"+transicion.estadoActual+" -> S"+transicion.estadoSig+" [label = \""+transicion.simbolo[1]+"\"];\n";
        }
        graphvizAFD += "}";
        crearPNG.crearSalidaPNG(graphvizAFD, "./AFD_202103216/codigoDot.dot", "./AFD_202103216/"+this.tbSig.id+".png");
        //
    }
    
    //Obtiene Los terminales a partir de la tabla de siguientes
    public void obtenerTerminales(){
        for (hojaSig sig : this.tbSig.hojasSig) {
            if (!this.terminales.contains(new terminal(new String[]{sig.tipo,sig.value})) && !sig.tipo.equals("CENTINELA")) {
                this.terminales.add(new terminal(new String[]{sig.tipo,sig.value}));
            }
        }
    }
   


}

class terminal{
    String[] simbolo;
    terminal(String[] simbolo) {
        this.simbolo = simbolo;
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj instanceof terminal) {
            terminal term = (terminal) obj;
            return term.simbolo[0].equals(this.simbolo[0]) && term.simbolo[1].equals(this.simbolo[1]);
        }
        return false;
    }
}



//Nodo para formas una lista de transiciones
class transicion{

    int estadoActual,estadoSig;
    String[] simbolo;
    transicion(int estadoActual,String[] simbolo,int estadoSig) {
        this.estadoActual = estadoActual;
        this.simbolo = simbolo;
        this.estadoSig = estadoSig;
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj instanceof transicion) {
            transicion tran = (transicion) obj;
            return tran.estadoActual == this.estadoActual;
        }
        return false;
    }
    
}


