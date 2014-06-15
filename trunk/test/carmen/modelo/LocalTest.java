package carmen.modelo;

import junit.framework.Assert;
import org.junit.Test;


public class LocalTest {

	@Test
	public void responderDeberiaDevolverRespuestaCorrecta() {
		Local local = new Local();
		local.setearPista("Soy una pista");

		Assert.assertEquals("Soy una pista", local.responder());
	}

}