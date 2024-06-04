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
    private int incremento;

    public MiThread (int incremento) {
        this.incremento = incremento;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            this.x += incremento;
            System.out.println(this.x);
        }
    }
}


public class CarreraDosHilos {

    public static void main(String[] args) {
        MiThread thread1 = new MiThread(1);
        thread1.start();
        MiThread thread2 = new MiThread(-1);
        thread2.start();
    }
}
