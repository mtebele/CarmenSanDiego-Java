package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import vista.JuegoVista;
import vista.PartidaVista;
import modelo.Partida;
import modelo.mapa.*;

public class PartidaControlador {
	private Partida modeloPartida;
	private JuegoVista vista;
	private PartidaVista panel;

	private static int MAX_LOCALES = 3;

	public PartidaControlador(Partida modeloPartida, JuegoVista vista) {
		this.modeloPartida = modeloPartida;
		this.vista = vista;

		update();

		this.panel.addAbrirPanelInfoPoliciaListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirPanelInfoPolicia();
			}
		});

		this.panel.addAbrirPanelLadronesListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirPanelLadrones();
			}
		});

		this.panel.addAbrirPanelViajarListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirPanelViajar();
			}
		});

		this.panel.addAbrirPanelOrdenArrestoListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirPanelOrdenArresto();
			}
		});

		this.panel.addVolverAPanelNuevaPartidaListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAPanelNuevaPartida();
			}
		});

		this.panel.addInterrogarListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String localString = ((JButton) e.getSource()).getText();
				interrogar(localString);
			}
		});
	}

	private void AbrirPanelInfoPolicia() {
		new InfoPoliciaControlador(modeloPartida, vista);
	}

	private void AbrirPanelLadrones() {
		new LadronesControlador(modeloPartida, vista);
	}

	private void AbrirPanelViajar() {
		new ViajeControlador(modeloPartida, vista);
	}

	private void AbrirPanelOrdenArresto() {
		new OrdenArrestoControlador(modeloPartida, vista);
	}

	private void update() {

		int horasRestantes = modeloPartida.getHorasRestantes();
		int horaActual = modeloPartida.getHoraActual();
		String nombreLocal1 = modeloPartida.verLocalNro(1).getNombre();
		String nombreLocal2 = modeloPartida.verLocalNro(2).getNombre();
		String nombreLocal3 = modeloPartida.verLocalNro(3).getNombre();
		String nombreCiudad = modeloPartida.ciudadActual().getNombre();

		this.panel = new PartidaVista(horasRestantes, horaActual, nombreLocal1, nombreLocal2, nombreLocal3,
				nombreCiudad);

		vista.mostrarPanel(panel);
	}

	public void interrogar(String localString) {
		String pista = null;
		for (int i = 1; i <= MAX_LOCALES; i++) {
			Local local = modeloPartida.verLocalNro(i);
			if (local.getNombre().toUpperCase() == localString.toUpperCase()) {
				pista = modeloPartida.interrogar(local);
				boolean fueAtacado = modeloPartida.fueAtacado();
				if (fueAtacado)
					JOptionPane.showMessageDialog(null, "Oh! Has sido atacado! Esto te demorará un poco...");
				break;
			}
		}

		if (!modeloPartida.quedaTiempo()) {
			JOptionPane.showMessageDialog(null, "Oops! Te quedaste sin tiempo!");
			new PerdedorControlador(this.vista);
			return;
		}

		if (modeloPartida.esUltimaCiudad()
				&& modeloPartida.getLadron().ciudadActual().equals(modeloPartida.ciudadActual())
				&& (modeloPartida.ciudadActual().cantLocalesVisitados() == 3)) {
			modeloPartida.atraparLadron();
		}

		if (modeloPartida.partidaGanada()) {
			new GanadorControlador(this.vista);
		} else if (!modeloPartida.partidaGanada() && modeloPartida.partidaTerminada()) {
			JOptionPane
					.showMessageDialog(null,
							"Has atrapado al ladrón pero fue liberado debido a que no existía una orden de arresto emitida en su contra.");
			new PerdedorControlador(this.vista);
		} else {
			new InterrogarControlador(modeloPartida, this.vista, pista);
		}
	}

	public void volverAPanelNuevaPartida() {
		new NuevaPartidaControlador(modeloPartida, vista);
	}

}