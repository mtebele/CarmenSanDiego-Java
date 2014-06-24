package carmen.modelo;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import carmen.modelo.ladron.perfil.Cabello;
import carmen.modelo.ladron.perfil.Hobby;
import carmen.modelo.ladron.perfil.Perfil;
import carmen.modelo.ladron.perfil.Senia;
import carmen.modelo.ladron.perfil.Sexo;
import carmen.modelo.ladron.perfil.Vehiculo;
import carmen.modelo.mapa.Mapa;
import carmen.modelo.policia.OrdenDeArresto;
import carmen.modelo.policia.Policia;

public class Juego {

	private Policia policia;

	public Partida nuevaPartida() throws ParserConfigurationException, SAXException, IOException {

		this.policia = new Policia();
		Mapa mapa = LectorXML.cargarMapa();

		// TODO: elegir un perfil
		/*
		 * Perfil perfilLadron = new Perfil("Mark", Sexo.MASCULINO, Cabello.ROJO, Senia.TATUAJE, Vehiculo.MOTO,
		 * Hobby.ALPINISMO); Ladron ladron = new Ladron(perfilLadron);
		 * 
		 * 
		 * Ciudad ciudadActual = new Ciudad(new Coordenada(500, 500)); Locacion locacionInicial = new Locacion(mapa,
		 * ciudadActual, ladron); Turno turno = new Turno(locacionInicial);
		 */

		OrdenDeArresto orden = new OrdenDeArresto();
		orden.CargarBaseDeDatos();

		Partida partida = LectorXML.cargarPartida(this.policia, mapa, orden);

		// return new Partida(this.policia, ladron, turno, orden);
		return partida;
	}
}