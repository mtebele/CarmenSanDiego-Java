package vista;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import vista.paneles.PanelCarga;
import vista.paneles.PanelesAdministrador;
import vista.pantallaInicial.PanelInicial;
import modelo.Juego;

public class JuegoVista extends JFrame implements Observer {
	private static final long serialVersionUID = -3021501308427221124L;
	private static int MAX_ALTURA = 800;
	private static int MAX_ANCHURA = 600;
	
	PanelCarga carga = new PanelCarga();
	PanelInicial pnlNuevaPartida = new PanelInicial();

	public JuegoVista() {
		super("Carmen SanDiego - 75.07 FIUBA");
		final PanelesAdministrador admin = new PanelesAdministrador(this);
		setSize(MAX_ALTURA, MAX_ANCHURA);
		setResizable(true);
		setVisible(true);
		getContentPane().add(pnlNuevaPartida);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}
}
