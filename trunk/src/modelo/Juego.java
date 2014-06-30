package modelo;

import java.io.IOException;
import java.util.Observable;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import modelo.policia.Policia;

import org.xml.sax.SAXException;

public class Juego {

	private Policia policia;

	public Partida nuevaPartida() throws ParserConfigurationException, SAXException, IOException {
		this.policia = new Policia("Jack Bauer");
		return LectorXML.cargarPartida(this.policia);
	}

	public Partida cargarPartida() throws ParserConfigurationException, SAXException, IOException {
		this.policia = LectorXML.cargarPolicia();
		return LectorXML.cargarPartida(this.policia);
	}

	public void guardarPartida(Policia policia) throws ParserConfigurationException, TransformerException {
		LectorXML.guardarPartida(policia);
	}
}