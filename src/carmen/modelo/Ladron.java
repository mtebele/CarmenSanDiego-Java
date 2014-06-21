package carmen.modelo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
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

	public boolean escapar() throws LadronNoPlaneoEscapeException {
		if (!this.itinerario.tieneDestinos())
			throw new LadronNoPlaneoEscapeException("El ladron no planeo su escape.");
		if (this.hizoUltimoEscape())
			return false;
		this.ciudadAnterior = this.ciudadActual;
		this.ciudadActual = this.itinerario.ciudadSiguiente(ciudadActual);
		return true;
	}

	public void robarObjeto(ObjetoRobado objeto) {
		this.objeto = objeto;
		Ciudad ciudadActual = objeto.ciudadOrigen();
		planearNuevoDestino(ciudadActual);
		this.ciudadActual = ciudadActual;
	}

	public boolean hizoUltimoEscape() {
		int cantDeEscapes = this.objeto.getValor().getCantidadDeEscapes();
		return this.itinerario.esCiudadFinal(cantDeEscapes, ciudadActual);
	}

	public String verNombre() {
		return this.perfil.verNombre();
	}

	public static Ladron deserializar(Node elementoLadron) {
		Perfil unPerfil = Perfil.deserializar(elementoLadron.getChildNodes().item(0));
		return new Ladron(unPerfil);
	}
}