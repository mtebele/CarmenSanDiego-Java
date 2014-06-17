package carmen.modelo;

import java.util.ArrayList;

public class Policia {

	private Rango rango;
	private Turno turno;
	private int cantidadArrestos;

	// TODO: definir constructor
	public Policia() {
		// this.turno = ?
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

	public void viajar(Ciudad destino) {
		Velocidad velocidad = this.rango.getVelocidad();
		this.turno.viajar(destino, velocidad);
	}

	public void interrogar(Local local) {
		this.turno.interrogar(local);
	}

	public Ciudad ciudadActual() {
		return this.turno.ciudadActual();
	}

	public ArrayList<Ciudad> verDestinos() {
		// return this.turno.getDestinos(); // getDestinos() pertenece a Turno?
		return null;
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