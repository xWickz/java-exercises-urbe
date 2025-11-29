package ejercicio_1;
import java.io.*;
import java.nio.charset.StandardCharsets;

/*
input.txt
- cantidad de alumnos
- notas de los alumnos (3)
*/

/*
output.txt
- alumno, promedio
- promedio general
*/

public class Main {
    public static void main(String[] args) {

        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        try {

            fileInputStream = new FileInputStream("C:\\xampp\\htdocs\\pruebas\\src\\ejercicio_1\\input.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));

            fileOutputStream = new FileOutputStream("C:\\xampp\\htdocs\\pruebas\\src\\ejercicio_1\\output.txt");
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));

            String linea = br.readLine();
            int cantidad = Integer.parseInt(linea.trim());

            final int MATERIAS = 3;
            double sumaTotal = 0;
            int totalNotas = cantidad * MATERIAS;

            pw.println("Resultado de notas");
            for(int i = 1; i <= cantidad; i++) {
                String notasLinea = br.readLine().trim();
                String[] partes = notasLinea.split("\\s+");
                if(partes.length != MATERIAS) {
                    pw.printf("El alumno %d no tiene exactamente %d notas.\n", i, MATERIAS);
                    pw.flush();
                    continue;
                }

                int[] notas = new int[MATERIAS];
                double sumaAlumno = 0;
                for(int j = 0; j < MATERIAS; j++) {
                    notas[j] = Integer.parseInt(partes[j]);
                    sumaAlumno += notas[j];
                    sumaTotal += notas[j];
                }

                double promedio = sumaAlumno / MATERIAS;
                pw.printf("Alumno %d - Promedio: %.2f%n", i, promedio);
            }

            double promedioGeneral = sumaTotal / totalNotas;
            pw.println();
            pw.printf("Promedio general: %.2f%n", promedioGeneral);
            pw.flush();

            System.out.println("Listo");

        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileInputStream != null) {
                    fileInputStream.close();
                }
                if(fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}