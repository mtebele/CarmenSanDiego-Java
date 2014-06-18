package carmen.modelo;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class LocalTest {

	private Local local;
	
	@Before
	public void setUp() {
		this.local = new Local();
		this.local.setearPista("Soy una pista");
	}
	
	@Test
	public void deberiaCrearseOK() {
		this.setUp();
		
		Assert.assertNotNull(this.local);
		Assert.assertEquals(0, this.local.vecesVisitado());
	} 
	
	@Test
	public void responderDeberiaDevolverRespuestaCorrecta() {
		this.setUp();
		
		Assert.assertEquals("Soy una pista", local.responder());
	}
	
	@Test
	public void responderDeberiaAumentarLaCantidadDeVecesVisitado() {
		this.setUp();
		
		local.responder();
		Assert.assertEquals(1, local.vecesVisitado());
		local.responder();
		Assert.assertEquals(2, local.vecesVisitado());
	}
	
	@Test
	public void responderDeberiaAumentarLasHorasDeInterrogatorio() {
		this.setUp();
		
		local.responder();
		Assert.assertEquals(2, local.getHorasProximoInterrogatorio());
		local.responder();
		Assert.assertEquals(3,local.getHorasProximoInterrogatorio());
		local.responder();
		Assert.assertEquals(3, local.getHorasProximoInterrogatorio());
		
		
	}
}