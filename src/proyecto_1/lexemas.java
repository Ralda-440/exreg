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
public class lexemas {
    static ArrayList<String[]> listLexemas = new ArrayList<>();
    
    static void imprimirLexemas(){
        System.out.println("LEXEMAS EN EL SISTEMA");
        for (String[] lexema : listLexemas) {
            System.out.println("ID: "+lexema[0]+" VALUE: "+lexema[1]);
        }
    }
}
