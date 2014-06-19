package carmen.modelo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

public class LectorXMLTest {

	private Mapa mapa;
	private ArrayList<Ladron> ladrones;
	
	@Before
	public void setUp() throws ParserConfigurationException, SAXException, IOException {
		this.mapa = LectorXML.cargarMapa();
		this.ladrones = LectorXML.cargarLadrones();
	}

	@Test
	public void testMapaSeCargaOK() throws Exception {
		this.setUp();		
		assertNotNull(this.mapa);
	}
	
	@Test
	public void testMapaCantidadCiudades() throws Exception {
		this.setUp();
		assertEquals(this.mapa.cantidadCiudades(), 29);
	}
	
	@Test
	public void testLadronesSeCarganOK() throws Exception {
		this.setUp();
		assertNotNull(this.ladrones);
	}
	
	@Test
	public void testLadronesCantidad() throws Exception {
		this.setUp();
		assertEquals(this.ladrones.size(), 11);
	}
}
