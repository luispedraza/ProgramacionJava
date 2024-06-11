package Temas.Tema08Sincornizacion;


class TareaConNombre implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.print(Thread.currentThread().getName() + "-");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class EjemploJoin {
    public static void main(String[] args) throws InterruptedException{
        Thread tareaA = new Thread(new TareaConNombre(), "A"); // Hilo con nombre A
        Thread tareaB = new Thread(new TareaConNombre(), "B"); // Hilo con nombre B
        Thread tareaC = new Thread(new TareaConNombre(), "C"); // Hilo con nombre C
        Thread tareaD = new Thread(new TareaConNombre(), "D"); // Hilo con nombre D

        tareaA.start();
        tareaB.start();
        tareaA.join();
        tareaB.join();
        tareaC.start();
        tareaD.start();
        tareaC.join();
        tareaD.join();
        //tareaB.start();
        Thread tareaB2 = new Thread(new TareaConNombre(), "B"); // Hilo con nombre B
        tareaB2.start();
    }
}
