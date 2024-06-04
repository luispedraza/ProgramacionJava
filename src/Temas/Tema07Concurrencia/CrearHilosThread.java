/**
 * Ejemplo de creación de hilos extendiendo la clase Thread
 * Siempre debemos implementar el método run()
 */

package Temas.Tema07Concurrencia;

// Un hilo extiende la clase Thread
class MiThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) System.out.println("Ejecutando el hilo");
    }
}



public class CrearHilosThread {
    public static void main(String[] args) {
        // Creación y ejecución del hilo
        MiThread hilo1 = new MiThread();
        hilo1.start();
    }
}
