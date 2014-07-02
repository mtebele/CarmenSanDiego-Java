package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controlador.*;
import vista.pantallas.*;
import modelo.Partida;
import modelo.mapa.*;

public class PartidaControlador {
	private Partida modeloPartida;
	private JuegoVista vista;
	private PanelPartida panel;

	private static int MAX_CIUDADES = 4;
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
		  
		/* this.vista.addEmitirOrdenListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
		  
		 emitirOrden(); } }); */
		 

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

	private void update() {
		
		int horasRestantes = modeloPartida.getHorasRestantes();
		int horaActual = modeloPartida.getHoraActual();
		String nombreLocal1 = modeloPartida.verLocalNro(1).getNombre();
		String nombreLocal2 = modeloPartida.verLocalNro(2).getNombre();
		String nombreLocal3 = modeloPartida.verLocalNro(3).getNombre();
		String nombreCiudad = modeloPartida.ciudadActual().getNombre();

		this.panel = new PanelPartida(horasRestantes, horaActual, nombreLocal1, nombreLocal2, nombreLocal3,
				nombreCiudad);

		vista.getContentPane().removeAll();
		vista.add(panel);
		vista.getContentPane().validate();		
	}

	public void viajar(String destinoString) {
		for (Ciudad destino : modeloPartida.verDestinos()) {
			if (destino.getNombre() == destinoString) {
				modeloPartida.viajar(destino);
				break;
			}
		}
		if (!modeloPartida.quedaTiempo()) {
			new PerdedorControlador(this.vista);
		}
		
		update();
	}

	public void interrogar(String localString) {
		String pista = null;
		for (int i = 1; i <= MAX_LOCALES; i++) {
			Local local = modeloPartida.verLocalNro(i);
			if (local.getNombre() == localString) {
				pista = modeloPartida.interrogar(local);
				break;
			}
			if (modeloPartida.partidaGanada()){
				new GanadorControlador(this.vista);
			}
			else if (!modeloPartida.partidaGanada() && modeloPartida.partidaTerminada()) {
				new PerdedorControlador(this.vista);
			}

			new InterrogarControlador(modeloPartida, this.vista, pista);
		}
		if (!modeloPartida.quedaTiempo())
			new PerdedorControlador(this.vista);
	}

	/*public void emitirOrden() {
		this.modeloPartida.emitirOrden(ladron);
	}*/

	public void volverAPanelNuevaPartida() {
		new NuevaPartidaControlador(modeloPartida, vista);
	}
	
}