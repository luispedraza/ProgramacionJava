/**
 * Este ejemplo motiva la necesidad de sincronización entre hilos
 * Creamos dos hilos:
 * - Uno de ellos incrementa un número de veces una variable estática una cierta cantidad
 * - Otro de ellos decrementa el mismo número de veces la misma variable la misma cierta cantidad
 * Si la variable inicialmente vale cero, el resoltado final debería ser cero, pero...
 *
 * AQUÍ RESOLVEMOS LA CONDICION DE CARRERA EMPLEANDO UN BLOQUE SINCRONIZADO
 */

package Temas.Tema08Sincornizacion;

import java.util.concurrent.Semaphore;

class MiThreadSynchronizedBlock extends  Thread {

    public static int x = 0;
    private static Object obj = new Object();
    private int incremento;
    public MiThreadSynchronizedBlock (int incremento) {
        this.incremento = incremento;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            synchronized (obj) {
                this.x += incremento;
                // System.out.println(this.x);
            }

        }
    }
}

public class CarreraDosHilosSynchronizedBlock {
    public static void main(String[] args) throws InterruptedException {
        MiThreadSynchronizedBlock thread1 = new MiThreadSynchronizedBlock(1);
        MiThreadSynchronizedBlock thread2 = new MiThreadSynchronizedBlock(-1);
        thread1.start();
        thread2.start();
        // Esperamos a que los dos hilos finalicen
        thread1.join();
        thread2.join();
        // Valor final del contador:
        System.out.println(String.format("Valor final: %d", MiThreadSynchronizedBlock.x));
    }
}
