package modelo.mapa;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import modelo.excepciones.LadronNoPlaneoEscapeException;
import modelo.ladron.Ladron;

public class Locacion {

	private Mapa mapa;
	private Ladron ladron;
	private Ciudad ciudadActual;
	private List<Ciudad> ciudadesDestino;
	private static int CANTIDAD_DESTINOS = 3;

	public Locacion(Mapa mapa, Ciudad ciudadActual, Ladron ladron) {
		this.mapa = mapa;
		this.ladron = ladron;
		this.ciudadActual = ciudadActual;
		this.ciudadesDestino = new ArrayList<Ciudad>();
	}

	private void generarNuevosDestinos() {
		ArrayList<Ciudad> destinos = new ArrayList<Ciudad>();
		
		this.ciudadesDestino.clear();
		destinos.add(this.ladron.ciudadActual());

		for (int i = 0; i < CANTIDAD_DESTINOS; i++) {
			Ciudad destino = this.mapa.elegirCiudadAlAzar();
			while (this.ciudadesDestino.contains(destino)) {
				destino = this.mapa.elegirCiudadAlAzar();
			}
			destinos.add(destino);
		}
		Collections.shuffle(destinos);
		
		for (Ciudad destinoAAgregar : destinos) {
			this.agregarDestino(destinoAAgregar);
		}
	}

	public void viajar(Ciudad destino) throws LadronNoPlaneoEscapeException {

		Ciudad ciudadAnterior = this.ciudadActual;
		this.ciudadActual = destino;

		// Hago escapar al ladron si el policia lo alcanza.
		if (estaLadron()) {
			try {
				this.ladron.escapar();
			} catch (LadronNoPlaneoEscapeException e) {
				throw new LadronNoPlaneoEscapeException(e.getMessage());
			}
			this.generarNuevosDestinos();
		} else {
			this.ciudadesDestino.remove(destino);
			this.agregarDestino(ciudadAnterior);
		}
	}

	public String interrogar(Local local) {
		if (pasoLadronRecientemente()) {
			return local.responder();
		}
		local.visitar();
		return "Lo siento, nunca he visto a esa persona.";
	}

	public void agregarDestino(Ciudad destino) {
		this.ciudadesDestino.add(destino);
	}

	public Ciudad ciudadActual() {
		return this.ciudadActual;
	}

	public boolean pasoLadronRecientemente() {
		if (this.ladron.ciudadAnterior() == null)
			return false;
		return (this.ladron.ciudadAnterior().equals(this.ciudadActual));
	}

	public boolean estaLadron() {
		return (this.ladron.ciudadActual().equals(this.ciudadActual));
	}

	public List<Local> getLocales() {
		return this.ciudadActual.getLocales();
	}

	public List<Ciudad> getDestinos() {
		return this.ciudadesDestino;
	}

	public Ciudad verDestinoNro(int nro) {
		return ciudadesDestino.get(nro - 1);
	}

	public Ladron getLadron() {
		return this.ladron;
	}

}