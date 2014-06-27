package carmen.vista;

import javax.swing.*;

import carmen.vista.pantallaOrdenArresto.PanelOrdenArresto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelNuevaPartida extends PanelConFondo {
	  static final String FONDO = "newspaper.png";
	  private JLabel introduccion = new JLabel();
	  private JLabel objetoRobado = new JLabel();
	  private JLabel ubicacion = new JLabel();
	  private JLabel deadline = new JLabel();
	  private JButton btnContinuar = new JButton("Iniciar investigacion");
	  private JButton btnVolver = new BotonVolver();
	  
	  public PanelNuevaPartida() {
		  super(FONDO);
		  setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
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
		  add(btnVolver);
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