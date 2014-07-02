package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;

import modelo.*;
import modelo.mapa.*;
import modelo.policia.Rango;
import vista.pantallas.*;

public class PantallasControlador {
	private Partida modeloPartida;
	private JuegoVista vista;

	public PantallasControlador(Partida modeloPartida, JuegoVista vista) {
		this.modeloPartida = modeloPartida;
		this.vista = vista;

		this.vista.addAbrirPanelViajarListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirPanelViajar();
			}
		});

		this.vista.addAbrirPanelGanadorListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirPanelGanador();
			}
		});

		this.vista.addAbrirPanelPerdedorListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirPanelPerdedor();
			}
		});

		this.vista.addAbrirPanelOrdenArrestoListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirPanelOrdenArresto();
			}
		});

		this.vista.addAbrirPanelInfoPoliciaListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirPanelInfoPolicia();
			}
		});

		this.vista.addAbrirPanelLadronesListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirPanelLadrones();
			}
		});

		this.vista.addAbrirPanelPerfilLadronListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				abrirPanelPerfilLadron();
			}
		});

		this.vista.addAbrirPanelOrdenOKListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirPanelOrdenOK();
			}
		});

	}

	public void abrirPanelViajar() {
		Ciudad destino1 = this.modeloPartida.verDestinoNro(1);
		Ciudad destino2 = this.modeloPartida.verDestinoNro(2);
		Ciudad destino3 = this.modeloPartida.verDestinoNro(3);
		Ciudad destino4 = this.modeloPartida.verDestinoNro(4);
		PanelViajar pnlViajar = new PanelViajar(destino1.getNombre(), destino2.getNombre(), destino3.getNombre(),
				destino4.getNombre());

		vista.getContentPane().removeAll();
		vista.add(pnlViajar);
		vista.getContentPane().validate();

	}

	public void abrirPanelInterrogar(String pista) {
		PanelInterrogar pnlInterrogar = new PanelInterrogar(pista);

		vista.getContentPane().removeAll();
		vista.add(pnlInterrogar);
		vista.getContentPane().validate();
	}

	public void abrirPanelPartida() {
		int horasRestantes = modeloPartida.getHorasRestantes();
		int horaActual = modeloPartida.getHoraActual();
		String nombreLocal1 = modeloPartida.verLocalNro(1).getNombre();
		String nombreLocal2 = modeloPartida.verLocalNro(2).getNombre();
		String nombreLocal3 = modeloPartida.verLocalNro(3).getNombre();
		String nombreCiudad = modeloPartida.ciudadActual().getNombre();

		// Las que dos lineas que estan comentantadas son las que van, el add sin comentar es el que deberia funcionar
		// de prueba,
		// y que en un principio nos funcionaba. Pero al hacer el controlador pantallas dejo de funcionar.

		// PanelPartida pnlPartida = new PanelPartida(horasRestantes, horaActual, nombreLocal1, nombreCiudad);

		vista.getContentPane().removeAll();
		// vista.add(pnlPartida);
		vista.add(new PanelNuevaPartida());
		vista.getContentPane().validate();
	}

	public void abrirPanelGanador() {
		vista.getContentPane().removeAll();
		vista.add(new PanelGanador());
		vista.getContentPane().validate();
	}

	public void abrirPanelPerdedor() {
		vista.getContentPane().removeAll();
		vista.add(new PanelPerdedor());
		vista.getContentPane().validate();
	}

	public void abrirPanelOrdenArresto() {
		vista.getContentPane().removeAll();
		vista.add(new PanelOrdenArresto());
		vista.getContentPane().validate();
	}

	public void abrirPanelInfoPolicia() {
		int cantArrestos = modeloPartida.verCantDeArrestos();
		Rango rangoPolicia = modeloPartida.verRangoPolicia();
		PanelInfoPolicia pnlInfoPolicia = new PanelInfoPolicia(rangoPolicia.getNombre(), cantArrestos);

		vista.getContentPane().removeAll();
		vista.add(pnlInfoPolicia);
		vista.getContentPane().validate();
	}

	public void abrirPanelLadrones() {
		vista.getContentPane().removeAll();
		vista.add(new PanelLadrones());
		vista.getContentPane().validate();
	}

	public void abrirPanelPerfilLadron() {
		vista.getContentPane().removeAll();
		String nombreLadron = this.modeloPartida.getLadron().verNombre();
		vista.add(new PanelPerfilLadron(nombreLadron));
		vista.getContentPane().validate();
	}

}