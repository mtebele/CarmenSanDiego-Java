package carmen.modelo;

import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;

public class TiempoTest {
	
	private Tiempo tiempo;
	
	@Before
	public void setUp() {
		this.tiempo = new Tiempo();
	}
	
	@Test
	public void deberiaCrearseOK() {
		this.setUp();
		
		Assert.assertEquals(10, this.tiempo.horaActual());
		Assert.assertEquals(154, this.tiempo.horasRestantes());
	} 
	
	@Test
	public void deberiaTranscurrirUnaHora() {
		this.setUp();
		
		this.tiempo.transcurrirHora();
		Assert.assertEquals(11, this.tiempo.horaActual());
		Assert.assertEquals(153, this.tiempo.horasRestantes());
	}
	
	public void deberiaPasarLaNocheSiendoTarde() {
		this.setUp();
		
		for (int i=0; i<13; i++) {
			this.tiempo.transcurrirHora();
		}
		
		Assert.assertEquals(7, this.tiempo.horaActual());
		Assert.assertEquals(133, this.tiempo.horasRestantes());
	}
	
}