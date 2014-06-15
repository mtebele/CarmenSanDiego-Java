package carmen.modelo;

import java.lang.Math;
import java.util.List;
import java.util.ArrayList;

public class Mapa {

	private List<Ciudad> ciudades;

	public Mapa() {
		this.ciudades = new ArrayList<Ciudad>();
	}

	public Ciudad elegirCiudadAlAzar() {
		int numeroAleatorio = (int)( Math.random() * (this.cantidadCiudades()) );
		return this.ciudades.get(numeroAleatorio);
	}

	public void agregarCiudad(Ciudad ciudad) {
		this.ciudades.add(ciudad);
	}
	
	public int cantidadCiudades(){
		return this.ciudades.size();
	}
}