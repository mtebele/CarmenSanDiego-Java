package carmen.modelo;

import java.util.ArrayList;

public class ItinerarioDeLadron {

	private Mapa mapa;
	private ArrayList<Ciudad> ciudades;
	
	public void agregarAlRecorrido(Ciudad ciudad) {
		this.ciudades.add(ciudad);
	}
}