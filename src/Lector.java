import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Lector {

    public static void main(String[] args) throws InterruptedException {
        System.out.print("Introduce un número: ");
        int numero = Entrada.entero();
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"),
                "C:\\Users\\usuario\\IdeaProjects\\Fernandez_Mateo_Alberto_PSP01_TareaComunicacionProcesos\\src\\Escritor.java"
        );
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        try {
            Process proceso = pb.start();
            try (BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()))) {
                escritor.write(Integer.toString(numero));
                escritor.newLine();
            }
            try (BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                String linea;
                while ((linea = lector.readLine()) != null) {
                    System.out.println(linea);
                }
            }
            proceso.waitFor();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
