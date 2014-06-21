package carmen.modelo;

import java.util.ArrayList;
import java.util.List;

public class Itinerario {

	private ArrayList<Ciudad> ciudades;

	public Itinerario() {
		this.ciudades = new ArrayList<Ciudad>();
	}

	public void agregarAlRecorrido(Ciudad ciudad) {
		this.ciudades.add(ciudad);
	}

	public List<Ciudad> ciudades() {
		return this.ciudades;
	}

	public Ciudad ciudadSiguiente(Ciudad ciudadActual) {
		int nroCiudadActual = this.ciudades.indexOf(ciudadActual);
		return this.ciudadNro(nroCiudadActual + 1);
	}
	
	public boolean esCiudadFinal(int cantDeEscapes, Ciudad ciudad) {
		return ciudad.equals(this.ciudadNro(cantDeEscapes - 1));
	}
	
	public Ciudad ciudadNro(int nro) {
		return this.ciudades.get(nro);
	}
	
	public boolean tieneDestinos() {
		return (! this.ciudades.isEmpty() );
	}
}