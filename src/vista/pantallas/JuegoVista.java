package vista.pantallas;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vista.panelesGenericos.PanelCarga;

public class JuegoVista extends JFrame {
	private static final long serialVersionUID = -3021501308427221124L;
	private static int MAX_ALTURA = 800;
	private static int MAX_ANCHURA = 600;

	PanelCarga carga = new PanelCarga();
	PanelInicial pnlInicial = new PanelInicial();

	public JuegoVista() {
		super("Carmen SanDiego - 75.07 FIUBA");
		setSize(MAX_ALTURA, MAX_ANCHURA);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(pnlInicial);
		setLocationRelativeTo(null);
	}

	public void addNuevaPartidaListener(ActionListener l) {
		pnlInicial.addNuevaPartidaListener(l);
	}

	public void addSalirJuegoListener(ActionListener l) {
		pnlInicial.addSalirJuegoListener(l);
	}

	public void addCargarPartidaListener(ActionListener l) {
		pnlInicial.addCargarPartidaListener(l);
	}
	
	public void enableCargarPartida(boolean valor) {
		pnlInicial.enableCargarPartida(valor);
	}
}
