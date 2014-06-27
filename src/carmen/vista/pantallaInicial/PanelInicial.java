package carmen.vista.pantallaInicial;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import carmen.vista.PanelConFondo;

public class PanelInicial extends PanelConFondo{
	static final String FONDO = "fondo.png";
	private JButton btnNuevaPartida = new BotonNuevoJuego();
	private JButton btnSalirJuego = new BotonSalirJuego();
	
	public PanelInicial() {
		super(FONDO);
		add(btnNuevaPartida);
		add(btnSalirJuego);
	}
}
