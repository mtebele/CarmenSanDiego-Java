package carmen.modelo;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MapaTest {
	private Mapa mapa;
	private Ciudad ciudad0;
	private Ciudad ciudad1;

	@Before
	public void setUp() {
		this.mapa = new Mapa();
		
		Coordenada ubicacion0 = new Coordenada(0,0);
		this.ciudad0 = new Ciudad(ubicacion0);
		Coordenada ubicacion1 = new Coordenada(10,10);
		this.ciudad1 = new Ciudad(ubicacion1);

	}

	@Test
	public void testMapaSeCreaOK() {
		this.setUp();
		Assert.assertNotNull(this.mapa);
		Assert.assertEquals(this.mapa.cantidadCiudades(), 0);
	}
	
	@Test
	public void testMapaAgregaUnaCiudad() {
		this.setUp();
		
		this.mapa.agregarCiudad(ciudad0);
		Assert.assertEquals(this.mapa.cantidadCiudades(), 1);
		this.mapa.agregarCiudad(ciudad1);
		Assert.assertEquals(this.mapa.cantidadCiudades(), 2);
	}
	
	@Test
	public void testMapaElegirCiudadAleatoriaTeniendoSoloUnaCiudadEnElMapa() {
		this.setUp();
		
		this.mapa.agregarCiudad(ciudad0);
		Assert.assertEquals(ciudad0, this.mapa.elegirCiudadAlAzar());
	}
}