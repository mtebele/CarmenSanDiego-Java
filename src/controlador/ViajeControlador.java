package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import vista.JuegoVista;
import vista.ViajarVista;
import modelo.Partida;
import modelo.mapa.Ciudad;

public class ViajeControlador {

	private JuegoVista vista;
	private ViajarVista panel;
	private Partida modeloPartida;

	public ViajeControlador(Partida modeloPartida, JuegoVista vista) {
		
		this.vista = vista;
		this.modeloPartida = modeloPartida;
		
		Collections.shuffle(modeloPartida.verDestinos());
		Ciudad destino1 = this.modeloPartida.verDestinoNro(1);
		Ciudad destino2 = this.modeloPartida.verDestinoNro(2);
		Ciudad destino3 = this.modeloPartida.verDestinoNro(3);
		Ciudad destino4 = this.modeloPartida.verDestinoNro(4);
		Integer hsDestino1 = this.modeloPartida.hsViajeAOtraCiudad(destino1);
		Integer hsDestino2 = this.modeloPartida.hsViajeAOtraCiudad(destino2);
		Integer hsDestino3 = this.modeloPartida.hsViajeAOtraCiudad(destino3);
		Integer hsDestino4 = this.modeloPartida.hsViajeAOtraCiudad(destino4);
		
		this.panel = new ViajarVista(destino1.getNombre(), destino2.getNombre(), destino3.getNombre(),
				destino4.getNombre(), hsDestino1, hsDestino2, hsDestino3, hsDestino4);

		vista.getContentPane().removeAll();
		vista.add(panel);
		vista.getContentPane().validate();
		
		this.panel.addViajarListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String destinoString = ((JButton) e.getSource()).getText();
				viajar(destinoString);
			}
		});
		
		this.panel.addVolverAPanelPartida(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAPanelPartida();
			}
		});
		
	}
	
	public void viajar(String destinoString) {
		for (int i=0; i<4; i++) {
			Ciudad destino = modeloPartida.verDestinoNro(i+1);
			if ( destino.getNombre() == destinoString ) {
				modeloPartida.viajar(destino);
				break;
			}
		}
		
		if (!modeloPartida.quedaTiempo()) {
			JOptionPane.showMessageDialog(null, "Oops! Te quedaste sin tiempo!");
			new PerdedorControlador(this.vista);
		} else {
			volverAPanelPartida();
		}
		
	}
	
	public void volverAPanelPartida() {
		new PartidaControlador(modeloPartida, vista);
	}

}
