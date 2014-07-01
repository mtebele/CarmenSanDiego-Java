package modelo;

import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import modelo.excepciones.LadronNoPlaneoEscapeException;
import modelo.ladron.*;
import modelo.mapa.*;
import modelo.policia.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Partida {

	private Policia policia;
	private Ladron ladron;
	private Turno turno;
	private OrdenDeArresto orden;
	private boolean partidaGanada;
	private boolean partidaTerminada;

	public Partida(Policia policia, Ladron ladron, Turno turno, OrdenDeArresto orden) {
		this.policia = policia;
		this.ladron = ladron;
		this.turno = turno;
		this.orden = orden;
		this.policia.setTurno(turno);
		this.partidaGanada = false;
		this.partidaTerminada = false;
	}

	public void emitirOrden(Ladron ladron) {
		this.orden.emitirOrden(ladron);
		this.turno.actualizar(3);
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
		this.partidaGanada = true;
		this.terminarPartida();
	}

	private void terminarPartida() {
		this.partidaTerminada = true;
	}
	
	public boolean partidaGanada() {
		return ( this.partidaGanada );
	}
	
	public boolean partidaTerminada() {
		return ( this.partidaTerminada );
	}

	public List<Ciudad> verDestinos() {
		return this.policia.verDestinos();
	}
	
	public Ciudad verDestinoNro(int nro) {
		return this.policia.verDestinoNro(nro);
	}

	public boolean quedaTiempo() {
		return turno.quedaTiempo();
	}
	
	public int verCantDeArrestos() {
		return this.policia.getCantidadArrestos();
	}
	
	public Rango verRangoPolicia() {
		return this.policia.getRango();
	}
	
	public int getHorasRestantes() {
		return this.turno.getHorasRestantes();
	}
	
	public int getHoraActual() {
		return this.turno.getHoraActual();
	}

	public Ciudad ciudadActual() {
		return this.policia.ciudadActual();
	}
	
	public Local verLocalNro(int nro) {
		return this.ciudadActual().verLocalNro(nro);
	}
	
	public Ladron getLadron() {
		return this.ladron;
	}
	
	public void guardarPartida() throws ParserConfigurationException, TransformerException {
		Juego juego = new Juego();
		juego.guardarPartida(this.policia);
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