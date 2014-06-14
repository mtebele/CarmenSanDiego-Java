package carmen.modelo;

import java.util.ArrayList;

public class Locacion {

	private Mapa mapa;
	private Ladron ladron;
	private Ciudad ciudadActual;
	private ArrayList<Ciudad> ciudadesDestino;

	public Locacion(Mapa mapa, Ciudad ciudadActual) {
		this.mapa = mapa;
		this.ladron = null; // arranca en null, si el ladron viene aca se lo
							// setea.
		this.ciudadActual = ciudadActual;
		this.ciudadesDestino = new ArrayList<Ciudad>();
	}

	public int dormir(Ciudad ciudad) {
		// no seria responsabilidad de otro objeto?
		return 0;
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
		return (this.ladron != null);
	}

	public void setearLadron(Ladron ladron) {
		this.ladron = ladron;
	}
}