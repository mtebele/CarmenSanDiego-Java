package carmen.modelo;

import java.util.List;

public class Partida {

	private Policia policia;
	private Ladron ladron;
	private Turno turno;
	private Mapa mapa;
	private OrdenDeArresto orden;

	public Partida(Policia policia, Ladron ladron, Turno turno, Mapa mapa, OrdenDeArresto orden) {
		this.policia = policia;
		this.ladron = ladron;
		this.turno = turno;
		this.mapa = mapa;
		this.orden = orden;
	}

	public void emitirOrden(Ladron ladron) {
		this.orden.emitirOrden(ladron);
	}

	public void atraparLadron(Ladron ladron) {
		if (this.orden.verLadron().equals(this.ladron)) {
			this.ganar();
		}
		perder();
	}

	public void viajar(Ciudad destino) {
		try {
			this.policia.viajar(destino);
		} catch (LadronNoPlaneoEscapeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public String interrogar(Local local) {
		return null;
	}

	public void perder() {

	}

	public void ganar() {

	}

	public List<Ciudad> verDestinos() {
		return null;
	}

	public int verTiempoRestante() {
		return turno.getHorasRestantes();
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