package carmen.modelo;


	import org.junit.Before;
	import org.junit.Test;

	import junit.framework.Assert;


	public class CuchillazoTest {
		
		
   @Test
   public void testCuchillazoSeCreaOK() {
	   Cuchillazo cuchillazo= new Cuchillazo ();
	   Assert.assertNotNull(cuchillazo);
   }
   
   
   @Test
   public void testCuchillazoDescuentaUnaHora() {
	   Cuchillazo cuchillazo= new Cuchillazo ();
	   int horasPerdidas=cuchillazo.ejecutarAtaque();
	   Assert.assertEquals(horasPerdidas, 1);
	   
	   
   }
   
   @Test
   public void testCuchillazoDescuentaDosHoras() {
	   Cuchillazo cuchillazo= new Cuchillazo ();
	   cuchillazo.ejecutarAtaque();
	   int horasPerdidas=cuchillazo.ejecutarAtaque();
	   
	   Assert.assertEquals(horasPerdidas, 2);
	   
	   
   }
   
   
 }
   
   