package vista.botonesGenericos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import vista.pantallas.PanelNuevaPartida;
import vista.pantallas.PanelOrdenArresto;

public class BotonNuevoJuego extends JButton {
	private static int MAX_ALTURA = 100;
	private static int MAX_ANCHURA = 200;

	public BotonNuevoJuego() {
		super("Nuevo Juego");
		setSize(MAX_ALTURA, MAX_ANCHURA);
		setVisible(true);
		/*addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: nueva partida
				JFrame frmPartida = new JFrame();
				frmPartida.setSize(800, 600);
				frmPartida.setVisible(true);
				frmPartida.add(new PanelNuevaPartida());
			}
		});*/
	}
}
