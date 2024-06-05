/**
 * Este ejemplo motiva la necesidad de sincronización entre hilos
 * Creamos dos hilos:
 * - Uno de ellos incrementa un número de veces una variable estática una cierta cantidad
 * - Otro de ellos decrementa el mismo número de veces la misma variable la misma cierta cantidad
 * Si la variable inicialmente vale cero, el resoltado final debería ser cero, pero...
 *
 * AQUÍ RESOLVEMOS LA CONDICION DE CARRERA EMPLEANDO ESPERA ACTIVA
 */

package Temas.Tema08Sincornizacion;

import java.util.concurrent.Semaphore;

class MiThreadEsperaActiva extends  Thread {
    public static int x = 0;
    private int incremento = 0;
    private static boolean flag;

    public MiThreadEsperaActiva (int incremento) {

        this.incremento = incremento;
        flag = false;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            while (flag) {
                // esperamos
            }
            // Activamos la bandera
            flag = true;
            x += incremento;
            System.out.println(x);
            // desactivamos la bandera
            flag = false;
        }
    }
}


public class CarreraDosHilosEsperaActiva {
    public static void main(String[] args) {
        MiThreadEsperaActiva thread1 = new MiThreadEsperaActiva(1);
        thread1.start();
        MiThreadEsperaActiva thread2 = new MiThreadEsperaActiva(-1);
        thread2.start();
    }
}
