/**
 * Ejemplo de una interfaz que lanza procesos en hilos de ejecución separados
 * Permite ejecutar dos procesos que llevan un tiempo largo
 * Cuando lanzamos uno de ellos, la aplicación no queda "bloqueada"
 */
package Temas.Tema07Concurrencia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Proceso1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100000000; i++) {
            System.out.println("Ejecutando proceso 1, paso " + Integer.toString(i));
        }
    }
}

class Proceso2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100000000; i++) {
            System.out.println("Ejecutando proceso 2 " + Integer.toString(i));
        }
    }
}


public class UIConHilos {

    private static void proceso1 () {
        (new Proceso1()).start();
    }

    private static void proceso2 () {
        (new Proceso2()).start();
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ventaja que ejecuta un proceso largo");
        // Añadimos el botón que ejecuta el proceso 1
        JButton boton1 = new JButton("PROCESO 1");
        boton1.setBounds(100,100, 200, 30);
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIConHilos.proceso1();
            }
        });
        ventana.add(boton1);
        // Añadimos el botón que ejecuta el proceso 2
        JButton boton2 = new JButton("PROCESO 2");
        boton2.setBounds(100,200, 200, 30);
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIConHilos.proceso2();
            }
        });
        ventana.add(boton2);

        ventana.setSize(400, 400);
        ventana.setLayout(null);
        ventana.setVisible(true);
    }
}
