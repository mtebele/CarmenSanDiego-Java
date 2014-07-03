package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import vista.pantallas.*;
import modelo.Juego;
import modelo.Partida;

public class JuegoControlador {
	private Juego modelo;
	private JuegoVista vista;
	private static final String SAVEDPATH = "xml/saved/partidaGuardada.xml";

	public JuegoControlador(Juego modelo, JuegoVista vista) {
		this.modelo = modelo;
		this.vista = vista;
		checkPartidaGuardada();

		this.vista.addNuevaPartidaListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevaPartida();
			}
		});

		this.vista.addSalirJuegoListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int salida = JOptionPane.showOptionDialog(null, "¿Desea Salir del Juego?", "Confirmar salida",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Si", "No" }, "default");
				if (salida == 0) {
					System.exit(0);
				}
			}
		});

		this.vista.addCargarPartidaListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPartida();
			}
		});

	}

	private void checkPartidaGuardada() {
		File archivo = new File(SAVEDPATH);
		this.vista.enableCargarPartida(archivo.exists());
	}

	private void nuevaPartida() {
		try {
			Partida modeloPartida = this.modelo.nuevaPartida();
			new NuevaPartidaControlador(modeloPartida, this.vista);
		} catch (ParserConfigurationException | SAXException | IOException e1) {
			e1.printStackTrace();
		}
	}

	private void cargarPartida() {
		try {
			Partida modeloPartida = this.modelo.cargarPartida();
			new NuevaPartidaControlador(modeloPartida, this.vista);
		} catch (ParserConfigurationException | SAXException | IOException e1) {
			e1.printStackTrace();
		}
	}

	/*
	 * private void guardarPartida() { try { this.modelo.guardarPartida(policia); } catch (ParserConfigurationException
	 * | SAXException | IOException e1) { e1.printStackTrace(); } }
	 */
}
