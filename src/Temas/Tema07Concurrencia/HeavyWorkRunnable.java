package Temas.Tema07Concurrencia;

/**
 * Ejemplo con threads que simular la ejecución de una tarea muy pesada
 * El orden de finalización de los hilos es impredecible
 */
public class HeavyWorkRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Realizando una tarea pesada: comienzo " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            //Get database connection, delete unused data from DB
            doDBProcessing();
        } catch (InterruptedException e) {
            // El método sleep() puede lanzar una excepción
            e.printStackTrace();
        }
        System.out.println("realizando una tarea pesada: final " + Thread.currentThread().getName());
    }

    private void doDBProcessing() throws InterruptedException {
        // Se realiza una operación con una base de datos que tarda un tiempo
        Thread.sleep(5000);
    }

    public static void main(String[] args) {
        new Thread(new HeavyWorkRunnable(), "hilo 1").start();
        new Thread(new HeavyWorkRunnable(), "hilo 2").start();
        new Thread(new HeavyWorkRunnable(), "hilo 3").start();
    }
}
