package test.modelo;

import modelo.Disparo;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class DisparoTest {

	Disparo disparo;

	@Before
	public void setUp() {
		this.disparo = new Disparo();
	}

	@Test
	public void testDisparoSeCreaOK() {

		Assert.assertNotNull(disparo);
	}

	@Test
	public void testDisparoDescuentaCuatroHoras() {

		int horasPerdidas = disparo.ejecutarAtaque();
		Assert.assertEquals(horasPerdidas, 4);
	}
}