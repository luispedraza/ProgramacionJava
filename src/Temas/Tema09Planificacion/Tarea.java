package Temas.Tema09Planificacion;

class Tarea implements Runnable {

    private final int id;
    public Tarea(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(String.format("Ejecutando tarea: %d (%d)", id, i));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}