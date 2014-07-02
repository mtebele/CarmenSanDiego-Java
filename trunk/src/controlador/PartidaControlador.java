package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controlador.PantallasControlador;
import vista.pantallas.*;
import modelo.Partida;
import modelo.mapa.*;

public class PartidaControlador {
	private Partida modeloPartida;
	private JuegoVista vista;
	private PanelPartida panel;

	private static int MAX_CIUDADES = 4;
	private static int MAX_LOCALES = 3;

	public PartidaControlador(Partida modeloPartida, JuegoVista vista) {
		this.modeloPartida = modeloPartida;
		this.vista = vista;
		
		update();

		this.panel.addViajarListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String destinoString = ((JButton) e.getSource()).getText();
				viajar(destinoString);
			}
		});

		/*
		 * this.vista.addInterrogarListener(new ActionListener() { public void actionPerformed(ActionEvent e) { String
		 * localString = ((JButton) e.getSource()).getText(); interrogar(localString); } });
		 * 
		 * this.vista.addEmitirOrdenListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
		 * 
		 * emitirOrden(); } });
		 */

	}

	private void update() {
		
		int horasRestantes = modeloPartida.getHorasRestantes();
		int horaActual = modeloPartida.getHoraActual();
		String nombreLocal1 = modeloPartida.verLocalNro(1).getNombre();
		String nombreLocal2 = modeloPartida.verLocalNro(2).getNombre();
		String nombreLocal3 = modeloPartida.verLocalNro(3).getNombre();
		String nombreCiudad = modeloPartida.ciudadActual().getNombre();

		this.panel = new PanelPartida(horasRestantes, horaActual, nombreLocal1, nombreLocal2, nombreLocal3,
				nombreCiudad);

		vista.getContentPane().removeAll();
		vista.add(panel);
		vista.getContentPane().validate();		
	}

	public void viajar(String destinoString) {
		for (Ciudad destino : modeloPartida.verDestinos()) {
			if (destino.getNombre() == destinoString) {
				modeloPartida.viajar(destino);
				break;
			}
		}
		if (!modeloPartida.quedaTiempo()) {
			new PerdedorControlador(this.vista);
		}
		
		update();
	}

	/*public void interrogar(String localString) {
		String pista = null;
		for (int i = 1; i <= MAX_LOCALES; i++) {
			Local local = modeloPartida.verLocalNro(i);
			if (local.getNombre() == localString) {
				pista = modeloPartida.interrogar(local);
				break;
			}
			if (modeloPartida.partidaGanada())
				controladorPantallas.abrirPanelGanador();
			else if (!modeloPartida.partidaGanada() && modeloPartida.partidaTerminada())
				new PerdedorControlador(this.vista);

			controladorPantallas.abrirPanelInterrogar(pista);
		}
		if (!modeloPartida.quedaTiempo())
			new PerdedorControlador(this.vista);
	}*/

	/*public void emitirOrden() {
		this.modeloPartida.emitirOrden(ladron);
	}*/

}