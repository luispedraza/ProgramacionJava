package Temas.Tema06InterfacesII.MVC;

public class Controlador {
	
	 private Modelo model;
	 
	 public Controlador(Modelo m) { this.model = m; }
	 
	 public void incrementar() { this.model.incrementarContador();}
	 public void iniciar() {this.model.resetearContador(); }
	 public void decrementar() { this.model.decrementarContador(); }
	 public void resetear() { this.model.resetearContador(); }
	 
	 public void registrarObservador(ObservadorContador ob) {
		 this.model.registrarObservador(ob);
	 }
	 
	 public void borrarObservador(ObservadorContador ob) {
		 this.model.borrarObservador(ob);
	 }
	}
