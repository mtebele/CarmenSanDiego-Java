package vista.panelesGenericos;

import java.awt.Component;

import javax.swing.JProgressBar;

public class PanelCarga extends PanelConFondo {

	private static final long serialVersionUID = -8776139102596492798L;
	private static final String IMGPATH = "images/";
	static final String FILENAME = IMGPATH + "fondo.png";
	private JProgressBar barraCarga = new JProgressBar(0, 100);

	public PanelCarga() {
		super(FILENAME);
		// Para superponer usar transparencia 0
		barraCarga.setValue(0);
		barraCarga.setStringPainted(true);
		barraCarga.setString("Cargando...");
		barraCarga.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(barraCarga);
		/* FALTARIA ASOCIAR ESTO A LA CARGA DEL XML */
	}

}