package modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import modelo.ladron.Ladron;
import modelo.mapa.Mapa;
import modelo.policia.OrdenDeArresto;
import modelo.policia.Policia;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class LectorXML {

	static final String PATH = "xml/";
	static final String SAVEDPATH = "xml/saved/";

	public static Mapa cargarMapa() throws ParserConfigurationException, SAXException, IOException {
		Document doc = inicializarDocumento(PATH + "mapa.xml");

		Mapa mapaCargado = Mapa.deserializar(doc);
		return mapaCargado;
	}

	public static ArrayList<Ladron> cargarLadrones() throws ParserConfigurationException, SAXException, IOException {
		Document doc = inicializarDocumento(PATH + "ladrones.xml");

		ArrayList<Ladron> listaLadrones = new ArrayList<Ladron>();
		Element ladrones = (Element) doc.getElementsByTagName("ladrones").item(0);

		// Recorre los ladrones
		for (int i = 0; i < ladrones.getChildNodes().getLength(); i++) {
			Ladron unLadron = Ladron.deserializar(ladrones.getChildNodes().item(i));
			listaLadrones.add(unLadron);
		}

		return listaLadrones;
	}

	public static Partida cargarPartida(Policia policia) throws ParserConfigurationException, SAXException, IOException {
		Document doc = inicializarDocumento(PATH + "partida" + policia.getRango().getNombre() + ".xml");

		Mapa mapa = cargarMapa();

		OrdenDeArresto orden = new OrdenDeArresto();
		orden.CargarBaseDeDatos();

		Partida unaPartida = Partida.deserializar(doc, policia, mapa, orden);
		return unaPartida;
	}

	public static Policia cargarPolicia() throws ParserConfigurationException, SAXException, IOException {
		Document doc = inicializarDocumento(SAVEDPATH + "partidaGuardada.xml");
		return Policia.deserializar(doc);
	}

	public static void guardarPartida(Policia policia) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		Element policiaSerializado = policia.serializar(doc);
		String fileName = "partidaGuardada.xml";

		doc.appendChild(policiaSerializado);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		File archivoDestino = new File(SAVEDPATH + fileName);
		StreamResult result = new StreamResult(archivoDestino);
		transformer.transform(source, result);
	}
	
	private static Document inicializarDocumento(String path) throws ParserConfigurationException, SAXException, IOException {
		File archivo = new File(path);

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();
		return doc;
	}

}
