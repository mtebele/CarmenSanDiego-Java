package vista.botonesGenericos;

import javax.swing.JButton;

public class BotonCargarJuego extends JButton {
	private static final long serialVersionUID = 7059196133846252509L;
	private static int MAX_ALTURA = 100;
	private static int MAX_ANCHURA = 200;

	public BotonCargarJuego() {
		super("Cargar Juego");
		setSize(MAX_ALTURA, MAX_ANCHURA);
		setVisible(true);
	}
}
