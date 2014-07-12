package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.InfoPoliciaVista;
import vista.JuegoVista;
import modelo.Partida;

public class InfoPoliciaControlador {

	private JuegoVista vista;
	private InfoPoliciaVista panel;
	private Partida modeloPartida;

	public InfoPoliciaControlador(Partida modeloPartida, JuegoVista vista) {

		this.vista = vista;
		this.modeloPartida = modeloPartida;

		String nombre = this.modeloPartida.verNombrePolicia();
		String rango = this.modeloPartida.verRangoPolicia().getNombre();
		int cantArrestos = this.modeloPartida.verCantDeArrestos();
		this.panel = new InfoPoliciaVista(nombre, rango, cantArrestos);

		vista.mostrarPanel(panel);

		this.panel.addVolverAPanelPartida(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAPanelPartida();
			}
		});
	}

	public void volverAPanelPartida() {
		new PartidaControlador(modeloPartida, vista);
	}

}
