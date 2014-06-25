//TODAVIA NO LO ADAPTE, IGNOREN EL ARCHIVO
package carmen.vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class PanelPerfilLadron extends JPanel {
	
	private BufferedImage img;
	static final String PATH = "/images";
	public PanelPerfilLadron(String filename){
		// carga el fondo
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
	  
	  public void esconder(){
		  setVisible(false);
	  }
	  
	  public static void main(String[] args){
		  JFrame frame = new JFrame("pepe");
		  frame.setSize(500,500);
		  PanelPerfilLadron panel = new PanelPerfilLadron("fichacarmen.png");
		  frame.getContentPane().add(panel);
		  frame.setVisible(true);
	  }
}
