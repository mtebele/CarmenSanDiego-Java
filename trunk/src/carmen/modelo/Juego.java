package carmen.modelo;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import carmen.modelo.perfil.Cabello;
import carmen.modelo.perfil.Hobby;
import carmen.modelo.perfil.Perfil;
import carmen.modelo.perfil.Senia;
import carmen.modelo.perfil.Sexo;
import carmen.modelo.perfil.Vehiculo;

public class Juego {

	private Policia policia;

	public Partida nuevaPartida() throws ParserConfigurationException, SAXException, IOException {

		this.policia = new Policia();
		
		// TODO: elegir un perfil
		Perfil perfilLadron = new Perfil("Mark", Sexo.MASCULINO, Cabello.ROJO, Senia.TATUAJE, Vehiculo.MOTO, Hobby.ALPINISMO);
		Ladron ladron = new Ladron(perfilLadron);

		Mapa mapa = LectorXML.cargarMapa();
		Ciudad ciudadActual = new Ciudad(new Coordenada(500, 500));
		Locacion locacionInicial = new Locacion(mapa, ciudadActual, ladron);
		Turno turno = new Turno(locacionInicial);

		OrdenDeArresto orden = new OrdenDeArresto();
		orden.CargarBaseDeDatos();

		return new Partida(this.policia, ladron, turno, orden);
	}
}