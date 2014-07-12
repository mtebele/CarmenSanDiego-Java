package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Partida;
import vista.JuegoVista;
import vista.LadronesVista;

public class LadronesControlador {

	private JuegoVista vista;
	private LadronesVista panel;
	private Partida modeloPartida;

	public LadronesControlador(Partida modeloPartida, JuegoVista vista) {

		this.vista = vista;
		this.modeloPartida = modeloPartida;
		this.panel = new LadronesVista();

		this.panel.addVolverAPanelPartidaListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAPanelPartida();
			}
		});
	}

	public void volverAPanelPartida() {
		new PartidaControlador(modeloPartida, vista);
	}
	
	public void activar() {
		vista.mostrarPanel(panel);
	}
}