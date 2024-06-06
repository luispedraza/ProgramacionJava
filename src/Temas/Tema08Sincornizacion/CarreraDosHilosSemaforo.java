/**
 * Este ejemplo motiva la necesidad de sincronización entre hilos
 * Creamos dos hilos:
 * - Uno de ellos incrementa un número de veces una variable estática una cierta cantidad
 * - Otro de ellos decrementa el mismo número de veces la misma variable la misma cierta cantidad
 * Si la variable inicialmente vale cero, el resoltado final debería ser cero, pero...
 *
 * AQUÍ RESOLVEMOS LA CONDICION DE CARRERA EMPLEANDO UN SEMÁFORO
 */

package Temas.Tema08Sincornizacion;

import java.util.concurrent.Semaphore;

class MiThreadSemaforo extends  Thread {

    public static int x = 0;
    private int incremento = 0;
    private static Semaphore semaforo = new Semaphore(1);

    public MiThreadSemaforo (int incremento) {
        this.incremento = incremento;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            try {
                semaforo.acquire(); // WAIT
                x += incremento;
                // System.out.println(x);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaforo.release(); // SIGNAL
            }
        }
    }
}

public class CarreraDosHilosSemaforo {

    public static void main(String[] args) throws InterruptedException{
        MiThreadSemaforo thread1 = new MiThreadSemaforo(1);
        MiThreadSemaforo thread2 = new MiThreadSemaforo(-1);
        thread1.start();
        thread2.start();
        // Esperamos a que los dos hilos finalicen
        thread1.join();
        thread2.join();
        // Valor final del contador:
        System.out.println(String.format("Valor final: %d", MiThreadSemaforo.x));
    }
}
