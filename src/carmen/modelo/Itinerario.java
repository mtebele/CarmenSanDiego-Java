package carmen.modelo;

import java.util.ArrayList;
import java.util.List;

public class Itinerario {

	private List<Ciudad> ciudades;

	public Itinerario() {
		this.ciudades = new ArrayList<Ciudad>();
	}

	public void agregarAlRecorrido(Ciudad ciudad) {
		this.ciudades.add(ciudad);
	}

	public List<Ciudad> ciudades() {
		return this.ciudades;
	}

	public Ciudad ciudadNro(int nro) {
		return this.ciudades.get(nro - 1);
	}
}