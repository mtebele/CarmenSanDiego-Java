package carmen.modelo;

import java.lang.Math;
import java.util.List;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

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
	
	public static Mapa establecerFronteras(Document doc) {
		Mapa nuevoMapa = new Mapa();
		Element unMapa = (Element)doc.getElementsByTagName("mapa").item(0);
		
		// Recorro las ciudades
		for (int i = 0; i < unMapa.getChildNodes().getLength(); i++) {
			Ciudad unaCiudad = Ciudad.fundar(unMapa.getChildNodes().item(i));
			nuevoMapa.ciudades.add(unaCiudad);			
		}

		return nuevoMapa;
	}
}