/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * @author sergi
 */

public class errores {
    static ArrayList<error> listaErrores = new ArrayList<>();
    
    static void reporteHtmlErrores(){
        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset='utf-8'>\n" +
                "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>\n" +
                "    <title>REPORTE ERRORES</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "    <table border=\"5\">\n" +
                "        <tr>\n" +
                "            <td>  #  </td>\n" +
                "            <td>  Tipo de Error  </td>\n" +
                "            <td>  Descripcion  </td>\n" +
                "            <td>  Linea  </td>\n" +
                "            <td>  Columna  </td>\n" +
                "        </tr>\n";
        for (int i = 0; i < listaErrores.size(); i++) {
            html += "        <tr>\n"+
                    "            <td>  "+i+1+"  </td>\n"+
                    "            <td>  "+listaErrores.get(i).tipo +"  </td>\n"+
                    "            <td>  "+listaErrores.get(i).descripcion +"  </td>\n"+
                    "            <td>  "+listaErrores.get(i).linea +"  </td>\n"+
                    "            <td>  "+listaErrores.get(i).columna +"  </td>\n"+
                    "        </tr>\n";
        }
        html += "    </table>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        File fileDot = new File("./ERRORES_202103216/Errores.html");
        try {
            //PrintWriter pw = new PrintWriter(fileDot);
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileDot),StandardCharsets.UTF_8));
            pw.println(html);
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR AL CREAR EL ARCHIVO ERRORES: "+e.getMessage());
        }
    }
}

class error{
    String tipo,descripcion;
    int linea,columna;
    public error(String tipo,String descripcion,int linea,int columna){
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.linea = linea;
        this.columna = columna;
    } 
}
