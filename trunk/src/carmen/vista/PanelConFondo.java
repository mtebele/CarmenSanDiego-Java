package carmen.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelConFondo extends JPanel {
	private BufferedImage img;
	static final String PATH = "images/";
	
	public PanelConFondo(String filename){
	    try {
	      img = ImageIO.read(new File(PATH + filename));
	    } catch(IOException e) {
	      e.printStackTrace();
	    }
	}
	
	@Override
	protected void paintComponent(Graphics g) {
	  super.paintComponent(g);
	  // pinta el panel con el fondo
	  g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
	
}