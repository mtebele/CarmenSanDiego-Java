package carmen.modelo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrdenDeArrestoTest {
	private OrdenDeArresto orden;
	private Ladron ladron1;
	private Ladron ladron2;
	
	@Before
	public void setUp() throws NullPointerException{
		this.orden = new OrdenDeArresto();
		this.ladron1 = new Ladron("Jesse James", "Masculino", "Rubio", "Tatuaje", "Tenis", "Limusina");
		this.ladron2 = new Ladron("Grondona", "Masculino", "Negro", "Joyas", "Ciclismo","Descapotable");
	}
	
	@Test
	public void testOrdenDeArrestoSeCreaOK() throws Exception {
		try{
			this.setUp();
		}
		catch (NullPointerException e){
			e.printStackTrace();
			fail("La orden no fue creada");
		}
		assertNotNull(this.orden);
		assertNull(this.orden.verLadron());
	}

	@Test
	public void testOrdenDeArrestoEmiteOrdenOK(){
		this.setUp();
		this.orden.emitirOrden(this.ladron1);
		assertNotNull(this.orden.verLadron());
		assertEquals(this.orden.verLadron().verNombre(),"Jesse James");
	}
	
	@Test
	public void testOrdenDeArrestoCambiaLadronOK(){
		this.setUp();
		this.orden.emitirOrden(this.ladron1);
		assertNotNull(this.orden.verLadron());
		assertEquals(this.orden.verLadron().verNombre(),"Jesse James");
		this.orden.emitirOrden(this.ladron2);
		assertEquals(this.orden.verLadron().verNombre(),"Grondona");

	}
	
}
