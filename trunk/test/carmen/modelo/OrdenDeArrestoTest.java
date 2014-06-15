package carmen.modelo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrdenDeArrestoTest {
	private OrdenDeArresto orden;
	
	@Before
	public void setUp() throws Exception{
		this.orden = new OrdenDeArresto();
	}
	
	@Test
	public void testOrdenDeArrestoSeCreaOK() throws Exception {
		try{
			this.setUp();
		}
		catch (NullPointerException e){
			fail("La orden no fue creada");
		}
		assertNotNull(this.orden);
		assertNull(this.orden.verLadron());
	}

}
