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
public class exprRegulares {
        static ArrayList<nodoExprRegular> listExprRegulares = new ArrayList<>();
        static ArrayList<nodoConjunto> conjuntos = new ArrayList<>();
}


class nodoConjunto{

    String id,tipo;
    ArrayList<String> value;    
    nodoConjunto(String tipo,String id, ArrayList<String> value) {
        this.tipo = tipo;
        this.id = id;
        this.value = new ArrayList<>(value);
    }
    
    String notacionRegex(){
        if (this.tipo.equals("RANGO")) {
            return "["+this.value.get(0)+"-"+this.value.get(1)+"]";
        }else if (this.tipo.equals("RANGO_ESPECIAL")) {
            return "["+this.value.get(0)+"-"+this.value.get(1)+"&&[^A-Za-z0-9]]";
        }
        return "["+String.join("", this.value)+"]";
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj instanceof nodoConjunto) {
            nodoConjunto conjunto = (nodoConjunto) obj;
            return conjunto.id.equals(this.id);
        }
        return false;
    }
    
}

class nodoExprRegular{
    String id;
    ArrayList<terminoExpr> expr;
    nodoExprRegular(String id,ArrayList<terminoExpr> expr) {
        this.id = id;
        this.expr = new ArrayList<>(expr);
    }    
}

class terminoExpr{
    String tipo,value;
    terminoExpr(String tipo,String value){
        this.tipo = tipo;
        this.value = value;
    }
}
