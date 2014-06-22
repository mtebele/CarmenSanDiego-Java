package carmen.modelo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import carmen.modelo.perfil.Cabello;
import carmen.modelo.perfil.Hobby;
import carmen.modelo.perfil.Perfil;
import carmen.modelo.perfil.Senia;
import carmen.modelo.perfil.Sexo;
import carmen.modelo.perfil.Vehiculo;

public class OrdenDeArrestoTest {
	private OrdenDeArresto orden;
	private Ladron ladron1;
	private Ladron ladron2;
	private Perfil perfil1;
	private Perfil perfil2;

	@Before
	public void setUp() throws NullPointerException{
		this.orden = new OrdenDeArresto();
		this.perfil1 = new Perfil("Jesse James",Sexo.MASCULINO,Cabello.RUBIO,Senia.TATUAJE,Vehiculo.LIMUSINA,Hobby.MUSICA);
		this.perfil2 = new Perfil("Grondona",Sexo.MASCULINO,Cabello.NEGRO,Senia.JOYAS,Vehiculo.DEPORTIVO,Hobby.PARACAIDISMO);
		this.ladron1 = new Ladron(perfil1);
		this.ladron2 = new Ladron(perfil2);
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
		assertNull(this.orden.verLadron());
		this.orden.agregarLadronABaseDeDatos(this.ladron1);
		this.orden.emitirOrden(this.ladron1);
		assertNotNull(this.orden.verLadron());
		assertEquals(this.orden.verLadron().verNombre(),"Jesse James");
	}
	
	
	@Test
	public void testOrdenDeArrestoCambiaLadronOK(){
		this.setUp();
		this.orden.agregarLadronABaseDeDatos(this.ladron1);
		this.orden.agregarLadronABaseDeDatos(this.ladron2);
		this.orden.emitirOrden(this.ladron1);
		assertNotNull(this.orden.verLadron());
		assertEquals(this.orden.verLadron().verNombre(),"Jesse James");
		this.orden.emitirOrden(this.ladron2);
		assertEquals(this.orden.verLadron().verNombre(),"Grondona");
	}
	
	@Test
	
	public void testOrdenDeArrestoEsValida(){
		this.setUp();
		assertEquals(this.orden.arrestoEsValido(this.ladron1),false);
	    this.orden.agregarLadronABaseDeDatos(this.ladron1);
	    assertEquals(this.orden.arrestoEsValido(this.ladron1),true);
	}
	
}
