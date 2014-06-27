package carmen.vista.pantallaInicial;

import javax.swing.JButton;

public class BotonNuevoJuego extends JButton{
	private static int MAX_ALTURA = 100;
	private static int MAX_ANCHURA = 200;
	
	public BotonNuevoJuego(){
		super("Nuevo Juego");
		setSize(MAX_ALTURA,MAX_ANCHURA);
		setVisible(true);
	}
}
