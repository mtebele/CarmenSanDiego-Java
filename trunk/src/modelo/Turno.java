package modelo;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

import modelo.excepciones.LadronNoPlaneoEscapeException;
import modelo.interfaces.IAtaque;
import modelo.mapa.Ciudad;
import modelo.mapa.Locacion;
import modelo.mapa.Local;
import modelo.policia.Velocidad;

public class Turno {

	private Tiempo tiempo;
	private Locacion locacion;
	private List<IAtaque> ataques;
	private boolean fueAtacado;

	public Turno(Locacion locacionInicial) {
		this.locacion = locacionInicial;
		this.tiempo = new Tiempo();
		ataques = new ArrayList<IAtaque>();
		cargarAtaques();
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
		int horasPerdidasPorAtaque = 0;

		for (IAtaque unAtaque : ataques) {
			horasPerdidasPorAtaque = this.horasPerdidasPorAtaque(unAtaque);
			// Permito solo un ataque
			if (horasPerdidasPorAtaque > 0) {
				this.fueAtacado = true;
				break;
			}
		}

		this.actualizar(horasInterrogatorio + horasPerdidasPorAtaque);

		return this.locacion.interrogar(local);
	}

	public boolean fueAtacado() {
		boolean atacado = this.fueAtacado;
		if (atacado)
			this.fueAtacado = false;
		return atacado;
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

	public int getHoraActual() {
		return this.tiempo.horaActual();
	}

	public List<Ciudad> getDestinos() {
		return this.locacion.getDestinos();
	}

	public List<Local> getLocales() {
		return this.locacion.getLocales();
	}

	public Ciudad verDestinoNro(int nro) {
		return this.locacion.verDestinoNro(nro);
	}

	public Locacion getLocacion() {
		return this.locacion;
	}

	public void setProbabilidadCuchillazo(int porcentaje) {
		for (IAtaque unAtaque : ataques) {
			if (unAtaque.getClass() == Cuchillazo.class) {
				unAtaque.setProbabilidadDeAtaque(porcentaje);				
			}
		}
	}

	public void setProbabilidadDisparo(int porcentaje) {
		for (IAtaque unAtaque : ataques) {
			if (unAtaque.getClass() == Disparo.class) {
				unAtaque.setProbabilidadDeAtaque(porcentaje);				
			}
		}
	}

	private void cargarAtaques() {
		ataques.add(new Cuchillazo());
		ataques.add(new Disparo());
	}
}