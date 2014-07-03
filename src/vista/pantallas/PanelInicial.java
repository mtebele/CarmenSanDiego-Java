package vista.pantallas;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.botonesGenericos.BotonCargarJuego;
import vista.botonesGenericos.BotonNuevoJuego;
import vista.botonesGenericos.BotonSalirJuego;
import vista.panelesGenericos.PanelConFondo;

public class PanelInicial extends PanelConFondo {
	private static final long serialVersionUID = -4043817001005784022L;
	private static final String IMGPATH = "images/";
	static final String FONDO = IMGPATH + "fondo.png";
	private JButton btnNuevaPartida = new BotonNuevoJuego();
	private JButton btnSalirJuego = new BotonSalirJuego();
	private JButton btnCargarPartida = new BotonCargarJuego();

	public PanelInicial() {
		super(FONDO);
		setLayout(null);
		btnNuevaPartida.setBounds(150, 100, 150, 40);
		btnSalirJuego.setBounds(550, 100, 150, 40);
		btnCargarPartida.setBounds(350, 100, 150, 40);
		add(btnNuevaPartida);
		add(btnCargarPartida);
		add(btnSalirJuego);
	}

	public void addNuevaPartidaListener(ActionListener l) {
		btnNuevaPartida.addActionListener(l);
	}

	public void addSalirJuegoListener(ActionListener l) {
		btnSalirJuego.addActionListener(l);
	}

	public void addCargarPartidaListener(ActionListener l) {
		btnCargarPartida.addActionListener(l);
	}

	public void enableCargarPartida(boolean valor) {
		btnCargarPartida.setEnabled(valor);
	}

}
