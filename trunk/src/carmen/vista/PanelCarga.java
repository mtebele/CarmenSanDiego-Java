package carmen.vista;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JFrame;

public class PanelCarga extends PanelConFondo {
	static final String FILENAME = "fondo.png";
	private JProgressBar barraCarga = new JProgressBar(0,100);
	
	public PanelCarga(){
		super(FILENAME);
		//para superponer usar transparencia 0
		barraCarga.setValue(0);
	    barraCarga.setStringPainted(true);
	    barraCarga.setString("Cargando...");
	    barraCarga.setAlignmentX(Component.CENTER_ALIGNMENT);
	    add(barraCarga);
	    /*FALTAR�A ASOCIAR ESTO A LA CARGA DEL XML*/
	}
	
}