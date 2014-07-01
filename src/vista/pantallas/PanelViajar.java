package vista.pantallas;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import vista.AreaSospechosos;
import vista.LabelImagen;
import vista.botonesGenericos.BotonEmitirOrdenArresto;
import vista.botonesGenericos.BotonVolver;
import vista.panelesGenericos.PanelConFondo;
import modelo.ladron.perfil.Cabello;
import modelo.ladron.perfil.Hobby;
import modelo.ladron.perfil.Senia;
import modelo.ladron.perfil.Sexo;
import modelo.ladron.perfil.Vehiculo;

public class PanelViajar extends PanelConFondo{
	
	private static final String FONDO = "viaje.png";
	private LabelImagen mapa = new LabelImagen("mapamundi.png");
	private JLabel lblViajarA = new JLabel("Viajar a:");
	private JButton btnDestino1 = new JButton("<destino1>");
	private JButton btnDestino2 = new JButton("<destino2>");
	private JButton btnDestino3 = new JButton("<destino3>");
	private JButton btnDestino4 = new JButton("<destino4>");
	private BotonVolver btnVolver = new BotonVolver();
	
	public PanelViajar(){
		super(FONDO);
		add(mapa);
		add(lblViajarA);
		add(btnDestino1);
		add(btnDestino2);
		add(btnDestino3);
		add(btnDestino4);
		add(btnVolver);
	}
}