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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ubicacion == null) ? 0 : ubicacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciudad other = (Ciudad) obj;
		
		if (ubicacion == null) {
			if (other.ubicacion != null)
				return false;
		} else if (!ubicacion.equals(other.ubicacion))
			return false;
		return true;
	}
	
	
	
}