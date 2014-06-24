package carmen.vista;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;


public class PanelNuevaPartida extends JPanel {
	  private BufferedImage img;
	  static final String PATH = "images/";
	  private JLabel introduccion = new JLabel();
	  private JLabel objetoRobado = new JLabel();
	  private JLabel ubicacion = new JLabel();
	  private JLabel deadline = new JLabel();
	  private JButton btnContinuar = new JButton("Iniciar investigacion");
	  
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
	  
	  public void mostrarAviso(/*Ac� ir�a info del ladr�n y del lugar de partida*/){
		  introduccion.setText("\nEn el dia de la fecha se ha reportado un robo de un objeto importante.\n");
		  introduccion.setForeground(Color.black);
		  introduccion.setHorizontalAlignment(JLabel.CENTER);
		  add(introduccion);
		  objetoRobado.setText("\nSe trata de <objetoRobado>.\n");
		  objetoRobado.setForeground(Color.black);
		  objetoRobado.setHorizontalAlignment(JLabel.CENTER);
		  add(objetoRobado);
		  ubicacion.setText("\nLas mismas se robaron de la ciudad de <nombreCiudad>.\n");
		  ubicacion.setForeground(Color.black);
		  add(ubicacion);
		  deadline.setText("\nTiene una semana para resolver el caso.\n");
		  deadline.setForeground(Color.black);
		  add(deadline);
		  add(btnContinuar);
		  btnContinuar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JFrame pepe = new JFrame();
					pepe.setSize(400,400);
					pepe.setVisible(true);
					pepe.add(new PanelOrdenArresto("ordenarresto.jpg"));
				}
			});

	  }
	  
	}