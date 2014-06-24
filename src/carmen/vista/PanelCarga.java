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

public class PanelCarga extends JPanel {
	private BufferedImage img;
	static final String PATH = "images/";
	static final String FILENAME = "fondo.png";
	private JProgressBar barraCarga = new JProgressBar(0,100);
	
	public PanelCarga(){
	    try {
	      img = ImageIO.read(new File(PATH + FILENAME));
	    } catch(IOException e) {
	      e.printStackTrace();
	    }
	    barraCarga.setValue(0);
	    barraCarga.setStringPainted(true);
	    barraCarga.setString("Cargando...");
	    add(barraCarga);
	    /*FALTARÍA ASOCIAR ESTO A LA CARGA DEL XML*/
	}
	
	@Override
	protected void paintComponent(Graphics g) {
	  super.paintComponent(g);
	  // pinta el panel con el fondo
	  g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
	
}