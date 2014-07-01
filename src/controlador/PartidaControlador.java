package controlador;

import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.JButton;

import controlador.PantallasControlador;
import vista.pantallas.*;
import modelo.Partida;
import modelo.mapa.*;


public class PartidaControlador {
	private Partida modeloPartida;
	private JuegoVista vista;
	private PantallasControlador controladorPantallas;
	
	public PartidaControlador(Partida modeloPartida, JuegoVista vista, PantallasControlador controladorPantallas) {
		this.modeloPartida = modeloPartida;
		this.vista = vista;
		this.controladorPantallas = controladorPantallas;
		
		this.vista.addViajarListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String destinoString = ((JButton) e.getSource()).getText();
				viajar(destinoString);
			}
		});
		
		this.vista.addInterrogarListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String localString = ((JButton) e.getSource()).getText();
				interrogar(localString);
			}
		});
		
		this.vista.addEmitirOrdenListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emitirOrden();
			}
		});
		
	}
		
	public void viajar(String destinoString) {
		for ( int i=0; i<4; i++ ) {
			Ciudad destino = modeloPartida.verDestinoNro(i);
			if ( destino.getNombre() == destinoString ) {
				modeloPartida.viajar(destino);
				break;
			}
		}
		if (! modeloPartida.quedaTiempo() ) controladorPantallas.abrirPanelPerdedor();
		
		controladorPantallas.abrirPanelPartida();
	}
	
	public void interrogar(String localString) {
		String pista = null;
		for ( int i=0; i<3; i++ ) {
			Local local = modeloPartida.verLocalNro(i);
			if ( local.getNombre() == localString ) {
				pista = modeloPartida.interrogar(local);
				break;
			}
			if ( modeloPartida.partidaGanada() ) controladorPantallas.abrirPanelGanador();
			else if ( ! modeloPartida.partidaGanada() && modeloPartida.partidaTerminada() ) controladorPantallas.abrirPanelPerdedor();
			
			controladorPantallas.abrirPanelInterrogar(pista);
		}
		if (! modeloPartida.quedaTiempo() ) controladorPantallas.abrirPanelPerdedor();
	}
	
}