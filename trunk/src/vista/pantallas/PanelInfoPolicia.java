package vista.pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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

public class PanelInfoPolicia extends PanelConFondo{
	private static int POS_X=500;
	private static int POS_Y=80;
	private static int POS_BOTON=500;
	private static int TAMLETRAS = 80;
	private static int BOT_ANCHURA = 250;
	private static int BOT_ALTURA = 50;
	private static final long serialVersionUID = -8273049611334044944L;
	private static final String IMGPATH = "images/";
	static final String FONDO = IMGPATH + "policia.png";
	private JLabel rango = new JLabel();

	private JLabel cantarrestos = new JLabel(); //estas label hay que rellenarlas con la info que le pedimos al controller
	private JButton btnVolver = new BotonVolver();
	
	
	public PanelInfoPolicia() {
		super(FONDO);
		setLayout(null);
		rango.setBounds(POS_X,0,TAMLETRAS,TAMLETRAS);
		rango.setText("RANGO");
		rango.setForeground(Color.black);
		cantarrestos.setBounds(POS_X,POS_Y,TAMLETRAS,TAMLETRAS);
		cantarrestos.setForeground(Color.black);
		cantarrestos.setText("ARRESTOS");
		btnVolver.setBounds(POS_BOTON,POS_BOTON,BOT_ANCHURA,BOT_ALTURA);
		add (cantarrestos);
		add (btnVolver);
		add (rango);
		setVisible(true);
		
	}	
		
		

}