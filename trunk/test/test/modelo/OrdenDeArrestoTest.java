package test.modelo;

import static org.junit.Assert.*;
import modelo.ladron.Ladron;
import modelo.ladron.perfil.Cabello;
import modelo.ladron.perfil.Hobby;
import modelo.ladron.perfil.Perfil;
import modelo.ladron.perfil.Senia;
import modelo.ladron.perfil.Sexo;
import modelo.ladron.perfil.Vehiculo;
import modelo.policia.OrdenDeArresto;

import org.junit.Before;
import org.junit.Test;

public class OrdenDeArrestoTest {
	private OrdenDeArresto orden;
	private Ladron ladron1;
	private Ladron ladron2;
	private Perfil perfil1;
	private Perfil perfil2;

	@Before
	public void setUp() throws NullPointerException {
		this.orden = new OrdenDeArresto();
		this.perfil1 = new Perfil("Jesse James", Sexo.MASCULINO, Cabello.RUBIO, Senia.TATUAJE, Vehiculo.LIMUSINA,
				Hobby.MUSICA);
		this.perfil2 = new Perfil("Grondona", Sexo.MASCULINO, Cabello.NEGRO, Senia.JOYAS, Vehiculo.DEPORTIVO,
				Hobby.PARACAIDISMO);
		this.ladron1 = new Ladron(perfil1);
		this.ladron2 = new Ladron(perfil2);
	}

	@Test
	public void testOrdenDeArrestoSeCreaOK() throws Exception {
		try {

		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("La orden no fue creada");
		}
		assertNotNull(this.orden);
		assertNull(this.orden.verLadron());
	}

	@Test
	public void testOrdenDeArrestoEmiteOrdenOK() {

		assertNull(this.orden.verLadron());
		this.orden.agregarLadronABaseDeDatos(this.ladron1);
		this.orden.emitirOrden(this.ladron1);
		assertNotNull(this.orden.verLadron());
		assertEquals(this.orden.verLadron().verNombre(), "Jesse James");
	}

	@Test
	public void testOrdenDeArrestoCambiaLadronOK() {

		this.orden.agregarLadronABaseDeDatos(this.ladron1);
		this.orden.agregarLadronABaseDeDatos(this.ladron2);
		this.orden.emitirOrden(this.ladron1);
		assertNotNull(this.orden.verLadron());
		assertEquals(this.orden.verLadron().verNombre(), "Jesse James");
		this.orden.emitirOrden(this.ladron2);
		assertEquals(this.orden.verLadron().verNombre(), "Grondona");
	}

	@Test
	public void testOrdenDeArrestoEsValida() {

		assertEquals(this.orden.arrestoEsValido(this.ladron1), false);
		this.orden.agregarLadronABaseDeDatos(this.ladron1);
		assertEquals(this.orden.arrestoEsValido(this.ladron1), true);
	}

}
