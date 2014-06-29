package modelo.policia;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import modelo.Turno;
import modelo.excepciones.LadronNoPlaneoEscapeException;
import modelo.mapa.Ciudad;
import modelo.mapa.Local;

public class Policia {

	private Rango rango;
	private Turno turno;
	private int cantidadArrestos;
	private String nombre;

	public Policia(String nombre) {
		this.cantidadArrestos = 0;
		this.rango = DefinicionRangoPolicia.getObjetoRango(this.cantidadArrestos);
		this.nombre = nombre;
	}
	
	public Policia(String nombre, Rango rango, int cantArrestos) {
		this.cantidadArrestos = cantArrestos;
		this.rango = rango;
		this.nombre = nombre;
	}

	public void realizarArresto() {
		this.cantidadArrestos++;
		this.rango = DefinicionRangoPolicia.getObjetoRango(this.cantidadArrestos);
	}

	public int getCantidadArrestos() {
		return this.cantidadArrestos;
	}

	public void viajar(Ciudad destino) throws LadronNoPlaneoEscapeException {
		Velocidad velocidad = this.rango.getVelocidad();
		this.turno.viajar(destino, velocidad);
	}

	public String interrogar(Local local) {
		return this.turno.interrogar(local);
	}

	public Ciudad ciudadActual() {
		return this.turno.ciudadActual();
	}

	public List<Ciudad> verDestinos() {
		return this.turno.getDestinos();
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public void setRango(Rango rango) {
		this.rango = rango;
	}

	public Rango getRango() {
		return this.rango;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public String getNombre() {
		return this.nombre;
	}

	public static Policia deserializar(Document doc) {
		Element elePolicia = (Element) doc.getElementsByTagName("policia").item(0);
		String nombre = elePolicia.getAttribute("nombre");
		int cantArrestos = Integer.parseInt(elePolicia.getAttribute("arrestos"));
		Rango rango = DefinicionRangoPolicia.getObjetoRango(cantArrestos);
		
		return new Policia(nombre, rango, cantArrestos);
	}

	public Element serializar(Document doc) {
		Element elementoPolicia = doc.createElement("policia");
		elementoPolicia.setAttribute("nombre", this.nombre);
		elementoPolicia.setAttribute("rango", this.rango.getNombre());
		elementoPolicia.setAttribute("arrestos", Integer.toString(this.cantidadArrestos));
		return elementoPolicia;
	}
}