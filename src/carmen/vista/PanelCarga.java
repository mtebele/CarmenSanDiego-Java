package carmen.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class PanelCarga extends PanelConFondo {
	static final String FILENAME = "fondo.png";
	private JProgressBar barraCarga = new JProgressBar(0,100);
	
	public PanelCarga(){
		super(FILENAME);
		barraCarga.setValue(0);
	    barraCarga.setStringPainted(true);
	    barraCarga.setString("Cargando...");
	    add(barraCarga);
	    /*FALTAR�A ASOCIAR ESTO A LA CARGA DEL XML*/
	}
	
}