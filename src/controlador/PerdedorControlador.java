package controlador;

import javax.swing.JPanel;

import vista.pantallas.JuegoVista;
import vista.pantallas.PanelPerdedor;

public class PerdedorControlador {

	private JPanel panel;
	private JuegoVista vista;
	
	public PerdedorControlador(JuegoVista vista) {
		this.vista = vista;
		this.panel = new PanelPerdedor();
		vista.getContentPane().removeAll();
		vista.add(panel);
		vista.getContentPane().validate();
	}
	
}
