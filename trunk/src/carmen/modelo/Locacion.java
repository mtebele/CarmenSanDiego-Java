package carmen.modelo;

import java.util.ArrayList;
import java.util.List;

public class Locacion {

	private Mapa mapa;
	private Ladron ladron;
	private Ciudad ciudadActual;
	private ArrayList<Ciudad> ciudadesDestino;

	public Locacion(Mapa mapa, Ciudad ciudadActual, Ladron ladron) {
		this.mapa = mapa;
		this.ladron = ladron;
		//this.ladron = null; // arranca en null, si el ladron viene aca se lo
							// setea. 
							// OJO. ladron no esta para eso. esta para tener referencia al pais
							// actual de ladron y su proximo.
							// Ladron deberia ser pasado por parametro. Sino Locacion no tiene sentido.
							
		this.ciudadActual = ciudadActual;
		this.ciudadesDestino = new ArrayList<Ciudad>();
	}


	public void generarNuevosDestinos() {

	}

	public void interrogar(Local local) {
		this.ciudadActual.ingresar(local);
	}

	public void agregarDestino(Ciudad destino) {
		this.ciudadesDestino.add(destino);
	}

	public Ciudad ciudadActual() {
		return this.ciudadActual;
	}

	public boolean estaLadron() {

	}
	
	public List<Local> getLocales() {
		return this.ciudadActual.getLocales();
	}
	
	public List<Ciudad> getDestinos() {
		return this.ciudadesDestino;
	}
	
}

}