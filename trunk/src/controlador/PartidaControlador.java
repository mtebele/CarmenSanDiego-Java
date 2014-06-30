package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

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
				this.modelo.viajar(e.getSource().destino());
				//Cada boton de la vista tendra relacionado como atributo un destino
				//particular. La asignacion se efectuara desde la vista misma.
				
				//Al clickear tambien se redibujara el PanelPartida principal, pero eso
				//tambien se hara desde la vista.
			}
		});
		
	}
	
	
}