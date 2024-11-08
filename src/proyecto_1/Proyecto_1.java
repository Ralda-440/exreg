/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package proyecto_1;

import java.io.File;
/**
 *
 * @author sergi
 */ 
public class Proyecto_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*
        //Borra archivos .java generados por jflex y cup
        File file = new File("./src/proyecto_1/lexer.java");
        file.delete();
        file = new File("./src/proyecto_1/parser.java");
        file.delete();
        file = new File("./src/proyecto_1/sym.java");
        file.delete();
        
       
        try {
            jflex.Main.generate(new String[]{"-d","./src/proyecto_1/","./src/proyecto_1/lexico.jflex"});
        } catch (jflex.exceptions.SilentExit e) {
            System.out.println("Error al generar lexico : "+e.getMessage());
        }
        try {
            java_cup.Main.main(new String[]{"-destdir","./src/proyecto_1/","./src/proyecto_1/sintactico.cup"});
        } catch (Exception e) {
            System.out.println("Error al generar Sintactico :"+e.getMessage());
        }
        */
        
        //Creando Directorios
            
        String [] paths_directorios = {"./ARBOLES_202103216","./AFD_202103216","./AFND_202103216","./SIGUIENTES_202103216",
        "./TRANSICIONES_202103216","./ERRORES_202103216","./SALIDAS_202103216"};
        
        for (String path : paths_directorios){
            File directorio = new File(path);
            if (directorio.exists()) {
                directorio.delete();
            }
            directorio.mkdirs();
        }
             
        //Inicia la ventana del programa
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new exregan().setVisible(true);
            }
        });
        
    }
    
}

