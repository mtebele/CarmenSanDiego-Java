package carmen.modelo;

import java.util.ArrayList;

public class Mapa {

	private ArrayList<Ciudad> ciudades;

	public Mapa() {
		this.ciudades = new ArrayList<Ciudad>();
	}

	public void elegirCiudadAlAzar() {

	}

	public void agregarCiudad(Ciudad ciudad) {
		this.ciudades.add(ciudad);
	}

}