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

class MiThreadSynchronizedMethod extends  Thread {

    public static int x = 0;
    private static Object obj = new Object();
    private int incremento;

    private static synchronized void operation(int incremento) {
        x += incremento;
        System.out.println(x);
    }
    public MiThreadSynchronizedMethod (int incremento) {
        this.incremento = incremento;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            // Llamamos al métodos sincronizado
            operation(incremento);
        }
    }
}

public class CarreraDosHilosSynchronizedMethod {
    public static void main(String[] args) {
        MiThreadSynchronizedMethod thread1 = new MiThreadSynchronizedMethod(1);
        thread1.start();
        MiThreadSynchronizedMethod thread2 = new MiThreadSynchronizedMethod(-1);
        thread2.start();
    }
}
