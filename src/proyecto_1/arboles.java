/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author sergi
 */
public class arboles {
    static ArrayList<arbol> listArboles = new ArrayList<>();
    static void crearArboles(ArrayList<nodoExprRegular> listExprRegulares){
        listArboles.clear();
        for (nodoExprRegular exprRegular : listExprRegulares) {
            listArboles.add(new arbol(exprRegular.id,exprRegular.expr));
            listArboles.get(listArboles.size()-1).crearArbol();
            listArboles.get(listArboles.size()-1).crearReporte();
        }
    }
}

class arbol {
    //Numero de Estado AFND
    static int noEstado=0;
    //
    hoja raiz,aux;
    String id,graphviz ="",graphvizAFND="";
    ArrayList<terminoExpr> terminosExpr;
    Stack<hoja> pila = new Stack<>();
    tablaSiguientes tbSiguientes;
    tablaTransiciones tbTransiciones;
    arbol(String id,ArrayList<terminoExpr> terminosExpr) {
       this.raiz = null;
       this.id = id;
       this.terminosExpr = terminosExpr;
       this.graphviz += "}";
       this.tbSiguientes = new tablaSiguientes(this.id);
       this.tbTransiciones = new tablaTransiciones(this.tbSiguientes);
    }  
    
    @Override
    public boolean equals(Object obj){
        if (obj instanceof arbol) {
            arbol arbol = (arbol) obj;
            return arbol.id.equals(this.id);
        }
        return false;
    }
    
    public void crearReporte(){
        crearPNG.crearSalidaPNG(this.graphviz,"./ARBOLES_202103216/codigoDot.dot","./ARBOLES_202103216/"+this.id+".png");
    }
    
    public void crearArbol(){
        noEstado = 0;
        int idHoja = 1;
        while (!this.terminosExpr.isEmpty()) {
            this.aux = new hoja(this.terminosExpr.get(0).tipo,this.terminosExpr.get(0).value);
            this.terminosExpr.remove(0);
            if (this.aux.tipo.equals("CONCATENACION") | this.aux.tipo.equals("DISYUNCION")) {
                this.aux.der = this.pila.pop();
                this.aux.izq = this.pila.pop();
                //**********
                if (this.aux.tipo.equals("DISYUNCION")) {
                    //Anulable
                    this.aux.anulable = this.aux.izq.anulable | this.aux.der.anulable;
                    //Primeros
                    this.aux.primeros.addAll(this.aux.izq.primeros);
                    this.aux.primeros.addAll(this.aux.der.primeros);
                    //Ultimos
                    this.aux.ultimos.addAll(this.aux.izq.ultimos);
                    this.aux.ultimos.addAll(this.aux.der.ultimos); 
                }else{
                    //Anulable
                    this.aux.anulable = this.aux.izq.anulable && this.aux.der.anulable;
                    //Primeros
                    this.aux.primeros.addAll(this.aux.izq.primeros);
                    if (this.aux.izq.anulable) {
                        this.aux.primeros.addAll(this.aux.der.primeros);
                    }
                    //Ultimos
                    this.aux.ultimos.addAll(this.aux.der.ultimos);
                    if (this.aux.der.anulable) {
                        this.aux.ultimos.addAll(0, this.aux.izq.ultimos);
                    }  
                }
                //**********
                //**********Tabla Siguientes
                tbSiguientes.calcularSigConcatenacion(this.aux);
                //
                this.graphviz = String.valueOf(this.aux.hashCode())+" [label=\""+this.aux.anulable+"\\n"+this.aux.primeros+"    "+this.aux.value+"    "+this.aux.ultimos+"\"] ; \n "
                        + String.valueOf(this.aux.hashCode())+" -- "+String.valueOf(this.aux.izq.hashCode())+" ; \n "
                        + String.valueOf(this.aux.izq.hashCode())+" [label=\""+this.aux.izq.anulable+"\\n"+this.aux.izq.primeros+"    "+this.aux.izq.value+"    "+this.aux.izq.ultimos+"\\n"+this.aux.izq.id+"\"] ; \n "
                        + String.valueOf(this.aux.hashCode())+" -- "+String.valueOf(this.aux.der.hashCode())+" ; \n "
                        + String.valueOf(this.aux.der.hashCode())+" [label=\""+this.aux.der.anulable+"\\n"+this.aux.der.primeros+"    "+this.aux.der.value+"    "+this.aux.der.ultimos+"\\n"+this.aux.der.id+"\"] ; \n"+this.graphviz;
            }else if (this.aux.tipo.equals("C_KLEENE") | this.aux.tipo.equals("C_POSITIVA") | this.aux.tipo.equals("OPCIONAL")) {
                this.aux.der = this.pila.pop();
                //**********
                //Anulable
                if (this.aux.tipo.equals("C_POSITIVA")) {
                    this.aux.anulable = this.aux.der.anulable;
                }else{
                    this.aux.anulable = true;
                }
                //Primeros
                this.aux.primeros.addAll(this.aux.der.primeros);
                //Ultimos
                this.aux.ultimos.addAll(this.aux.der.ultimos);
                //**********
                //**********Tabla Siguientes
                tbSiguientes.calcularSigKleenePositiva(this.aux);
                //
                this.graphviz = String.valueOf(this.aux.hashCode())+" [label=\""+this.aux.anulable+"\\n"+this.aux.primeros+"    "+this.aux.value+"    "+this.aux.ultimos+"\"] ; \n "
                        + String.valueOf(this.aux.hashCode())+" -- "+String.valueOf(this.aux.der.hashCode())+"; \n "
                        + String.valueOf(this.aux.der.hashCode())+" [label=\""+this.aux.der.anulable+"\\n"+this.aux.der.primeros+"    "+this.aux.der.value+"    "+this.aux.der.ultimos+"\\n"+this.aux.der.id+"\"] ; \n"+this.graphviz;
            }else{
                this.aux.anulable = false;
                this.aux.primeros.add(idHoja);
                this.aux.ultimos.add(idHoja);
                this.aux.id = idHoja;
                idHoja++;
                //Agregando hoja a la tabla de siguientes
                tbSiguientes.hojasSig.add(new hojaSig(this.aux.tipo,this.aux.value,this.aux.id));
            }
            this.pila.push(this.aux);
            
        }
        this.raiz = this.pila.pop();
        this.graphviz = "graph G { \n label=\"Arbol Expresion Regular: "+id+"\"; \n labelloc=\"t\"; \n fontname=\"Helvetica,Arial,sans-serif\" \n"
               + " node [fontname=\"Helvetica,Arial,sans-serif\"] \n"
               + "edge [fontname=\"Helvetica,Arial,sans-serif\"] \n "+this.graphviz;
        tbSiguientes.crearReporte();//Tabla de Siguientes
        this.tbTransiciones.calcularTransiciones(this.raiz.primeros);
        this.tbTransiciones.crearReporte(); //Tabla de Transiciones y AFD
        //AFND
        this.graphvizAFND = this.raiz.izq.graphviz();
        this.graphvizAFND = "digraph finite_state_machine {\n" +
                "	fontname=\"Helvetica,Arial,sans-serif\"\n" +
                "	node [fontname=\"Helvetica,Arial,sans-serif\"]\n" +
                "	edge [fontname=\"Helvetica,Arial,sans-serif\"]\n" +
                "	rankdir=LR;\n" +
                "	node [shape = doublecircle]; S"+noEstado+" ;\n" +
                "    node [shape = circle];\n" +
                "    inicio[label=\"\" shape=\"rectangule\" color=\"white\"];\n" +
                "    inicio -> S0 [label = \"Inicio\"];\n"+this.graphvizAFND+"}";
        crearPNG.crearSalidaPNG(this.graphvizAFND, "./AFND_202103216/codigoDot.dot", "./AFND_202103216/"+this.id+".png");
        //
    }
       
}

class hoja{
    String tipo,value;
    int id=0;
    boolean anulable;
    ArrayList<Integer> primeros,ultimos;
    hoja izq,der;
    hoja(String tipo,String value) {
        this.tipo = tipo;
        this.value = value;
        this.primeros = new ArrayList<>();
        this.ultimos = new ArrayList<>();
    }
    
    String graphviz(){
        String graphviz = "";
        int aux1,aux2;
        switch (this.tipo) {
            case "CONCATENACION":
                graphviz = this.izq.graphviz()+this.der.graphviz();
                break;
            case "DISYUNCION":
                int nodoInicio = arbol.noEstado;
                graphviz += "S"+ arbol.noEstado +" -> S"+ ++arbol.noEstado +" [label = \"ε\"];\n"+
                        this.izq.graphviz();
                aux1 = arbol.noEstado;
                graphviz += "S"+nodoInicio+" -> S"+ ++arbol.noEstado +" [label = \"ε\"];\n"+
                        this.der.graphviz()+
                        "S"+arbol.noEstado+" -> S"+ ++arbol.noEstado +" [label = \"ε\"];\n";
                graphviz += "S"+aux1+" -> S"+arbol.noEstado+" [label = \"ε\"];\n";
                break;
            case "C_KLEENE":
                aux1 = arbol.noEstado;
                graphviz += "S"+arbol.noEstado+" -> S"+ ++arbol.noEstado +" [label = \"ε\"];\n";
                aux2 = arbol.noEstado;
                graphviz += this.der.graphviz();
                graphviz += "S"+arbol.noEstado+" -> S"+aux2+" [label = \"ε\"];\n";
                graphviz += "S"+arbol.noEstado+" -> S"+ ++arbol.noEstado +" [label = \"ε\"];\n";
                graphviz += "S"+aux1+" -> S"+arbol.noEstado+" [label = \"ε\"];\n";
                break;
            case "C_POSITIVA":
                graphviz += "S"+arbol.noEstado+" -> S"+ ++arbol.noEstado +" [label = \"ε\"];\n";
                aux1 = arbol.noEstado;
                graphviz += this.der.graphviz();
                graphviz += "S"+arbol.noEstado+" -> S"+aux1+" [label = \"ε\"];\n";
                graphviz += "S"+arbol.noEstado+" -> S"+ ++arbol.noEstado +" [label = \"ε\"];\n";
                break;
            case "OPCIONAL":
                aux1 = arbol.noEstado;
                graphviz += "S"+arbol.noEstado+" -> S"+ ++arbol.noEstado +" [label = \"ε\"];\n";
                graphviz += this.der.graphviz();
                graphviz += "S"+arbol.noEstado+" -> S"+ ++arbol.noEstado +" [label = \"ε\"];\n";
                graphviz += "S"+aux1+" -> S"+arbol.noEstado+" [label = \"ε\"];\n";
                break;
            default:
                graphviz += "S"+ arbol.noEstado +" -> S"+ ++arbol.noEstado +" [label = \""+this.value+"\"];\n";     
        }
        return graphviz;
    }
}