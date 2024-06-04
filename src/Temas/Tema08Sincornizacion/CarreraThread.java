package Temas.Tema08Sincornizacion;

/**
 * Ejemplo de una condición de carrera en el uso de múltiples threads
 * Todos ellos modifican el valor de una misma variable
 */
public class CarreraThread extends Thread {
    static int count = 0;   // variable contador.
    final int N = 10000;       // cantidad de veces que cada proceso va a incrementar/decrementar
    final static int M = 200; // cantidad de hilos incrementador/decrementador respectivamente
    int inc;                // cantidad de incremento/decremento

    public void run() {
        this.incrementar(inc);
    }

    public CarreraThread(int v) {
        this.inc = v;
    }

    /**
     * Increment la variable estática count N veces
     */
    public void incrementar(int v) {
        for (int i = 0; i < N; i++) {
            count = count + v;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread incre[] = new Thread[M]; // Array de hilos incrementadores
        Thread decre[] = new Thread[M]; // Array de hilos decrementadores
        for (int i = 0; i < M; i++) {
            incre[i] = new CarreraThread(1);     //se llena el array de los incrementadores
            decre[i] = new CarreraThread(-1);    //se llena el array de los decrementadores
            // ahora lanzamos ambos hilos
            incre[i].start();
            decre[i].start();
        }
        for (int i = 0; i < M; i++) {
            // Esperamos a que terminen todos los hilos
            incre[i].join();
            decre[i].join();
        }
        System.out.println("El valor final de la variable n es " + count);

    }
}