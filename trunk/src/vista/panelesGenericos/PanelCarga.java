package vista.panelesGenericos;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JFrame;

public class PanelCarga extends PanelConFondo {
	private static final String IMGPATH = "images/";
	static final String FILENAME = IMGPATH + "fondo.png";
	private JProgressBar barraCarga = new JProgressBar(0, 100);

	public PanelCarga() {
		super(FILENAME);
		// para superponer usar transparencia 0
		barraCarga.setValue(0);
		barraCarga.setStringPainted(true);
		barraCarga.setString("Cargando...");
		barraCarga.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(barraCarga);
		/* FALTARIA ASOCIAR ESTO A LA CARGA DEL XML */
	}

}