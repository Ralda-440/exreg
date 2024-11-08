/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1;

import java.util.ArrayList;
/**
 *
 * @author sergi
 */


public class tablaSiguientes {
    ArrayList<hojaSig> hojasSig = new ArrayList<>();
    String graphviz,id;
    
    public tablaSiguientes(String id) {
        this.id = id;
    } 
      
    void calcularSigKleenePositiva(hoja hoja){
        if (hoja.tipo.equals("OPCIONAL")) {
            return;
        }
        for (Integer ultimo : hoja.der.ultimos) {
            hojasSig.get(ultimo-1).siguientes.addAll(hoja.der.primeros);
        }
    }
    
    void calcularSigConcatenacion(hoja hoja){
        if (!hoja.tipo.equals("CONCATENACION")) {
            return;
        }
        for (Integer ultimo : hoja.izq.ultimos) {
            hojasSig.get(ultimo-1).siguientes.addAll(hoja.der.primeros);
        }
    }
    
    public void crearReporte(){
        this.graphviz = "digraph {\n" +
                "  node [shape=plaintext]\n" +
                "  mytable [label=<<table border=\"0\" cellborder=\"1\" cellspacing=\"0\">\n" +
                "  <tr><td colspan=\"2\"><b>Hoja</b></td><td><b>Siguientes</b></td></tr>\n";
        for (hojaSig sig : hojasSig) {
            this.graphviz += "<tr><td>"+sig.value+"</td><td>"+sig.idHoja+"</td><td>"+sig.siguientes+"</td></tr>\n";
        }
        this.graphviz += "  </table>>];\n" +"}";
        crearPNG.crearSalidaPNG(this.graphviz,"./SIGUIENTES_202103216/codigoDot.dot","./SIGUIENTES_202103216/"+this.id+".png");
    }
}

class hojaSig{
    String value,tipo;
    int idHoja;
    ArrayList<Integer> siguientes;
    
    hojaSig(String tipo,String value,int idHoja) {
        this.tipo = tipo;
        this.value = value;
        this.idHoja = idHoja;
        this.siguientes = new ArrayList<>();
    }
    
}
