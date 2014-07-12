package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Juego;
import modelo.Partida;
import vista.JuegoVista;
import vista.NuevaPartidaVista;

public class NuevaPartidaControlador {

	private JuegoVista vista;
	private NuevaPartidaVista panel;
	private Partida modeloPartida;

	public NuevaPartidaControlador(Partida partida, JuegoVista vista) {
		String ciudadActual = partida.verCiudadInicial().getNombre();
		String sexoLadron = partida.getLadron().verSexo();
		this.panel = new NuevaPartidaVista(ciudadActual, sexoLadron);
		this.modeloPartida = partida;
		this.vista = vista;
		
		vista.mostrarPanel(panel);

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
