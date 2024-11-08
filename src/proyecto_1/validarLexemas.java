/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JTextArea;
import org.json.JSONObject;
import org.json.JSONArray;
/**
 *
 * @author sergi
 */
public class validarLexemas {
    
    static String nombreArchivo = "";
    static ArrayList<transicion> transiciones;
    static ArrayList<Integer> estadosAceptacion;
    static arbol arbol;
    static int estadoActual;
    static String cadena;
    static ArrayList<nodoConjunto> lConjuntos;
    
    static void validar(JTextArea consola){
        ArrayList<arbol> lArboles = arboles.listArboles;
        ArrayList<String[]> lLexemas = lexemas.listLexemas;
        JSONArray resultadosLexemas = new JSONArray();
        lConjuntos = exprRegulares.conjuntos;
        for (String[] lexema : lLexemas) {
            if (lArboles.contains(new arbol(lexema[0],new ArrayList<>()))) {
                arbol = lArboles.get(lArboles.indexOf(new arbol(lexema[0], new ArrayList<>())));
                transiciones  = arbol.tbTransiciones.transiciones;
                estadosAceptacion = arbol.tbTransiciones.estadosAceptacion;
                cadena = lexema[1];
                JSONObject resultado = new JSONObject();
                resultado.put("Valor", lexema[1]);
                resultado.put("ExpresionRegular", arbol.id);
                if (cadenaValida()) {
                    consola.append("La Expresion: \""+lexema[1]+"\" es valida con la expresion Regular : "+arbol.id+"\n");
                    resultado.put("Resultado", "Cadena Valida");
                }else{
                    resultado.put("Resultado", "Cadena No Valida");
                    consola.append("La Expresion: \""+lexema[1]+"\" no es valida con la expresion Regular : "+arbol.id+"\n");
                }
                resultadosLexemas.put(resultado);
                continue;
            }
            System.out.println("El id del lexema es incorrecto");
        }
        //CREAR REPORTE JSON
        File fileDot = new File("./SALIDAS_202103216/"+nombreArchivo+".json");
        try {
            PrintWriter pw = new PrintWriter(fileDot);
            pw.println(resultadosLexemas.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR AL CREAR EL ARCHIVO JSON: "+e.getMessage());
        }
    }
    
    static boolean cadenaValida(){
        estadoActual = 0;
        while (!cadena.isEmpty()) {
            if (!existeCoincidencia()) {
                return false;
            }
        }
        return estadosAceptacion.contains(estadoActual);
    }
    
    static boolean existeCoincidencia(){
        String subCadena;
        for (transicion transicion : transiciones) {
            if (!(transicion.estadoActual == estadoActual)) {
                continue;
            }
            switch (transicion.simbolo[0]) {
                case "STRING":
                    if (!(cadena.length() >= transicion.simbolo[1].length())) {
                        continue;
                    }
                    subCadena = cadena.substring(0, transicion.simbolo[1].length());
                    if (subCadena.equals(transicion.simbolo[1])) {
                        estadoActual = transicion.estadoSig;
                        cadena = cadena.substring(transicion.simbolo[1].length(),cadena.length());
                        return true;
                    }
                    break;
                case "CONJUNTO":
                    if (!(cadena.length() >= 1)) {
                        continue;
                    }
                    subCadena = cadena.substring(0, 1);
                    if (Pattern.matches(lConjuntos.get(lConjuntos.indexOf(new nodoConjunto("", transicion.simbolo[1], new ArrayList<>()))).notacionRegex(),subCadena)) {
                        estadoActual = transicion.estadoSig;
                        cadena = cadena.substring(1,cadena.length());
                        return true;
                    }
                    break;
                case "SALTO_LINEA":
                    if (!(cadena.length() >= transicion.simbolo[1].length()-1)) {
                        continue;
                    }
                    subCadena = cadena.substring(0, transicion.simbolo[1].length()-1);
                    if (subCadena.equals("\\n")) {
                        estadoActual = transicion.estadoSig;
                        cadena = cadena.substring(transicion.simbolo[1].length()-1,cadena.length());
                        return true;
                    }
                    break;
                case "COMILLA_SIMPLE":
                    if (!(cadena.length() >= transicion.simbolo[1].length()-1)) {
                        continue;
                    }
                    subCadena = cadena.substring(0, transicion.simbolo[1].length()-1);
                    if (subCadena.equals("\'")) {
                        estadoActual = transicion.estadoSig;
                        cadena = cadena.substring(transicion.simbolo[1].length()-1,cadena.length());
                        return true;
                    }
                    break;
                case "COMILLA_DOBLE":
                    if (!(cadena.length() >= transicion.simbolo[1].length()-1)) {
                        continue;
                    }
                    subCadena = cadena.substring(0, transicion.simbolo[1].length()-1);
                    if (subCadena.equals("\"")) {
                        estadoActual = transicion.estadoSig;
                        cadena = cadena.substring(transicion.simbolo[1].length()-1,cadena.length());
                        return true;
                    }
                    break;
            }
        }
        return false;
    }
    
    
}
