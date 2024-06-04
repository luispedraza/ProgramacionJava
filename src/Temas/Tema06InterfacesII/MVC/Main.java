package Temas.Tema06InterfacesII.MVC;

public class Main {

	 public static void main(String[] args) {

		 Modelo modelo = new Modelo(); // se crea el modelo
		 Controlador controlador = new Controlador(modelo); // se crea Controlador

		 new Vista(controlador);
		 new VistaConsola(controlador);
		 }

}
