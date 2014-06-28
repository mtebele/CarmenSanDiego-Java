package controlador;

import vista.JuegoVista;
import modelo.Juego;

public class JuegoControlador {
	private Juego modelo;
	private JuegoVista vista;

	public JuegoControlador(Juego modelo, JuegoVista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
}
