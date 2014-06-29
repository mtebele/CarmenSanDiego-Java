package test.modelo;

import modelo.Cuchillazo;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CuchillazoTest {

	Cuchillazo cuchillazo;

	@Before
	public void setUp() {
		this.cuchillazo = new Cuchillazo();
	}

	@Test
	public void testCuchillazoSeCreaOK() {

		Assert.assertNotNull(cuchillazo);
	}

	@Test
	public void testCuchillazoDescuentaUnaHora() {

		int horasPerdidas = cuchillazo.ejecutarAtaque();
		Assert.assertEquals(horasPerdidas, 1);
	}

	@Test
	public void testCuchillazoDescuentaDosHoras() {

		cuchillazo.ejecutarAtaque();
		int horasPerdidas = cuchillazo.ejecutarAtaque();
		Assert.assertEquals(horasPerdidas, 2);
	}
}