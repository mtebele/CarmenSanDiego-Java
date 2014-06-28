package vista.pantallaInicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.paneles.PanelConFondo;
import vista.paneles.PanelNuevaPartida;

public class PanelInicial extends PanelConFondo {
	private static final long serialVersionUID = -4043817001005784022L;
	private static final String IMGPATH = "images/";
	static final String FONDO = IMGPATH + "fondo.png";
	private JButton btnNuevaPartida = new BotonNuevoJuego();
	private JButton btnSalirJuego = new BotonSalirJuego();

	public PanelInicial() {
		super(FONDO);
		add(btnNuevaPartida);
		add(btnSalirJuego);
	}
	
	public void addNuevaPartidaListener(ActionListener l) {
		btnNuevaPartida.addActionListener(l);
	}
	
	public void addSalirJuegoListener(ActionListener l) {
		btnSalirJuego.addActionListener(l);
	}
}
