package carmen.modelo;

import java.util.List;
import java.util.ArrayList;

public class Ciudad {

	private List<Local> locales;
	private Coordenada ubicacion; // VER: No se esta usando, se deberia mandar por parametro en algun metodo que no esta creo.

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
		return this.locales.size();
	}
	
	public Coordenada getUbicacion() {
		return this.ubicacion;
	}
	
	public int distanciaAOtraCiudad(Ciudad otraCiudad) {
		return ( this.getUbicacion().distanciaAOtraCoordenada(otraCiudad.getUbicacion()) );
	}
	
}