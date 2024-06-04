package Temas.Tema07Concurrencia;

/**
 * Ejemplo sencillo de cómo crear un Thread
 */
public class HelloThread extends Thread {
    // Debemos sobreescribir el método run() de la clase Thread
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hola desde un thread!");
        }
    }

    public static void main(String args[]) {

        (new HelloThread()).start();
    }
}