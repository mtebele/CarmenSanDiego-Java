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

	public InterrogarControlador(Partida modeloPartida, JuegoVista vista) {
		this.modeloPartida = modeloPartida;
		this.vista = vista;
		this.panel = new InterrogarVista();

		this.panel.addVolverAPanelPartida(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAPanelPartida();
			}
		});
	}

	public void volverAPanelPartida() {
		new PartidaControlador(modeloPartida, vista);
	}
	
	public void activar(String pista) {
		this.panel.setPista(pista);
		vista.mostrarPanel(panel);
	}

}