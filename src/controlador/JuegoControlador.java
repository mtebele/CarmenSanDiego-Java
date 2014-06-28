package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import vista.JuegoVista;
import vista.paneles.PanelNuevaPartida;
import modelo.Juego;

public class JuegoControlador {
	private Juego modelo;
	private JuegoVista vista;

	public JuegoControlador(Juego modelo, JuegoVista vista) {
		this.modelo = modelo;
		this.vista = vista;

		this.vista.addNuevaPartidaListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmPartida = new JFrame();
				frmPartida.setSize(800, 600);
				frmPartida.setVisible(true);
				frmPartida.add(new PanelNuevaPartida());
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
	}
	
	public void nuevaPartida() {
		try {
			this.modelo.nuevaPartida();
		} catch (ParserConfigurationException | SAXException | IOException e1) {
			e1.printStackTrace();
		}
	}
}
