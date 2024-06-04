package Temas.Tema06InterfacesII.MVC;

import java.awt.event.*;


public class VistaConsola implements ObservadorContador {
	
	private Controlador control;


	public VistaConsola(Controlador c) {

		this.control = c;
		this.control.registrarObservador(this);
}


	@Override
	// M�todo de la interface ObservadorContador
	 public void actualiza(int contador) {

		System.out.println("Contador = " + contador);
	 }
}


