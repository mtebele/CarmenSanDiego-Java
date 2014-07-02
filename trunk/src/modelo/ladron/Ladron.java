package modelo.ladron;

import modelo.excepciones.LadronNoPlaneoEscapeException;
import modelo.ladron.perfil.Perfil;
import modelo.mapa.Ciudad;

import org.w3c.dom.Node;

public class Ladron {

	private Perfil perfil;
	private Ciudad ciudadActual;
	private Ciudad ciudadAnterior;
	private ObjetoRobado objeto;
	private Itinerario itinerario;

	public Ladron(Perfil perfil) {
		this.perfil = perfil;
		this.ciudadActual = null;
		this.ciudadAnterior = null;
		this.objeto = null;
		this.itinerario = new Itinerario();
	}

	public void planearNuevoDestino(Ciudad ciudad) {
		this.itinerario.agregarAlRecorrido(ciudad);
	}

	public Ciudad ciudadActual() {
		return this.ciudadActual;
	}

	public Ciudad ciudadAnterior() {
		return this.ciudadAnterior;
	}
	
	public ObjetoRobado getObjeto() {
		return this.objeto;
	}

	public boolean escapar() throws LadronNoPlaneoEscapeException {
		if (!this.itinerario.tieneDestinos())
			throw new LadronNoPlaneoEscapeException("El ladron no planeo su escape.");
		if (hizoUltimoEscape())
			return false;
		this.ciudadAnterior = this.ciudadActual;
		this.ciudadActual = this.itinerario.ciudadSiguiente(ciudadActual);
		return true;
	}

	public void robarObjeto(ObjetoRobado objeto) {
		this.objeto = objeto;
		Ciudad ciudadActual = this.itinerario.ciudadNro(0);
		this.ciudadActual = ciudadActual;
	}

	public boolean hizoUltimoEscape() {
		int cantDeEscapes = this.objeto.getValor().getCantidadDeEscapes();
		return this.itinerario.esCiudadFinal(cantDeEscapes, ciudadActual);
	}

	public String verNombre() {
		return this.perfil.getNombre();
	}

	public static Ladron deserializar(Node elementoLadron) {
		Perfil unPerfil = Perfil.deserializar(elementoLadron.getChildNodes().item(0));
		return new Ladron(unPerfil);
	}
	
	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}
	
	public Itinerario getItinerario() {
		return this.itinerario;
	}
	
	public String verDatos() {
		StringBuilder datos = new StringBuilder();
		datos.append("Nombre: " +  this.perfil.getNombre());
		datos.append(System.lineSeparator());
		datos.append("Sexo: " +  this.perfil.getSexo().toString());
		datos.append(System.lineSeparator());
		datos.append("Cabello: " +  this.perfil.getCabello().toString());
		datos.append(System.lineSeparator());
		datos.append("Seña: " +  this.perfil.getSenia().toString());
		datos.append(System.lineSeparator());
		datos.append("Hobby: " +  this.perfil.getHobby().toString());
		datos.append(System.lineSeparator());
		datos.append("Vehículo: " +  this.perfil.getVehiculo().toString());
		datos.append(System.lineSeparator());
		return datos.toString();
	}
}