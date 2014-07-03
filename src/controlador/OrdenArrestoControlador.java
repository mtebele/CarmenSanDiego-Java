package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.pantallas.*;
import modelo.Partida;
import modelo.ladron.*;

public class OrdenArrestoControlador {
	private Partida modeloPartida;
	private JuegoVista vista;
	private PanelOrdenArresto panel;

	public OrdenArrestoControlador(Partida modeloPartida, JuegoVista vista) {
		this.modeloPartida = modeloPartida;
		this.vista = vista;
		this.panel = new PanelOrdenArresto();

		vista.getContentPane().removeAll();
		vista.add(panel);
		vista.getContentPane().validate();

		this.panel.addEmitirOrdenListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emitirOrden();
			}
		});

		this.panel.addVolverAPanelPartidaListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAPanelPartida();
			}
		});

	}

	public void emitirOrden() {
		Ladron ladronSeleccionado = null;
		String nombreLadron = this.panel.verLadronSeleccionado();
		for (Ladron ladron : modeloPartida.verOrdenDeArresto().getBaseDeLadrones()) {
			if (nombreLadron.toUpperCase().equals(ladron.verNombre().toUpperCase())) {
				ladronSeleccionado = ladron;
				break;
			}
		}
		if ( nombreLadron == "Seleccione un ladron") {
			JOptionPane.showMessageDialog(null, "No has seleccionado ningún ladrón.");
		} else if (modeloPartida.verOrdenDeArresto().arrestoEsValido(ladronSeleccionado)) {
			modeloPartida.emitirOrden(ladronSeleccionado);
			JOptionPane.showMessageDialog(null, "La orden se ha emitido correctamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Ya fue emitida una orden de arresto. No puedes emitir otra!");
		}
	}

	public void volverAPanelPartida() {
		new PartidaControlador(modeloPartida, vista);
	}

}