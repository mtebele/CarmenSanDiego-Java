package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Juego;
import vista.pantallas.*;

public class PerdedorControlador {

	private PanelPerdedor panel;
	private JuegoVista vista;
	
	public PerdedorControlador(JuegoVista vista) {
		this.vista = vista;
		this.panel = new PanelPerdedor();
		vista.getContentPane().removeAll();
		vista.add(panel);
		vista.getContentPane().validate();
		
		this.panel.addVolverAPanelInicialListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAPanelInicial();
			}
		});
		
		this.panel.addSalirJuegoListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int salida = JOptionPane.showOptionDialog(null, "¿Desea Salir del Juego?", "Confirmar salida",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Si", "No" }, "default");
				if (salida == 0) {
					System.exit(0);
				}
			}
		});
	}
	
	public void volverAPanelInicial() {
		vista.dispose();
		
		Juego juego = new Juego();
		JuegoVista vista = new JuegoVista();
		new JuegoControlador(juego, vista);
	}
	
}
