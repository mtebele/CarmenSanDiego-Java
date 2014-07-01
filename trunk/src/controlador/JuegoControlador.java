package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import vista.pantallas.JuegoVista;
import vista.pantallas.PanelNuevaPartida;
import modelo.Juego;
import modelo.Partida;
import controlador.PartidaControlador;

public class JuegoControlador {
	private Juego modelo;
	private JuegoVista vista;

	public JuegoControlador(Juego modelo, JuegoVista vista) {
		this.modelo = modelo;
		this.vista = vista;

		this.vista.addNuevaPartidaListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevaPartida();

				/*JFrame frmPartida = new JFrame();
				frmPartida.setSize(800, 600);
				frmPartida.setVisible(true);
				frmPartida.add(new PanelNuevaPartida());*/
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

				JFrame frmPartida = new JFrame();
				frmPartida.setSize(800, 600);
				frmPartida.setVisible(true);
				frmPartida.add(new PanelNuevaPartida());
			}
		});
		
		
	}

	private void nuevaPartida() {
		vista.getContentPane().removeAll();
		vista.add(new PanelNuevaPartida());
		vista.getContentPane().validate();
		
		try {
			Partida modeloPartida = this.modelo.nuevaPartida();
			new PartidaControlador(modeloPartida, this.vista);
			
		} catch (ParserConfigurationException | SAXException | IOException e1) {
			e1.printStackTrace();
		}
	}

	private void cargarPartida() {
		try {
			Partida modeloPartida = this.modelo.cargarPartida();
			new PartidaControlador(modeloPartida, this.vista);
			
		} catch (ParserConfigurationException | SAXException | IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/*private void guardarPartida() {
		try {
			this.modelo.guardarPartida(policia);
		} catch (ParserConfigurationException | SAXException | IOException e1) {
			e1.printStackTrace();
		}
	}*/
}
