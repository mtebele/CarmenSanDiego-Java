package carmen.modelo;

import java.util.List;

public class Policia {

	private Rango rango;
	private Turno turno;
	private int cantidadArrestos;

	public Policia() {
		this.cantidadArrestos = 0;
		this.rango = DefinicionRangoPolicia.getObjetoRango(this.cantidadArrestos);
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
		try {
			this.turno.viajar(destino, velocidad);
		} catch (LadronNoPlaneoEscapeException e) {
			throw new LadronNoPlaneoEscapeException(e.getMessage());
		}
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
}