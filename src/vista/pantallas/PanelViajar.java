package vista.pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
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
	
	
	private static final String IMGPATH = "images/";
	static final String FONDO = IMGPATH + "viajar.png";
	static final String MAPA = IMGPATH + "mapa.jpg";
	static final int TAMLETRA=21;
	static final int ANCHO= 80;
	static final int ALTO=125;
	static final int YDESTINO=450;
	static final int XDESTINO1=50;
	static final int XDESTINO2=250;
	static final int XDESTINO3=450;
	static final int XDESTINO4=650;
	static final int ANCHO_VIAJAR=250;
	static final int ALTO_VIAJAR=50;
	static final int XVIAJAR=300;
	static final int YVIAJAR=0;
	static final int XBOTON=700;
	static final int YBOTON=0;
	static final int ANCHO_VOLVER=150;
	static final int ALTO_VOLVER=50;
	static final int XVOLVER=350;
	static final int YVOLVER=375;
	static final int XMAPA=100;
	static final int YMAPA=50;
	static final int ANCHO_MAPA=600;
	static final int ALTO_MAPA=300;
	
	private JLabel lblViajarA = new JLabel("¿Adonde quiere viajar?");
	private JButton btnDestino1 = new JButton("<destino1>");
	private JButton btnDestino2 = new JButton("<destino2>");
	private JButton btnDestino3 = new JButton("<destino3>");
	private JButton btnDestino4 = new JButton("<destino4>");
	private BotonVolver btnVolver = new BotonVolver();
	private LabelImagen mapa = new LabelImagen(MAPA);
	
	
	public PanelViajar(){
		super(FONDO);
		setLayout(null);
		lblViajarA.setBounds(XVIAJAR,YVIAJAR,ANCHO_VIAJAR,ALTO_VIAJAR);
		lblViajarA.setForeground(Color.white);
		lblViajarA.setBackground(Color.black);
		lblViajarA.setOpaque(true);
		lblViajarA.setFont(new java.awt.Font("Tahoma", 0, TAMLETRA)); 
		btnDestino1.setBounds(XDESTINO1,YDESTINO,ALTO,ANCHO);
		btnDestino2.setBounds(XDESTINO2,YDESTINO,ALTO,ANCHO);
		btnDestino3.setBounds(XDESTINO3,YDESTINO,ALTO,ANCHO);
		btnDestino4.setBounds(XDESTINO4,YDESTINO,ALTO,ANCHO);
		btnVolver.setBounds(XVOLVER,YVOLVER,ANCHO_VOLVER,ALTO_VOLVER);
		mapa.setBounds(XMAPA,YMAPA,ANCHO_MAPA,ALTO_MAPA);
		add(lblViajarA);
		add(btnDestino1);
		add(btnDestino2);
		add(btnDestino3);
		add(btnDestino4);
		add(btnVolver);
		add(mapa);
	}
}