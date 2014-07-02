package controlador;

import vista.pantallas.JuegoVista;
import vista.pantallas.PanelNuevaPartida;
import vista.pantallas.PanelInfoPolicia;
import modelo.Partida;
import modelo.mapa.Ciudad;

public class InfoPoliciaControlador {

	private JuegoVista vista;
	private PanelInfoPolicia panel;
	private Partida modeloPartida;

	public InfoPoliciaControlador(Partida modeloPartida, JuegoVista vista) {
		
		this.vista = vista;
		this.modeloPartida = modeloPartida;
		
		String nombre = this.modeloPartida.verNombrePolicia();
		String rango = this.modeloPartida.verRangoPolicia().getNombre();
		int cantArrestos = this.modeloPartida.verCantDeArrestos();
		this.panel = new PanelInfoPolicia(nombre, rango, cantArrestos);

		vista.getContentPane().removeAll();
		vista.add(panel);
		vista.getContentPane().validate();
	}

}
