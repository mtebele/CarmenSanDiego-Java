package controlador;

import vista.pantallas.JuegoVista;
import vista.pantallas.PanelNuevaPartida;
import vista.pantallas.PanelLadrones;
import modelo.Partida;
import modelo.mapa.Ciudad;

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
	}

}