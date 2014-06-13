package carmen.modelo;

import junit.framework.Assert;

import org.junit.Test;

import junit.framework.TestCase;

public class PoliciaTest {

	@Test
	public void setUp() {
		
		Policia policia = new Policia();
		
	}
	
	@Test
	public void policiaDeberiaIniciarComoNovato() {
	
		Assert.assertEquals(0, policia.getCantArrestos);
		
		Assert.assertEquals("Novato", policia.verRango.getRando);
	}
	
	@Test
	public void policiaDeberiaAscenderDeRango() {
				
		for(int i=0; i<5; i++) {
			policia.realizarArresto();
		}
		Assert.assertEquals("Detective", policia.verRango.getRango);

		for(i=0; i<5; i++) {
			policia.realizarArresto();
		}
		Assert.assertEquals("Investigador", policia.verRango.getRango);

		for(i=0; i<5; i++) {
			policia.realizarArresto();
		}
		Assert.assertEquals("Sargento", policia.verRango.getRango);
	}
	
	@Test
	public void policiaDeberiaTenerDeterminadaVelocidadAlAscenderDeRango() {
		
		Assert.assertEquals(900, policia.verRango.getVelocidad.getKmPorHora);
		
		for(int i=0; i<5; i++) {
			policia.realizarArresto();
		}
		Assert.assertEquals(1100, policia.verRango.getVelocidad.getKmPorHora);

		for(i=0; i<5; i++) {
			policia.realizarArresto();
		}
		Assert.assertEquals(1300, policia.verRango.getVelocidad.getKmPorHora);

		for(i=0; i<5; i++) {
			policia.realizarArresto();
		}
		Assert.assertEquals(1500, policia.verRango.getVelocidad.getKmPorHora);
	}
		
	@Test
	public void policiaDeberiaCambiarDeLugarAlViajar() {
		
		ArrayList listaDestinos = policia.verDestinos();
		Ciudad ciudadObjetivo = listaDestinos[0];
		
		policia.viajar(ciudadObjetivo);
		Ciudad ciudadActual = policia.ciudadActual();
		
		Assert.assertEquals(ciudadObjetivo, ciudadActual);
	}

	@Test
	public void interrogarDeberiaDevolverLaRespuestaCorrecta() {
	
		Turno turno = policia.getTurno();
		Locacion locacion = turno.getLocacion();
		Ciudad ciudadActual = locacion.ciudadActual();
		Local local = ciudadActual.getLocalFinanzas();
	
		local.setearPista("Se fue a Kamchatka");
	
		Assert.assertEquals(local.responder(), policia.interrogar(local));
		Assert.assertEquals("Se fue a Kamchatka", local.responder());
	}	
}
		