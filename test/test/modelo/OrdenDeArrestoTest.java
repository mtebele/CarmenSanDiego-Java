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
	private Perfil perfil1;

	@Before
	public void setUp() throws NullPointerException {
		this.orden = new OrdenDeArresto();
		this.perfil1 = new Perfil("Jesse James", Sexo.MASCULINO, Cabello.RUBIO, Senia.TATUAJE, Vehiculo.LIMUSINA,
				Hobby.MUSICA);
		this.ladron1 = new Ladron(perfil1);
	}

	@Test
	public void testOrdenDeArrestoSeCreaOK() throws Exception {
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
		this.orden.emitirOrden(this.ladron1);
		assertNotNull(this.orden.verLadron());
		assertEquals(this.orden.verLadron().verNombre(), "Jesse James");
	}

	@Test
	public void testOrdenDeArrestoEsValida() {

		assertEquals(this.orden.arrestoEsValido(this.ladron1), false);
		this.orden.agregarLadronABaseDeDatos(this.ladron1);
		assertEquals(this.orden.arrestoEsValido(this.ladron1), true);
	}

}
