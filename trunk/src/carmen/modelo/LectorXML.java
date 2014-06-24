package carmen.modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class LectorXML {

	static final String PATH = "xml/";

	public static Mapa cargarMapa() throws ParserConfigurationException, SAXException, IOException {

		File archivo = new File(PATH + "mapa.xml");

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();

		Mapa mapaCargado = Mapa.deserializar(doc);
		return mapaCargado;
	}

	public static ArrayList<Ladron> cargarLadrones() throws ParserConfigurationException, SAXException, IOException {

		File archivo = new File(PATH + "ladrones.xml");

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();

		ArrayList<Ladron> listaLadrones = new ArrayList<Ladron>();
		Element ladrones = (Element) doc.getElementsByTagName("ladrones").item(0);

		// Recorre los ladrones
		for (int i = 0; i < ladrones.getChildNodes().getLength(); i++) {
			Ladron unLadron = Ladron.deserializar(ladrones.getChildNodes().item(i));
			listaLadrones.add(unLadron);
		}

		return listaLadrones;
	}

	public static Partida cargarPartida(Policia policia, Mapa mapa, OrdenDeArresto orden)
			throws ParserConfigurationException, SAXException, IOException {

		// TODO: cargar file segun rango de policia
		File archivo = new File(PATH + "partidaNovato.xml");

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();

		Partida unaPartida = Partida.deserializar(doc, policia, mapa, orden);
		return unaPartida;
	}

}
