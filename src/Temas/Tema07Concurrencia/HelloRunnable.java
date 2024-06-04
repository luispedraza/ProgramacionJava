package Temas.Tema07Concurrencia;

/**
 * Ejemplo sencillo de cómo crear un Thread implementando en una clase
 * la interfaz Runnable
 */
public class HelloRunnable implements Runnable {
    /**
     * Debemos implementar el método run de la interfaz
     * Contiene el código que ejecutará el thread
     */
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hola desde un thread!");
        }
    }

    public static void main(String args[]) {
        // Creamos un nuevo objeto Thread
        // Usamos un objeto Runnable como parámetro del constructor del Thread
        // Invocamos el método start() NUNCA run()
        (new Thread(new HelloRunnable())).start();
    }
}