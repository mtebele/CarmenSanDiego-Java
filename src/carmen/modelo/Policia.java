package carmen.modelo;

import java.util.ArrayList;
import java.util.List;

public class Policia {

	private Rango rango;
	private Turno turno;
	private int cantDeArrestos;

	// TODO: definir constructor
	public Policia() {
		this.rango = new Rango();
		this.turno = new Turno(new Locacion(new Mapa(), new Ciudad(new Coordenada(0, 0))));
		this.cantDeArrestos = 0;
	}

	public void realizarArresto() {
		this.cantDeArrestos++;
	}

	public int getCantidadArrestos() {
		return this.cantDeArrestos;
	}

	public void ascender() {
		// No se bien como es eso al final del enum.
		// TODO
		// rango.ascender(); // ??? estoy tirandole la bocha a otro jajaja.
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

	public ArrayList verDestinos() { // TODO: parametrizar el ArrayList
		// return this.turno.getDestinos(); // getDestinos() pertenece a Turno?
		return null;
	}

	public void setearTurno(Turno turno) {
		this.turno = turno;
	}

	public void setearRango(Rango rango) {
		this.rango = rango;
	}

	public Rango getRango() {
		return this.rango;
	}

	public Turno getTurno() {
		return this.turno;
	}
}