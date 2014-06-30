package test.modelo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import modelo.LectorXML;
import modelo.Partida;
import modelo.ladron.Ladron;
import modelo.mapa.Mapa;
import modelo.policia.OrdenDeArresto;
import modelo.policia.Policia;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

public class LectorXMLTest {

	private Mapa mapa;
	private ArrayList<Ladron> ladrones;
	private Partida partida;
	private Policia policia;

	@Before
	public void setUp() throws ParserConfigurationException, SAXException, IOException {
		this.mapa = LectorXML.cargarMapa();
		this.ladrones = LectorXML.cargarLadrones();
		this.partida = LectorXML.cargarPartida(new Policia("Phil"));
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

	@Test
	public void testPoliciaSeCargaOK() throws Exception {
		this.policia = LectorXML.cargarPolicia();
		assertNotNull(this.policia);
	}
}