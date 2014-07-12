package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.InterrogarVista;
import vista.JuegoVista;
import modelo.Partida;

public class InterrogarControlador {
	private Partida modeloPartida;
	private JuegoVista vista;
	private InterrogarVista panel;

	public InterrogarControlador(Partida modeloPartida, JuegoVista vista, String pista) {
		this.modeloPartida = modeloPartida;
		this.vista = vista;
		this.panel = new InterrogarVista(pista);

		vista.mostrarPanel(panel);

		this.panel.addVolverAPanelPartida(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAPanelPartida();
			}
		});
	}

	public void volverAPanelPartida() {
		new PartidaControlador(modeloPartida, vista);
	}

}