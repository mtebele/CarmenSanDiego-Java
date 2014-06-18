package carmen.modelo;


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
		this.setUp();
		
		Assert.assertNotNull(cuchillazo);
	}
   
	@Test
	public void testCuchillazoDescuentaUnaHora() {
		this.setUp();
		
		int horasPerdidas = cuchillazo.ejecutarAtaque();
		Assert.assertEquals(horasPerdidas, 1);
   }
	   
	@Test
	public void testCuchillazoDescuentaDosHoras() {
		this.setUp();
		
		cuchillazo.ejecutarAtaque();
		int horasPerdidas = cuchillazo.ejecutarAtaque();  
		Assert.assertEquals(horasPerdidas, 2);   
	}
}	   