/**
 * Ejemplo de una interfaz que lanza procesos largos en el hilo principal de ejecución
 * Permite ejecutar dos procesos que llevan un tiempo largo
 * Cuando lanzamos uno de ellos, la aplicación no responde a ningún otro evento: queda "bloqueada"
 */
package Temas.Tema07Concurrencia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UISinHilos {

    private static void proceso1 () {
        for (int i = 0; i < 100000000; i++) {
            System.out.println("Ejecutando proceso 1, paso " + Integer.toString(i));
        }
    }
    private static void proceso2 () {
        for (int i = 0; i < 100000000; i++) {
            System.out.println("Ejecutando proceso 2 " + Integer.toString(i));
        }
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ventaja que ejecuta un proceso largo");
        // Añadimos el botón que ejecuta el proceso 1
        JButton boton1 = new JButton("PROCESO 1");
        boton1.setBounds(100,100, 200, 30);
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UISinHilos.proceso1();
            }
        });
        ventana.add(boton1);
        // Añadimos el botón que ejecuta el proceso 2
        JButton boton2 = new JButton("PROCESO 2");
        boton2.setBounds(100,200, 200, 30);
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UISinHilos.proceso2();
            }
        });
        ventana.add(boton2);

        ventana.setSize(400, 400);
        ventana.setLayout(null);
        ventana.setVisible(true);
    }
}
