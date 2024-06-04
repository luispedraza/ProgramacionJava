package Temas.Tema06InterfacesII.MVC;

import javax.swing.*;
import java.awt.event.*;


public class Vista extends JFrame implements ObservadorContador, ActionListener {
	
	private Controlador control;
	private JTextField textField;
	private JLabel label;
	private JButton botonIncrementar, botonDecrementar, botonResetear;

	public Vista(Controlador c) {
		super("Counter");
		initGUI();
		this.control = c;
		this.control.registrarObservador(this);
}

	private void initGUI() {
		this.setLayout(null);
		
		label = new JLabel("Counter");
		label.setBounds(80,10,60,30);
		
		textField = new JTextField();
		textField.setBounds(160, 10, 100, 30);
		
		botonIncrementar = new JButton("INCREASE");
		botonIncrementar.setBounds(50, 50, 100, 30);
		botonIncrementar.addActionListener(this);
		
		botonDecrementar = new JButton("DECREASE");
		botonDecrementar.setBounds(160, 50, 100, 30);
		botonDecrementar.addActionListener(this);
		
		botonResetear = new JButton("RESET");
		botonResetear.setBounds(270, 50, 100, 30);
		botonResetear.addActionListener(this);
				
		this.add(label);
		this.add(textField);
		this.add(botonIncrementar);
		this.add(botonDecrementar);
		this.add(botonResetear);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(420, 150);
		this.setVisible(true);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("INCREASE"))
			this.control.incrementar();
		else if (e.getActionCommand().equalsIgnoreCase("DECREASE"))
			this.control.decrementar();
		else
			this.control.resetear();
}
	
	@Override
	// M�todo de la interface ObservadorContador
	 public void actualiza(int contador) {
		String str = Integer.toString(contador);
		this.textField.setText(str);
	 }
}


