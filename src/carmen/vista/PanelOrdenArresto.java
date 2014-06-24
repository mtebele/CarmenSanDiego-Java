package carmen.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import carmen.modelo.perfil.Cabello;
import carmen.modelo.perfil.Hobby;
import carmen.modelo.perfil.Senia;
import carmen.modelo.perfil.Sexo;
import carmen.modelo.perfil.Vehiculo;

public class PanelOrdenArresto extends JPanel{
	
	private BufferedImage img;
	static final String PATH = "images/";

	private String[] opcionesCabello = {
		"Seleccione color de cabello",
		Cabello.CASTANIO.toString(),
		Cabello.NEGRO.toString(),
		Cabello.ROJO.toString(),
		Cabello.RUBIO.toString()
	};
	
	private String[] opcionesHobby = {
			"Seleccione hobby",
			Hobby.ALPINISMO.toString(),
			Hobby.MUSICA.toString(),
			Hobby.NATACION.toString(),
			Hobby.PARACAIDISMO.toString(),
			Hobby.TENIS.toString()
		};
	
	private String[] opcionesSenia = {
			"Seleccione Seña",
			Senia.ANILLO.toString(),
			Senia.CICATRIZ.toString(),
			Senia.JOYAS.toString(),
			Senia.TATUAJE.toString()
		};
	
	private String[] opcionesSexo = {
			"Seleccione sexo",
			Sexo.MASCULINO.toString(),
			Sexo.FEMENINO.toString(),
			};
	
	private String[] opcionesVehiculo = {
		"Seleccione vehiculo",
		Vehiculo.DEPORTIVO.toString(),
		Vehiculo.DESCAPOTABLE.toString(),
		Vehiculo.LIMUSINA.toString(),
		Vehiculo.MOTO.toString()
	};
	
	private JComboBox<String> cajaCabello = new JComboBox<String>(opcionesCabello); 
	private JComboBox<String> cajaHobby = new JComboBox<String>(opcionesHobby);
	private JComboBox<String> cajaSenia = new JComboBox<String>(opcionesSenia);
	private JComboBox<String> cajaSexo = new JComboBox<String>(opcionesSexo);
	private JComboBox<String> cajaVehiculo = new JComboBox<String>(opcionesVehiculo);
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// pinta el panel con el fondo
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
	
	public PanelOrdenArresto(String filename) {
		// carga el fondo
		try {
			img = ImageIO.read(new File(PATH + filename));
	    } catch(IOException e) {
	    	e.printStackTrace();
	    }
		
		add(cajaCabello);
		add(cajaHobby);
		add(cajaSenia);
		add(cajaSexo);
		add(cajaVehiculo);
	}
	
}
