package carmen.modelo;

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
		this.setUp();
		Assert.assertNotNull(this.velocidad);
		Assert.assertEquals(this.velocidad.getKmPorHora(), 100);
	}
	
	@Test
	public void testDeberiaCalcularElTiempoEnRecorrerUnaDistancia() {
		this.setUp();
		
		int distancia = 100;
		// Distancia = 100 / Velocidad = 100 => Tiempo = 1
		Assert.assertEquals(this.velocidad.calcularTiempo(distancia), 1);
	}
}