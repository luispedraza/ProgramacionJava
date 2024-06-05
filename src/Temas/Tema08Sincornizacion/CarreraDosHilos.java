/**
 * Este ejemplo motiva la necesidad de sincronización entre hilos
 * Creamos dos hilos:
 * - Uno de ellos incrementa un número de veces una variable estática una cierta cantidad
 * - Otro de ellos decrementa el mismo número de veces la misma variable la misma cierta cantidad
 * Si la variable inicialmente vale cero, el resoltado final debería ser cero, pero...
 */

package Temas.Tema08Sincornizacion;

class MiThread extends  Thread {

    public static int x = 0;
    private int incremento = 0;

    public MiThread (int incremento) {
        this.incremento = incremento;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            MiThread.x += incremento;
            // System.out.println(MiThread.x);
        }
    }
}


public class CarreraDosHilos {

    public static void main(String[] args) throws InterruptedException {
        MiThread thread1 = new MiThread(1);
        MiThread thread2 = new MiThread(-1);
        thread1.start();
        thread2.start();
        // Esperamos a que los dos hilos finalicen
        thread1.join();
        thread2.join();
        // Valor final del contador:
        System.out.println(String.format("Valor final: %d", MiThread.x));

    }
}
