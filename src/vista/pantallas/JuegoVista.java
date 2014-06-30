package vista.pantallas;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import controlador.JuegoControlador;
import vista.panelesGenericos.PanelCarga;
import modelo.Juego;

public class JuegoVista extends JFrame implements Observer {
	private static final long serialVersionUID = -3021501308427221124L;
	private static int MAX_ALTURA = 800;
	private static int MAX_ANCHURA = 600;

	PanelCarga carga = new PanelCarga();
	PanelInicial pnlNuevaPartida = new PanelInicial();

	public JuegoVista() {
		super("Carmen SanDiego - 75.07 FIUBA");
		setSize(MAX_ALTURA, MAX_ANCHURA);
		setResizable(true);
		setVisible(true);
		getContentPane().add(pnlNuevaPartida);
	}

	public void addNuevaPartidaListener(ActionListener l) {
		pnlNuevaPartida.addNuevaPartidaListener(l);
	}

	public void addSalirJuegoListener(ActionListener l) {
		pnlNuevaPartida.addSalirJuegoListener(l);
	}

	public void addCargarPartidaListener(ActionListener l) {
		pnlNuevaPartida.addCargarPartidaListener(l);
	}

	@Override
	public void update(Observable o, Object arg) {

	}
}
