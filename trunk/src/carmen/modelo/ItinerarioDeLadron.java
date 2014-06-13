package carmen.modelo;

import java.util.ArrayList;

public class ItinerarioDeLadron {

	private ArrayList<Ciudad> ciudades;
	
	public ItinerarioDeLadron() {
		this.ciudades = new ArrayList<Ciudad>();
	}
	
	public void agregarAlRecorrido(Ciudad ciudad) {
		this.ciudades.add(ciudad);
	}
	
	public ArrayList<Ciudad> ciudades() {
		return this.ciudades;
	}
	
	public Ciudad ciudadNro(int nro) {
		return this.ciudades.get(nro+1);
	}
}