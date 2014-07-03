package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Partida;
import vista.pantallas.JuegoVista;
import vista.pantallas.PanelLadrones;

public class LadronesControlador {

	private JuegoVista vista;
	private PanelLadrones panel;
	private Partida modeloPartida;

	public LadronesControlador(Partida modeloPartida, JuegoVista vista) {

		this.vista = vista;
		this.modeloPartida = modeloPartida;
		this.panel = new PanelLadrones();

		vista.getContentPane().removeAll();
		vista.add(panel);
		vista.getContentPane().validate();

		this.panel.addVolverAPanelPartidaListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAPanelPartida();
			}
		});

	}

	public void volverAPanelPartida() {
		new PartidaControlador(modeloPartida, vista);
	}

}