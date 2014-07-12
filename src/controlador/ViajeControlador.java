package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import vista.JuegoVista;
import vista.ViajarVista;
import modelo.Partida;
import modelo.mapa.Ciudad;

public class ViajeControlador {

	private JuegoVista vista;
	private ViajarVista panel;
	private Partida modeloPartida;
	private final static int MAX_DESTINOS = 4;

	public ViajeControlador(Partida modeloPartida, JuegoVista vista) {

		this.vista = vista;
		this.modeloPartida = modeloPartida;

		Collections.shuffle(modeloPartida.verDestinos());

		List<String> destinos = new ArrayList<String>();
		List<Integer> horas = new ArrayList<Integer>();
		for (int i = 1; i <= MAX_DESTINOS; i++) {
			Ciudad unDestino = this.modeloPartida.verDestinoNro(i);
			destinos.add(unDestino.getNombre());
			horas.add(this.modeloPartida.hsViajeAOtraCiudad(unDestino));
		}

		this.panel = new ViajarVista(destinos, horas);

		vista.mostrarPanel(panel);

		this.panel.addViajarListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String destinoString = ((JButton) e.getSource()).getText();
				viajar(destinoString);
			}
		});

		this.panel.addVolverAPanelPartida(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAPanelPartida();
			}
		});

	}

	public void viajar(String destinoString) {
		for (int i = 1; i <= MAX_DESTINOS; i++) {
			Ciudad destino = modeloPartida.verDestinoNro(i);
			if (destino.getNombre() == destinoString) {
				modeloPartida.viajar(destino);
				break;
			}
		}

		if (!modeloPartida.quedaTiempo()) {
			JOptionPane.showMessageDialog(null, "Oops! Te quedaste sin tiempo!");
			new PerdedorControlador(this.vista);
		} else {
			volverAPanelPartida();
		}

	}

	public void volverAPanelPartida() {
		new PartidaControlador(modeloPartida, vista);
	}

}
