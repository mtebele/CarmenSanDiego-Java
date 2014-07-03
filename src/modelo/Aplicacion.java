package modelo;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import controlador.JuegoControlador;
import vista.JuegoVista;

public class Aplicacion {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		Juego modelo = new Juego();
		JuegoVista vista = new JuegoVista();		
		new JuegoControlador(modelo, vista);
	}

}
