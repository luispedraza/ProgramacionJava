package Temas.Tema07Concurrencia;


class MiRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) System.out.println("Ejecutando el hilo");
    }
}

public class CrearHilosRunnable {

    public static void main(String[] args) {
        // Creación y ejecución del hilo
        // Cramos un hilo genérico y pasamos al constructor nuestra tarea
        Thread hilo1 = new Thread(new MiRunnable());
        hilo1.start();
    }
}
