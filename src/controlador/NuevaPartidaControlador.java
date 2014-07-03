package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Juego;
import modelo.Partida;
import vista.pantallas.JuegoVista;
import vista.pantallas.PanelNuevaPartida;

public class NuevaPartidaControlador {

	private JuegoVista vista;
	private PanelNuevaPartida panel;
	private Partida modeloPartida;

	public NuevaPartidaControlador(Partida partida, JuegoVista vista) {
		String ciudadActual = partida.ciudadActual().getNombre();
		this.panel = new PanelNuevaPartida(ciudadActual);
		this.modeloPartida = partida;
		this.vista = vista;

		vista.getContentPane().removeAll();
		vista.add(panel);
		vista.getContentPane().validate();

		this.panel.addAbrirPanelPartidaListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirPanelPartida();
			}
		});

		this.panel.addVolverAPanelInicialListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAPanelInicial();
			}
		});

	}

	public void abrirPanelPartida() {
		new PartidaControlador(modeloPartida, vista);
	}

	public void volverAPanelInicial() {
		vista.dispose();

		Juego juego = new Juego();
		JuegoVista vista = new JuegoVista();
		new JuegoControlador(juego, vista);
	}

}
