package Temas.Tema06InterfacesII.MVC;
import java.util.*;

public class Modelo {
	
	 private List<ObservadorContador> observadores;		// lista de observadores
	 private int contador;     // datos del modelo
	 
	 public Modelo() {
		 this.observadores = new ArrayList<ObservadorContador>(); //crear lista vac�a de observadores
		 this.contador = 0;
	 }
	 
	 public void incrementarContador() {
		 this.contador++;
		 for (ObservadorContador ob : observadores) ob.actualiza(this.contador);
	 }
	 
	 public void decrementarContador() {
		 this.contador--;
		 for (ObservadorContador ob : observadores) ob.actualiza(this.contador);
	 }
	 
	 public void resetearContador() {
		 this.contador = 0;
		 for (ObservadorContador ob : observadores) ob.actualiza(0);
	 }
	 
	 public void registrarObservador(ObservadorContador ob) {
		 observadores.add(ob);
		 }

	 public void borrarObservador(ObservadorContador ob) {
		 observadores.remove(ob);
		 }
	 
}