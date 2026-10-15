import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.Scanner;

public class Escritor {
    public static void main(String[] args) {
        int numero = Entrada.entero();
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + i);
        }
    }
}
