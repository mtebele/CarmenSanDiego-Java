package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.pantallas.*;
import modelo.Partida;

public class InterrogarControlador {
	private Partida modeloPartida;
	private JuegoVista vista;
	private PanelInterrogar panel;
	private String pista;

	public InterrogarControlador(Partida modeloPartida, JuegoVista vista, String pista) {
		this.modeloPartida = modeloPartida;
		this.vista = vista;
		this.pista = pista;
		this.panel = new PanelInterrogar(pista);

		vista.getContentPane().removeAll();
		vista.add(panel);
		vista.getContentPane().validate();
		
		this.panel.addVolverAPanelPartida(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAPanelPartida();
			}
		});
	}
	
	public void volverAPanelPartida() {
		new PartidaControlador(modeloPartida, vista);
	}
	
}