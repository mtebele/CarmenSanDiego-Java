package carmen.modelo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LadronTest {
	private Ladron ladron;
	private Perfil perfil1;
	
	@Before
	public void setUp() throws Exception {
		perfil1 = new Perfil("Pepe", Sexo.MASCULINO, Cabello.CASTANIO, Senia.JOYAS, Vehiculo.MOTO, Hobby.MUSICA);
		ladron = new Ladron(perfil1);
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
	
	@Test
	public void testLadronNoPuedeEscaparSinRobar() throws Exception {
		this.setUp();
		boolean pudoEscapar = false;
		try{
			pudoEscapar = this.ladron.escapar();
		} catch (LadronNoHaRobadoException exc){
			pudoEscapar = false;
		}
		assertFalse(pudoEscapar);
	}

}
