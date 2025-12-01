package ejercicio_2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/*
En el programa pedirá un número factorial, luego, en un archivo llamado resultado.txt
se generará los números factoriales uno por uno hasta llegar al deseado, es decir, si pide
factorial de 5, irá mostrando los resultados 1x1 por hasta llegar al número final.
*/

public class Main {
    public static void main(String[] args) {

        FileOutputStream fileOutputStream = null;
        PrintWriter printWriter = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Programa de Factorial");
        System.out.print("Ingrese el numero: ");
        int numero = scanner.nextInt();

        scanner.close();

        int contador = 0;
        int resultado = numero;
        String pasos = "";

        for(int i = numero - 1; i >= 1; i--) {
            contador++;
            resultado = resultado * i;
            if(i == 1) {
                pasos += resultado + " (*) "; // Siendo que (*) marca el final
            } else {
                pasos += resultado + " ";
            }

            if(contador % 5 == 0) 
                pasos += "\n";
            
        }

        System.out.println("Resultado guardado en resultado.txt");
        
        try {
            fileOutputStream = new FileOutputStream("C:\\xampp\\htdocs\\pruebas\\src\\ejercicio_2\\resultado.txt");
            printWriter = new PrintWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            
            printWriter.printf("%s", pasos);
            printWriter.flush();

        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Should work fine, lol
                if(fileOutputStream != null)
                    fileOutputStream.close();
                if(printWriter != null)
                    printWriter.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
