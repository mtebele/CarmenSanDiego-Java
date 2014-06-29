package test.modelo;

import junit.framework.Assert;
import modelo.mapa.Local;
import modelo.mapa.TipoLocal;

import org.junit.Before;
import org.junit.Test;

public class LocalTest {

	private Local local;

	@Before
	public void setUp() {
		this.local = new Local(TipoLocal.AEROPUERTO);
		this.local.setearPista("Soy una pista");
	}

	@Test
	public void deberiaCrearseOK() {

		Assert.assertNotNull(this.local);
		Assert.assertEquals(0, this.local.vecesVisitado());
	}

	@Test
	public void responderDeberiaDevolverRespuestaCorrecta() {

		Assert.assertEquals("Soy una pista", local.responder());
	}

	@Test
	public void responderDeberiaAumentarLaCantidadDeVecesVisitado() {

		local.responder();
		Assert.assertEquals(1, local.vecesVisitado());
		local.responder();
		Assert.assertEquals(2, local.vecesVisitado());
	}

	@Test
	public void responderDeberiaAumentarLasHorasDeInterrogatorio() {

		Assert.assertEquals(1, local.getHorasProximoInterrogatorio());
		local.responder();
		Assert.assertEquals(2, local.getHorasProximoInterrogatorio());
		local.responder();
		Assert.assertEquals(3, local.getHorasProximoInterrogatorio());
		local.responder();
		Assert.assertEquals(3, local.getHorasProximoInterrogatorio());
	}
}