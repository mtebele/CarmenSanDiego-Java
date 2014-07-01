package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;

import modelo.Partida;
import modelo.mapa.*;
import vista.pantallas.*;


public class PantallasControlador {
	private Partida modeloPartida;
	private JuegoVista vista;
	
	public PantallasControlador(Partida modeloPartida, JuegoVista vista) {
		this.modeloPartida = modeloPartida;
		this.vista = vista;
		
		this.vista.addAbrirPanelViajesListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirPanelViajes();
			}
		});
		
		this.vista.addAbrirPanelGanadorListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirPanelGanador();
			}
		});
		
	}
	
	public void abrirPanelViajes() {
		Ciudad destino1 = this.modeloPartida.verDestinoNro(1);
		Ciudad destino2 = this.modeloPartida.verDestinoNro(2);
		Ciudad destino3 = this.modeloPartida.verDestinoNro(3);
		Ciudad destino4 = this.modeloPartida.verDestinoNro(4);
		PanelViajar pnlViajar = new PanelViajar(destino1, destino2, destino3, destino4);
		
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
		
		PanelPartida pnlPartida = new PanelPartida(horasRestantes, horaActual, nombreLocal1, nombreCiudad);
		
		vista.getContentPane().removeAll();
		vista.add(pnlPartida);
		vista.getContentPane().validate();
	}
	
	public void abrirPanelGanador() {
		vista.getContentPane().removeAll();
		vista.add(new PanelGanador());
		vista.getContentPane().validate();
	}
	
	
}