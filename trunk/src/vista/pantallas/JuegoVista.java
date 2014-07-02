package vista.pantallas;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import vista.panelesGenericos.PanelCarga;

public class JuegoVista extends JFrame implements Observer {
	private static final long serialVersionUID = -3021501308427221124L;
	private static int MAX_ALTURA = 800;
	private static int MAX_ANCHURA = 600;

	PanelCarga carga = new PanelCarga();
	PanelInicial pnlInicial = new PanelInicial();

    //PanelOrdenOK pnlInicial = new PanelOrdenOK();//DESCOMENTAR EL DE ARRIBA EN LA VERSION FINAL. SE USA
	// PARA PROBAR PANELES ESTO

	public JuegoVista() {
		super("Carmen SanDiego - 75.07 FIUBA");
		setSize(MAX_ALTURA, MAX_ANCHURA);
		setResizable(false);
		setVisible(true);
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

	@Override
	public void update(Observable o, Object arg) {

	}
}
