package carmen.modelo;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import carmen.modelo.excepciones.LadronNoPlaneoEscapeException;

public class Partida {

	private Policia policia;
	private Ladron ladron;
	private Turno turno;
	private OrdenDeArresto orden;
	private Juego juego;

	public Partida(Policia policia, Ladron ladron, Turno turno, OrdenDeArresto orden) {
		this.policia = policia;
		this.ladron = ladron;
		this.turno = turno;
		this.orden = orden;
	}

	public void emitirOrden(Ladron ladron) {
		this.orden.emitirOrden(ladron);
	}

	public void atraparLadron() {
		if ((this.orden.verLadron() != null) && (this.orden.verLadron().equals(this.ladron))) {
			this.ganar();
		} else {
			this.perder();
		}
	}

	public void viajar(Ciudad destino) {
		// TODO: ver lo de la excepcion.
		try {
			this.policia.viajar(destino);
		} catch (LadronNoPlaneoEscapeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (!this.quedaTiempo()) {
			this.perder();
		}
	}

	public String interrogar(Local local) {

		String pista = this.policia.interrogar(local);

		if (!this.quedaTiempo()) {
			this.perder();
		} else if (this.policia.ciudadActual().equals(this.ladron.ciudadActual()) && this.ladron.hizoUltimoEscape()) {
			this.atraparLadron();
		}

		return pista;
	}

	private void perder() {
		this.terminarPartida();
	}

	private void ganar() {
		this.policia.realizarArresto();
		this.terminarPartida();
	}

	private void terminarPartida() {
		// this.juego.terminarPartida();
		// Esto pondria en null la referencia a Partida de Juego.

		// Mas adelante este metodo deberia actualizar las vistas o algo asi para que
		// el usuario sepa que termino la partida.
	}

	public List<Ciudad> verDestinos() {
		return this.policia.verDestinos();
	}

	public boolean quedaTiempo() {
		return turno.quedaTiempo();
	}

	public Ciudad ciudadActual() {
		return this.policia.ciudadActual();
	}

	public static Partida deserializar(Document doc, Policia policia, Mapa mapa, OrdenDeArresto orden) {
		Element unaPartida = (Element) doc.getElementsByTagName("partida").item(0);

		Node nodeLadron = unaPartida.getChildNodes().item(0);
		Ladron ladron = Ladron.deserializar(nodeLadron);

		Node nodeItinerario = nodeLadron.getChildNodes().item(1);
		ladron.setItinerario(Itinerario.deserializar(nodeItinerario));

		Ciudad ciudadActual = Ciudad.deserializar(nodeItinerario.getFirstChild());
		Locacion locacionInicial = new Locacion(mapa, ciudadActual, ladron);
		Turno turno = new Turno(locacionInicial);

		return new Partida(policia, ladron, turno, orden);
	}
}