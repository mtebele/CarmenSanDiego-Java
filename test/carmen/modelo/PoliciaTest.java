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
		Policia policia = new Policia();
		Assert.assertEquals(0, policia.getCantArrestos);
		
		Assert.assertEquals("Novato", policia.verRango.getRando);
	}
	
	@Test
	public void policiaDeberiaAscenderDeRango() {
		
		Policia policia = new Policia();
		
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
	
	public void policiaDeberiaTenerDeterminadaVelocidadAlAscenderDeRango() {
		Policia policia = new Policia();
		
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
	
	public void poilciaDeberiaCambiarDeLugarAlViajar() {
		
		ArrayList listaDestinos = policia.verDestinos();
		Pais paisObjetivo = listaDestinos[0];
		
		policia.viajar(paisObjetivo);
		Pais paisActual = policia.paisActual();
		
		Assert.assertEquals(paisObjetivo, paisActual);
	}
}

	@Test
	public void interrogarDeberiaDevolverLaRespuestaCorrecta() {
	
		Turno turno = policia.getTurno();
		Locacion locacion = turno.getLocacion();
		Pais paisActual = locacion.paisActual();
		Local local = paisActual.getLocalFinanzas();
	
		local.setearPista("Se fue a Kamchatka");
	
		Assert.assertEquals(local.responder(), policia.interrogar(local));
		Assert.assertEquals("Se fue a Kamchatka", local.responder());
		
	}	
}
		