package modelo;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import modelo.policia.Policia;
import org.xml.sax.SAXException;

public class Juego {

	private Policia policia;

	public Partida nuevaPartida() throws ParserConfigurationException, SAXException, IOException {
		this.policia = new Policia();
		return LectorXML.cargarPartida(this.policia);
	}
}