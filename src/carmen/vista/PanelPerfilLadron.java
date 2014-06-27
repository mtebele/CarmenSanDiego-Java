//TODAVIA NO LO ADAPTE, IGNOREN EL ARCHIVO
package carmen.vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class PanelPerfilLadron extends PanelConFondo {
	
	public PanelPerfilLadron(String filename){
		super(filename);
	}
	    
	public static void main(String[] args){
		JFrame frame = new JFrame("pepe");
		frame.setSize(500,500);
		PanelPerfilLadron panel = new PanelPerfilLadron("fichacarmen.png");
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	  }
}
