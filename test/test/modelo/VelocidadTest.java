package test.modelo;

import modelo.policia.Velocidad;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class VelocidadTest {
	private Velocidad velocidad;

	@Before
	public void setUp() {
		int kmPorHora = 100;
		this.velocidad = new Velocidad(kmPorHora);
	}

	@Test
	public void testVelocidadSeCreaOK() {
		Assert.assertNotNull(this.velocidad);
		Assert.assertEquals(this.velocidad.getKmPorHora(), 100);
	}

	@Test
	public void testDeberiaCalcularElTiempoEnRecorrerUnaDistancia() {
		int distancia = 100;
		// Distancia = 100 / Velocidad = 100 => Tiempo = 1
		Assert.assertEquals(this.velocidad.calcularTiempo(distancia), 1);
	}
}