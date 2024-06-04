package Temas.Tema07Concurrencia;

/**
 * Ejemplo sencillo de cómo crear un Thread implementando en una clase
 * la interfaz Runnable
 * Creamos tres threads con nombres diferentes
 */
public class HelloRunnableNombres implements Runnable {
    /**
     * Debemos implementar el método run de la interfaz
     * Contiene el código que ejecutará el thread
     */
    public void run() {
        String name = Thread.currentThread().getName(); // el nombre del Thread actual
        for (int i = 0; i < 100; i++) {
            System.out.println("Hola desde el thread " + name);
        }
    }

    public static void main(String args[]) {
        // Creamos un nuevo objeto Thread
        // Usamos un objeto Runnable como parámetro del constructor del Thread
        Thread thread1 = new Thread(new HelloRunnableNombres(), "UNO");
        Thread thread2 = new Thread(new HelloRunnableNombres(), "DOS");
        Thread thread3 = new Thread(new HelloRunnableNombres(), "TRES");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}