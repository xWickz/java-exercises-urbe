package ejercicio_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
En el programa pedirá un número factorial, luego, en un archivo llamado resultado.txt
se generará los números factoriales uno por uno hasta llegar al deseado, es decir, si pide
factorial de 5, irá mostrando los resultados 1x1 por hasta llegar al número final.
*/

public class Main {
    public static void main(String[] args) {

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

        try(PrintWriter pw = new PrintWriter("C:\\xampp\\htdocs\\pruebas\\src\\ejercicio_2\\resultado.txt")) {
            pw.printf("%s", pasos);
            pw.flush();
            System.out.println("Resultado guardado en resultado.txt");
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
