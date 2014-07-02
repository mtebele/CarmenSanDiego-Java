package controlador;

import vista.pantallas.JuegoVista;
import vista.pantallas.PanelNuevaPartida;
import vista.pantallas.PanelViajar;
import modelo.Partida;
import modelo.mapa.Ciudad;

public class ViajeControlador {

	private JuegoVista vista;
	private PanelViajar panel;
	private Partida modeloPartida;

	public ViajeControlador(Partida modeloPartida, JuegoVista vista) {
		
		this.vista = vista;
		this.modeloPartida = modeloPartida;
		
		Ciudad destino1 = this.modeloPartida.verDestinoNro(1);
		Ciudad destino2 = this.modeloPartida.verDestinoNro(2);
		Ciudad destino3 = this.modeloPartida.verDestinoNro(3);
		Ciudad destino4 = this.modeloPartida.verDestinoNro(4);
		this.panel = new PanelViajar(destino1.getNombre(), destino2.getNombre(), destino3.getNombre(),
				destino4.getNombre());

		vista.getContentPane().removeAll();
		vista.add(panel);
		vista.getContentPane().validate();
	}

}
