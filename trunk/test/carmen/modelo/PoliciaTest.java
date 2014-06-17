package carmen.modelo;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import junit.framework.TestCase;

public class PoliciaTest {

	private Policia policia;

	@Test
	public void setUp() {
		this.policia = new Policia();
	}

	@Test
	public void policiaDeberiaIniciarComoNovato() {
		Assert.assertEquals(0, policia.getCantidadArrestos());
		Assert.assertEquals("Novato", policia.getRango().getNombre());
	}

	@Test
	public void policiaDeberiaAscenderDeRango() {
		for (int i = 0; i < 5; i++) {
			policia.realizarArresto();
		}
		Assert.assertEquals("Detective", policia.getRango().getNombre());

		for (int i = 0; i < 5; i++) {
			policia.realizarArresto();
		}
		Assert.assertEquals("Investigador", policia.getRango().getNombre());

		for (int i = 0; i < 5; i++) {
			policia.realizarArresto();
		}
		Assert.assertEquals("Sargento", policia.getRango().getNombre());
	}

	@Test
	public void policiaDeberiaTenerDeterminadaVelocidadAlAscenderDeRango() {
		Assert.assertEquals(900, policia.getRango().getVelocidad().getKmPorHora());

		for (int i = 0; i < 5; i++) {
			policia.realizarArresto();
		}
		Assert.assertEquals(1100, policia.getRango().getVelocidad().getKmPorHora());

		for (int i = 0; i < 5; i++) {
			policia.realizarArresto();
		}
		Assert.assertEquals(1300, policia.getRango().getVelocidad().getKmPorHora());

		for (int i = 0; i < 5; i++) {
			policia.realizarArresto();
		}
		Assert.assertEquals(1500, policia.getRango().getVelocidad().getKmPorHora());
	}

	@Test
	public void policiaDeberiaCambiarDeLugarAlViajar() {
		ArrayList<Ciudad> listaDestinos = policia.verDestinos();
		Ciudad ciudadObjetivo = listaDestinos.get(0);

		policia.viajar(ciudadObjetivo);
		Ciudad ciudadActual = policia.ciudadActual();

		Assert.assertEquals(ciudadObjetivo, ciudadActual);
	}

	@Test
	public void interrogarDeberiaDevolverLaRespuestaCorrecta() {
		Turno turno = policia.getTurno();
		Locacion locacion = turno.getLocacion();
		Ciudad ciudadActual = locacion.ciudadActual();
		Local local = ciudadActual.getLocalFinanzas(); // ?

		local.setearPista("Se fue a Kamchatka");

		Assert.assertEquals(local.responder(), policia.interrogar(local));
		Assert.assertEquals("Se fue a Kamchatka", local.responder());
	}
}
