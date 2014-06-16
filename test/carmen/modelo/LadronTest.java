package carmen.modelo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LadronTest {
	private Ladron ladron;
	
	@Before
	public void setUp() throws Exception {
		ladron = new Ladron("Bernard Madoff", "Masculino", "Negro", "Cicatriz", "Alpinismo", "Limusina");
	}

	@Test
	public void testLadronSeCreaOK() throws Exception {
		this.setUp();
		assertNotNull(this.ladron);
	}

	@Test
	public void testLadronSeCreaSinItinerario() throws Exception {
		this.setUp();
		assertNull(this.ladron.ciudadActual());
	}
	

}
