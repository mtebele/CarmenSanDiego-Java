package carmen.modelo;

import java.util.Random;
import java.util.List;

import carmen.modelo.excepciones.LadronNoPlaneoEscapeException;
import carmen.modelo.interfaces.IAtaque;

public class Turno {

	private Tiempo tiempo;
	private Locacion locacion;
	private IAtaque disparo;
	private IAtaque cuchillazo;

	public Turno(Locacion locacionInicial) {
		this.locacion = locacionInicial;
		this.tiempo = new Tiempo();
		this.cuchillazo = new Cuchillazo();
		this.disparo = new Disparo();
	}

	public void actualizar(int horas) {
		this.tiempo.transcurrirHoras(horas);
	}

	public void viajar(Ciudad destino, Velocidad velocidad) throws LadronNoPlaneoEscapeException {
		int distancia = this.ciudadActual().distanciaAOtraCiudad(destino);
		int horasDeViaje = velocidad.calcularTiempo(distancia);

		try {
			this.locacion.viajar(destino);
		} catch (LadronNoPlaneoEscapeException e) {
			throw new LadronNoPlaneoEscapeException(e.getMessage());
		}

		this.actualizar(horasDeViaje);
	}

	public String interrogar(Local local) {
		int horasInterrogatorio = local.getHorasProximoInterrogatorio();

		int horasPerdidasPorCuchillazo = this.horasPerdidasPorAtaque(cuchillazo);
		int horasPerdidasPorDisparo = 0;
		if (horasPerdidasPorCuchillazo == 0) {
			horasPerdidasPorDisparo = this.horasPerdidasPorAtaque(disparo);
		}

		this.actualizar(horasInterrogatorio + horasPerdidasPorCuchillazo + horasPerdidasPorDisparo);

		return this.locacion.interrogar(local);
	}

	public boolean quedaTiempo() {
		return this.tiempo.quedaTiempo();
	}

	private int horasPerdidasPorAtaque(IAtaque ataque) {
		Random random = new Random();
		int horasPerdidas = 0;
		if (random.nextInt(100) < ataque.getProbabilidadDeAtaque()) {
			horasPerdidas = ataque.ejecutarAtaque();
		}
		return horasPerdidas;
	}

	public Ciudad ciudadActual() {
		return this.locacion.ciudadActual();
	}

	public int getHorasRestantes() {
		return this.tiempo.horasRestantes();
	}

	public List<Ciudad> getDestinos() {
		return this.locacion.getDestinos();
	}

	public List<Local> getLocales() {
		return this.locacion.getLocales();
	}

	public Locacion getLocacion() {
		return this.locacion;
	}

	public IAtaque getDisparo() {
		return this.disparo;
	}

	public IAtaque getCuchillazo() {
		return this.cuchillazo;
	}

	public void setProbabilidadCuchillazo(int porcentaje) {
		cuchillazo.setProbabilidadDeAtaque(porcentaje);
	}

	public void setProbabilidadDisparo(int porcentaje) {
		disparo.setProbabilidadDeAtaque(porcentaje);
	}
}