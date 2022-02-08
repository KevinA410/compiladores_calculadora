/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;
import analizadores.Lexico;
import analizadores.Sintactico;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
/**
 *
 * @author kevin
 */
public class Calculadora {
    /**
     * @param args argumentos de la linea de comando
     */
    private static String path = "/home/kevin/NetBeansProjects/calc/src/calculadora/entrada.txt";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Operacion: ");
        String text = sc.nextLine();
        
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(text);
            writer.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
        
        System.out.print("Resultado: " + text);
        interpretar(path);
    }
    /**
     * Método que interpreta el contenido del archivo que se encuentra en el path
     * que recibe como parámentro
     * @param path ruta del archivo a interpretar
     */
    private static void interpretar(String path) {
        Sintactico pars;
        try {
           Reader lector = new BufferedReader(new FileReader(path)); 
           pars=new Sintactico(new Lexico(lector));
           pars.parse();        
        } catch (Exception ex) {
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println("Causa: "+ex.getCause());
        } 
    }
}
