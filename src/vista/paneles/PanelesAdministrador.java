package vista.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelesAdministrador {
	private JFrame ventana;

	public PanelesAdministrador(JFrame unaVentana) {
		ventana = unaVentana;
	}

	public void agregarPanel(JPanel unPanel) {
		unPanel.setVisible(false);
		ventana.getContentPane().add(unPanel);
	}

	public void esconderPanel(JPanel unPanel) {
		unPanel.setVisible(false);
	}

	public void mostrarPanel(JPanel unPanel) {
		unPanel.setVisible(true);
	}

}
