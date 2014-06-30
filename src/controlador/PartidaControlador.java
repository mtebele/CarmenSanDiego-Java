package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import favax.swing.JButton;

import vista.pantallas.PanelPartida;
//import vista.pantallas.PanelInfoPolicia;
//import vista.pantallas.PanelInterrogar;
//import vista.pantallas.PanelOrdenArresto;
//import vista.pantallas.PanelLadrones;
import modelo.Partida;


public class PartidaControlador {
	private Partida modelo;
	private PanelPartida vista;
	
	public PartidaControlador(Partida modelo, PanelPartida vista) {
		this.modelo = modelo;
		this.vista = vista;
		
		this.vista.addViajarListener(new ActionListener {
			public void actionPerformed(ActionEvent e) {
				String buttonText = ((JButton) e.getSource()).getText();
				//TODO: busco entre los posibles destinos el que coincida el nombre y viajo ahi.

			}
		});
		
	}
	
	
}