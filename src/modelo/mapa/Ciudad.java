package modelo.mapa;

import java.util.List;
import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Ciudad {

	private List<Local> locales;
	private Coordenada ubicacion;
	private String nombre;
	
	public Ciudad() {
		this.locales = new ArrayList<Local>();
	}
	
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public static Ciudad deserializar(Node elementoCiudad) {
		Ciudad nuevaCiudad = new Ciudad();
		nuevaCiudad.nombre = ((Element)elementoCiudad).getAttribute("nombre");
		nuevaCiudad.ubicacion = Coordenada.deserializar(elementoCiudad.getChildNodes().item(0));
		
		// Recorre los locales
		for (int i = 1; i < elementoCiudad.getChildNodes().getLength(); i++) {
			Local unLocal = Local.deserializar(elementoCiudad.getChildNodes().item(i));
			nuevaCiudad.agregarLocal(unLocal);
		}

		return nuevaCiudad;
	}
}