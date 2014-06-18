package carmen.modelo;

import java.util.List;

public class Partida {

	private Policia policia;
	private Ladron ladron;
	private Turno turno;
	private OrdenDeArresto orden;

	public Partida(Policia policia, Ladron ladron, Turno turno, OrdenDeArresto orden) {
		this.policia = policia;
		this.ladron = ladron;
		this.turno = turno;
		this.orden = orden;
	}

	public void emitirOrden(Ladron ladron) {
		this.orden.emitirOrden(ladron);
	}

	private void atraparLadron(Ladron ladron) {
		if (this.orden.verLadron().equals(this.ladron)) {
			this.ganar();
		}
		this.perder();
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
		
		String pista = this.turno.interrogar(local);
		if (! this.quedaTiempo()) {
			this.perder();
		}
		
		if (this.policia.ciudadActual().equals(this.ladron.ciudadActual()) && this.ladron.hizoUltimoEscape()) {
			this.atraparLadron(this.ladron);
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
		
	}

	public List<Ciudad> verDestinos() {
		return this.policia.verDestinos();
	}

	public boolean quedaTiempo() {
		return turno.quedaTiempo();
	}


}