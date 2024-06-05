package Temas.Tema08Sincornizacion;

/**
 * Ejemplo de un metodo sincronizado en un objeto runnable
 */

class Tarea implements Runnable {
    private int contador = 0;
    public int getContador() {
        return contador;
    }
    private void incrementa() {
        contador += 1;
    }
    private synchronized void incrementaSincronizado() {
        incrementa();
    }

    @Override
    public void run() {
        // Probar a cambiar aquí por el método sincronizado
        for (int i = 0; i < 100000; i++) incrementaSincronizado();
    }
}
public class EjemploMetodosSincronizados {
    public static void main(String[] args) throws InterruptedException {
        Tarea task = new Tarea();
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
        thread1.join(); // esperamos a que finalice el primer hilo
        thread2.join(); // esperamos a que finalice el segundo hilo
        System.out.println(String.format("Valor del contador: %d", task.getContador()));
    }
}
