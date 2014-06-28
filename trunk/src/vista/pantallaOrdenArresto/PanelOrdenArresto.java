package vista.pantallaOrdenArresto;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JButton;

import vista.BotonVolver;
import vista.paneles.PanelConFondo;
import modelo.ladron.perfil.Cabello;
import modelo.ladron.perfil.Hobby;
import modelo.ladron.perfil.Senia;
import modelo.ladron.perfil.Sexo;
import modelo.ladron.perfil.Vehiculo;

public class PanelOrdenArresto extends PanelConFondo{

	static final String fondo = "ordenarresto.jpg";
	
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
	private AreaSospechosos areaSospechosos = new AreaSospechosos();
	private BotonEmitirOrdenArresto btnOrden = new BotonEmitirOrdenArresto();
	private BotonVolver btnVolver = new BotonVolver();
	
	public PanelOrdenArresto(String filename) {
		super(fondo);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(cajaCabello);
		add(cajaHobby);
		add(cajaSenia);
		add(cajaSexo);
		add(cajaVehiculo);
		add(btnOrden);
		add(areaSospechosos);
		add(btnVolver);
	}
	
}
