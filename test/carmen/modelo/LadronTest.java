package carmen.modelo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import carmen.modelo.excepciones.LadronNoPlaneoEscapeException;
import carmen.modelo.perfil.Cabello;
import carmen.modelo.perfil.Hobby;
import carmen.modelo.perfil.Perfil;
import carmen.modelo.perfil.Senia;
import carmen.modelo.perfil.Sexo;
import carmen.modelo.perfil.Vehiculo;

public class LadronTest {
	private Ladron ladron;
	private Perfil perfil1;
	private Ciudad ciudad0, ciudad1, ciudad2, ciudad3, ciudad4, ciudad5, ciudad6;
	private ObjetoRobado unObjetoComun;
	private ObjetoRobado unObjetoValioso;
	private ObjetoRobado unObjetoMuyValioso;

	@Before
	public void setUp() throws Exception {
		perfil1 = new Perfil("Pepe", Sexo.MASCULINO, Cabello.CASTANIO, Senia.JOYAS, Vehiculo.MOTO, Hobby.MUSICA);
		ladron = new Ladron(perfil1);
		ciudad0 = new Ciudad(new Coordenada(23, -212));
		ciudad1 = new Ciudad(new Coordenada(5323, 2334));
		ciudad2 = new Ciudad(new Coordenada(3213, 2134));
		ciudad3 = new Ciudad(new Coordenada(34, 5346));
		ciudad4 = new Ciudad(new Coordenada(-43, 3432));
		ciudad5 = new Ciudad(new Coordenada(9, 3432));
		ciudad6 = new Ciudad(new Coordenada(21, -234));
		unObjetoComun = new ObjetoRobado(Valor.COMUN, ciudad0);
		unObjetoValioso = new ObjetoRobado(Valor.VALIOSO, ciudad0);
		unObjetoMuyValioso = new ObjetoRobado(Valor.MUY_VALIOSO, ciudad0);
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
		try {
			pudoEscapar = this.ladron.escapar();
		} catch (LadronNoPlaneoEscapeException exc) {
			pudoEscapar = false;
		}
		assertFalse(pudoEscapar);
	}

	@Test
	public void testLadronPuedeEscapar3VecesAlRobarComun() throws Exception {
		this.setUp();
		ladron.robarObjeto(unObjetoComun);
		ladron.planearNuevoDestino(ciudad1);
		ladron.planearNuevoDestino(ciudad2);
		ladron.planearNuevoDestino(ciudad3);
		assertEquals(ladron.ciudadActual(), ciudad0);
		assertTrue(ladron.escapar());
		assertEquals(ladron.ciudadActual(), ciudad1);
		assertTrue(ladron.escapar());
		assertEquals(ladron.ciudadActual(), ciudad2);
		assertTrue(ladron.escapar());
		assertEquals(ladron.ciudadActual(), ciudad3);
		assertFalse(ladron.escapar());
		assertEquals(ladron.ciudadActual(), ciudad3);
		assertTrue(ladron.hizoUltimoEscape());
	}

	@Test
	public void testLadronPuedeEscapar4VecesAlRobarValioso() throws Exception {
		this.setUp();
		ladron.robarObjeto(unObjetoValioso);
		ladron.planearNuevoDestino(ciudad1);
		ladron.planearNuevoDestino(ciudad2);
		ladron.planearNuevoDestino(ciudad3);
		ladron.planearNuevoDestino(ciudad4);
		assertEquals(ladron.ciudadActual(), ciudad0);
		assertTrue(ladron.escapar());
		assertEquals(ladron.ciudadActual(), ciudad1);
		assertTrue(ladron.escapar());
		assertEquals(ladron.ciudadActual(), ciudad2);
		assertTrue(ladron.escapar());
		assertEquals(ladron.ciudadActual(), ciudad3);
		assertTrue(ladron.escapar());
		assertEquals(ladron.ciudadActual(), ciudad4);
		assertFalse(ladron.escapar());
		assertEquals(ladron.ciudadActual(), ciudad4);
		assertTrue(ladron.hizoUltimoEscape());
	}

	@Test
	public void testLadronPuedeEscapar6VecesAlRobarMuyValioso() throws Exception {
		this.setUp();
		ladron.robarObjeto(unObjetoMuyValioso);
		ladron.planearNuevoDestino(ciudad1);
		ladron.planearNuevoDestino(ciudad2);
		ladron.planearNuevoDestino(ciudad3);
		ladron.planearNuevoDestino(ciudad4);
		ladron.planearNuevoDestino(ciudad5);
		ladron.planearNuevoDestino(ciudad6);
		assertEquals(ladron.ciudadActual(), ciudad0);
		assertTrue(ladron.escapar());
		assertEquals(ladron.ciudadActual(), ciudad1);
		assertTrue(ladron.escapar());
		assertEquals(ladron.ciudadActual(), ciudad2);
		assertTrue(ladron.escapar());
		assertEquals(ladron.ciudadActual(), ciudad3);
		assertTrue(ladron.escapar());
		assertEquals(ladron.ciudadActual(), ciudad4);
		assertTrue(ladron.escapar());
		assertEquals(ladron.ciudadActual(), ciudad5);
		assertTrue(ladron.escapar());
		assertEquals(ladron.ciudadActual(), ciudad6);
		assertFalse(ladron.escapar());
		assertEquals(ladron.ciudadActual(), ciudad6);
		assertTrue(ladron.hizoUltimoEscape());
	}
}