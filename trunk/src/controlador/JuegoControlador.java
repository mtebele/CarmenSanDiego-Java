package controlador;

import vista.JuegoVista;
import modelo.Juego;

public class JuegoControlador {
	private Juego juego;
	private JuegoVista juegoVista;

	public JuegoControlador(Juego modelo, JuegoVista vista) {
		this.juego = modelo;
		this.juegoVista = vista;
	}

}
