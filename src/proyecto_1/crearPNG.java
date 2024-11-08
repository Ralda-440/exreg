/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergi
 */
public class crearPNG {
    static void crearSalidaPNG(String graphviz,String rutaDot,String rutaPNG){
        File fileDot = new File(rutaDot);
        try {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileDot),StandardCharsets.UTF_8));
            pw.println(graphviz);
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR AL CREAR EL ARCHIVO DOT: "+e.getMessage());
        }
        try {
            ProcessBuilder builder = new ProcessBuilder(new String[]{"dot","-Tpng","-o","\""+rutaPNG,"\"","\""+rutaDot+"\""});
            Process process = builder.start();
            process.waitFor();
        } catch (IOException e) {
            System.out.println("ERROR GENERAR ARCHIVO PNG : "+e.getMessage());
        } catch (InterruptedException ex) {
            Logger.getLogger(arbol.class.getName()).log(Level.SEVERE, null, ex);
        }
        fileDot.delete();
    }
}