package carmen.vista;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;


public class PanelNuevaPartida extends JPanel {
	  private BufferedImage img;
	  static final String PATH = "images/";
	  
	  public PanelNuevaPartida(String filename) {
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
	  
	  public void mostrarAviso(/*Acá iría info del ladrón y del lugar de partida*/){
		  JLabel aviso = new JLabel("PAPAPAPAPA");
		  add(aviso);
	  }
	}