package carmen.modelo;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class DisparoTest {
	
	
	   @Test
	   public void testDisparoSeCreaOK() {
		   Disparo disparo= new Disparo ();
		   Assert.assertNotNull(disparo);
	   }
	   
	   
	   @Test
	   public void testDisparoDescuentaCuatroHoras() {
		   Disparo disparo= new Disparo ();
		   int horasPerdidas=disparo.ejecutarAtaque();
		   Assert.assertEquals(horasPerdidas, 4);
		   
		   
	   }
	   
	   
	   
}	   