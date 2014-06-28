package test.modelo;

import junit.framework.TestCase;
import modelo.mapa.Ciudad;
import modelo.mapa.Coordenada;
import modelo.mapa.Local;
import modelo.mapa.TipoLocal;

import org.junit.Before;
import org.junit.Test;

public class CiudadTest extends TestCase {
	private Ciudad ciudad;
	private Local local1;
	private Local local2;

	static final String PISTA_1 = "Estaba interesado en conseguir reales";
	static final String PISTA_2 = "Se fue en un auto con bandera verde, amarilla y azul";

	@Before
	public void setUp() throws Exception {
		Coordenada unaUbicacion = new Coordenada(-58, -34);
		this.ciudad = new Ciudad(unaUbicacion);
		this.local1 = new Local(TipoLocal.AEROPUERTO);
		this.local1.setearPista(PISTA_1);
		this.local2 = new Local(TipoLocal.BANCO);
		this.local2.setearPista(PISTA_2);
	}

	@Test
	public void testCiudadSeCreaOK() throws Exception {
		this.setUp();
		assertNotNull(this.ciudad);
	}

	@Test
	public void testCiudadAgregaUnLocal() throws Exception {
		this.setUp();
		this.ciudad.agregarLocal(this.local1);
		assertEquals(this.ciudad.cantidadLocales(), 1);
		this.ciudad.agregarLocal(this.local2);
		assertEquals(this.ciudad.cantidadLocales(), 2);
	}
	
	@Test
	public void testCiudadDistanciaAOtraCiudad() throws Exception {
		this.setUp();
		Coordenada coord= new Coordenada(139,35);
		Ciudad tokio= new Ciudad (coord);
		assertEquals((this.ciudad.distanciaAOtraCiudad(tokio)),18455);
	}
}
