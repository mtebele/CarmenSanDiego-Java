package carmen.vista;

import javax.swing.JButton;
public class BotonSalirJuego extends JButton{
	private static int MAX_ALTURA = 100;
	private static int MAX_ANCHURA = 200;
	
	public BotonSalirJuego(){
		super("Salir del Juego");
		setSize(MAX_ALTURA,MAX_ANCHURA);
		setVisible(true);
	}
}
