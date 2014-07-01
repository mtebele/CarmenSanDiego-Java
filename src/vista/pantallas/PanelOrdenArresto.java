package vista.pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JButton;

import vista.AreaSospechosos;
import vista.botonesGenericos.BotonEmitirOrdenArresto;
import vista.botonesGenericos.BotonVolver;
import vista.panelesGenericos.PanelConFondo;
import modelo.ladron.Ladron;
import modelo.ladron.perfil.Cabello;
import modelo.ladron.perfil.Hobby;
import modelo.ladron.perfil.Senia;
import modelo.ladron.perfil.Sexo;
import modelo.ladron.perfil.Vehiculo;

public class PanelOrdenArresto extends PanelConFondo{

	private static final String IMGPATH = "images/";
	static final String FONDO = IMGPATH + "ordenarresto.jpg";
	
	private BotonVolver btnVolver = new BotonVolver();
	private BotonEmitirOrdenArresto btnArresto = new BotonEmitirOrdenArresto();
 
	private String[] ladrones = {
            "Seleccione un ladron",
            "Nick Brunch",
            "Len Bulk",
            "Ihor Ihorovitch",
            "Fast Eddie B.",
            "Scar Graynolt",
            "Merey Laroc",
            "Lady Agatha",
            "Katherine Drib",
            "Dazzle Annie",
            "Carmen Sandiego"
    };
    
    private JComboBox<String> cmbLadrones = new JComboBox<String>(ladrones); 
	
	public PanelOrdenArresto() {
		super(FONDO);
		add(cmbLadrones);
		add(btnArresto);
		add(btnVolver);
	}
	
	
}
