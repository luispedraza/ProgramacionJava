package Temas.Tema09Planificacion;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Adaptado de: https://medium.com/@erayaraz10/a-comprehensive-guide-to-thread-pools-in-java-75a06657fda
public class FixedThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            executor.execute(new Tarea(i));
        }

        executor.shutdown();
    }

}