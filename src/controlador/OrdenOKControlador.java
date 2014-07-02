package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Partida;
import controlador.*;
import vista.pantallas.*;

public class OrdenOKControlador {
	private Partida modeloPartida;
	private JuegoVista vista;
	private PanelOrdenOK panel;
	
	public OrdenOKControlador(Partida modeloPartida, JuegoVista vista) {
		this.modeloPartida = modeloPartida;
		this.vista = vista;
		this.panel = new PanelOrdenOK();
		
		vista.getContentPane().removeAll();
		vista.add(panel);
		vista.getContentPane().validate();
		
		this.panel.addVolverAPanelPartidaListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAPanelPartida();
			}
		});
	}
	
	public void volverAPanelPartida() {
		new PartidaControlador(modeloPartida, vista);
	}
	
}