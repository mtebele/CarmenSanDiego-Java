package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Partida;
import modelo.mapa.Ciudad;
import vista.pantallas.JuegoVista;
import vista.pantallas.PanelNuevaPartida;
import vista.pantallas.PanelPartida;

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
	}

	public void abrirPanelPartida() {

		/* VIEJO:
		int horasRestantes = modeloPartida.getHorasRestantes();
		int horaActual = modeloPartida.getHoraActual();
		String nombreLocal1 = modeloPartida.verLocalNro(1).getNombre();
		String nombreLocal2 = modeloPartida.verLocalNro(2).getNombre();
		String nombreLocal3 = modeloPartida.verLocalNro(3).getNombre();
		String nombreCiudad = modeloPartida.ciudadActual().getNombre();
		 
		PanelPartida pnlPartida = new PanelPartida(horasRestantes, horaActual, nombreLocal1, nombreLocal2,
				nombreLocal3, nombreCiudad);

		vista.getContentPane().removeAll();
		vista.add(pnlPartida);
		vista.getContentPane().validate();*/
		
		/* NUEVO: */
		new PartidaControlador(modeloPartida, vista);
	}

}
