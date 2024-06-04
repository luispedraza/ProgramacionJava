package Temas.Tema07Concurrencia;

public class UserThread extends Thread {

    public UserThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("MyThread - START " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            //Get database connection, delete unused data from DB
            doDBProcessing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread - END " + Thread.currentThread().getName());
    }

    private void doDBProcessing() throws InterruptedException {
        Thread.sleep(5000);
    }

    public static void main(String[] args) {
        (new UserThread("hilo 1")).start();
        (new UserThread("hilo 2")).start();
        (new UserThread("hilo 3")).start();
    }

}
