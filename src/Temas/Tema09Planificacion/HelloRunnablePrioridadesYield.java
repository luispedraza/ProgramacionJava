package Temas.Tema09Planificacion;

/**
 * Ejemplo sencillo de cómo crear un Thread implementando en una clase
 * la interfaz Runnable
 * Creamos tres threads con nombres diferentes
 * Mismo ejemplo del tema 7, aquí usando prioridades diferentes para cada hilo
 * En este caso mostramos también el uso de yield()
 */
public class HelloRunnablePrioridadesYield implements Runnable {
    /**
     * Debemos implementar el método run de la interfaz
     * Contiene el código que ejecutará el thread
     */
    public void run() {
        String name = Thread.currentThread().getName(); // el nombre del Thread actual
        for (int i = 0; i < 100; i++) {
            System.out.println("Hola desde el thread " + name);

            if ((i % 2 == 0) && Thread.currentThread().getPriority() == Thread.MIN_PRIORITY)
                Thread.yield();
                // Procesos con prioridad MIN_PRIORITY solo puede llegar a ejecutar 2 ciclos seguidos
            if ((i % 10 == 0) && Thread.currentThread().getPriority() == Thread.NORM_PRIORITY)
                Thread.yield();
            // Procesos con prioridad NORM_PRIORITY solo puede llegar a ejecutar 10 ciclos seguidos

        }

        System.out.println("========> Fin de la tarea: " + name);
    }

    public static void main(String args[]) {
        // Creamos un nuevo objeto Thread
        // Usamos un objeto Runnable como parámetro del constructor del Thread
        Thread thread1 = new Thread(new HelloRunnablePrioridadesYield(), "UNO");
        Thread thread2 = new Thread(new HelloRunnablePrioridadesYield(), "DOS");
        Thread thread3 = new Thread(new HelloRunnablePrioridadesYield(), "TRES");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}