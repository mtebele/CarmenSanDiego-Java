package carmen.modelo.policia;

import java.util.List;

import carmen.modelo.Turno;
import carmen.modelo.excepciones.LadronNoPlaneoEscapeException;
import carmen.modelo.mapa.Ciudad;
import carmen.modelo.mapa.Local;

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
		// TODO: ver excepcion.
		
		Velocidad velocidad = this.rango.getVelocidad();
		//try {
			this.turno.viajar(destino, velocidad);
		//} catch (LadronNoPlaneoEscapeException e) {
		//	throw new LadronNoPlaneoEscapeException(e.getMessage());
		//}
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