package carmen.modelo;

import java.util.ArrayList;

public class ItinerarioDeLadron {

	private Ciudad[] ciudades;
	
	public ItinerarioDeLadron(int cantDeEscapes) {
		this.ciudades = new Ciudad[cantDeEscapes];
	}
	
	public void agregarAlRecorrido(Ciudad ciudad) {
		this.ciudades.add(ciudad);
	}
	
	public Ciudad[] ciudades() {
		return this.ciudades;
	}
	
	public Ciudad ciudadNro(int nro) {
		this.ciudades[nro+1];
	}
}