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
	private Partida partida;
	
	@Before
	public void setUp() throws ParserConfigurationException, SAXException, IOException {
		this.mapa = LectorXML.cargarMapa();
		this.ladrones = LectorXML.cargarLadrones();
		OrdenDeArresto orden = new OrdenDeArresto();
		orden.CargarBaseDeDatos();
		this.partida = LectorXML.cargarPartida(new Policia(), this.mapa, orden);
	}

	@Test
	public void testMapaSeCargaOK() throws Exception {
		assertNotNull(this.mapa);
	}
	
	@Test
	public void testMapaCantidadCiudades() throws Exception {
		assertEquals(this.mapa.cantidadCiudades(), 29);
	}
	
	@Test
	public void testLadronesSeCarganOK() throws Exception {
		assertNotNull(this.ladrones);
	}
	
	@Test
	public void testLadronesCantidad() throws Exception {
		assertEquals(this.ladrones.size(), 10);
	}
	
	@Test
	public void testPartidaSeCargaOK() throws Exception {
		assertNotNull(this.partida);
	}
}
