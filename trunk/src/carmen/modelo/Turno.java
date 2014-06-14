package carmen.modelo;

import java.util.ArrayList;

public class Turno {

	private Tiempo tiempo;
	private Locacion locacion;
	private ArrayList<Atacable> listaAtacables;

	public Turno(Locacion locacionInicial) {
		this.locacion = locacionInicial;
	}

	public void actualizar(int horas) {
		this.tiempo.transcurrir(horas);
	}

	public void viajar(Ciudad destino, Velocidad velocidad) {

	}

	public void interrogar(Local local) {

	}

	public boolean quedaTiempo() {
		// le cambio el nombre al metodo porque quedaba confuso. Devuelve true
		// si queda tiempo.
		return this.tiempo.quedaTiempo();
	}

	public Ciudad ciudadActual() {
		return null;
	}

	public void setearLocacion(Locacion locacion) {
		this.locacion = locacion;
	}

	public int getHorasRestantes() {
		return 0;
	}
}