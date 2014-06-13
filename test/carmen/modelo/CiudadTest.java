package carmen.modelo;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class CiudadTest extends TestCase{
	private Ciudad ciudad;
	private Local local1;
	private Local local2;

	static final String PISTA_1 = "Estaba interesado en conseguir reales";
	static final String PISTA_2 = "Se fue en un auto con bandera verde, amarilla y azul";

	@Before
	public void setUp() throws Exception {
		Coordenada unaUbicacion = new Coordenada(1,2); 
		this.ciudad = Ciudad.conUbicacion(unaUbicacion);
		this.local1 = new Local(PISTA_1);
		this.local2 = new Local(PISTA_2);
	}

	@Test
	public void testCiudadSeCreaOK() throws Exception{
		this.setUp();
		assertNotNull(this.ciudad);
	}
	
	@Test
	public void testCiudadAgregaUnLocal() throws Exception{
		this.setUp();
		this.ciudad.setearLocal(this.local1);
		assertEquals(this.ciudad.cantidadLocales(),1);
		this.ciudad.setearLocal(this.local2);
		assertEquals(this.ciudad.cantidadLocales(),2);
	}

}
