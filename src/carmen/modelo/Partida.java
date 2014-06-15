package carmen.modelo;

import java.util.ArrayList;

public class Partida {

	private Policia policia;
	private Ladron ladron;
	private Turno turno;
	private Mapa mapa;
	private OrdenDeArresto orden;

	public Partida(Policia policia) {
		this.policia = policia;
		this.orden = new OrdenDeArresto();
		// Todas las demas cosas como las recibe? por parametro el constructor o como?
	}

	public void emitirOrden(Ladron ladron) {
		// setea al ladron en la orden de arresto de la partida.
		this.orden.emitirOrden(ladron);
	}

	public boolean atraparLadron(Ladron ladron) {
		// deberia chequear algo mas el if?
		if (this.orden.verLadron().equals(ladron)) {
			return true;
		}
		return false;
	}

	public void viajar(Ciudad destino) {

	}

	public void interrogar(Local local) {

	}

	public void perder() {

	}

	public void ganar() {

	}

	public ArrayList verDestinos() {
		// Ver bien el tipo que devuelve
		return null;
	}

	public int verTiempoRestante() {
		return turno.getHorasRestantes();
	}

	public void setearMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	public void setearLadron(Ladron ladron) {
		this.ladron = ladron;
	}

	public void setearTurno(Turno turno) {
		this.turno = turno;
	}

	public Turno getTurno() {
		return this.turno;
	}
}