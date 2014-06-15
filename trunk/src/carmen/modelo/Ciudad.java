package carmen.modelo;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {

	private ArrayList<Local> locales;
	private Coordenada ubicacion;

	public Ciudad(Coordenada coordenadas) {
		this.locales = new ArrayList<Local>();
		this.ubicacion = coordenadas;
	}

	public String ingresar(Local local) {
		return local.responder();
	}

	public void agregarLocal(Local local) {
		this.locales.add(local);
	}
	
	public List<Local> getLocales() {
		return this.locales;
	}

	public int cantidadLocales() {
		/*
		 * no se me ocurrio como validar que meti locales sin usar mocks, si es muy cabeza me avisan y lo cambio
		 */
		// Para mi esta bien hacerlo todo manual sin hacer mocks, se nos
		// facilita la tarea
		// y de paso usamos ejemplos.
		return this.locales.size();
	}

}