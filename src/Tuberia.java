import java.io.*;

public class Tuberia {
    public static void main(String[] args) {
        long pid = creaProcesoCD();
        System.out.println("------");
        System.out.println(pid);
        creaProcesoTaskkill(pid);
    }

    private static long creaProcesoCD() {
        long resultado = 0;
        ProcessBuilder pbCD =new ProcessBuilder("Notepad");
        try {
            Process procesoCD = pbCD.start();
            System.out.println(procesoCD.pid());
           // BufferedReader brLector = new BufferedReader(new InputStreamReader(procesoCD.getInputStream()));
            resultado = procesoCD.pid();
        } catch (IOException e) {
            System.out.println("No se pudo iniciar el proceso: " + e.getMessage());
        }

        return resultado;
    }

    private static void creaProcesoTaskkill(long PID) {
        ProcessBuilder pbTK = new ProcessBuilder("taskkill", "/f", "/pid", String.valueOf(PID));
        try
        {
            Process procesoTK=pbTK.start();
            System.out.println("PID del nuevo proceso: " + procesoTK.pid());
            if(procesoTK.isAlive())
                System.out.println("El proceso está activo");
        }
        catch (IOException e)
        {
            System.out.println("No se pudo iniciar el proceso: " + e.getMessage());
        }

    }

}