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
import vista.botonesGenericos.BotonCargarJuego;
import vista.botonesGenericos.BotonEmitirOrdenArresto;
import vista.botonesGenericos.BotonNuevoJuego;
import vista.botonesGenericos.BotonSalirJuego;
import vista.botonesGenericos.BotonVolver;
import vista.panelesGenericos.PanelConFondo;
import modelo.ladron.perfil.Cabello;
import modelo.ladron.perfil.Hobby;
import modelo.ladron.perfil.Senia;
import modelo.ladron.perfil.Sexo;
import modelo.ladron.perfil.Vehiculo;

public class PanelInterrogar extends PanelConFondo {

	private static final long serialVersionUID = 7605711877812338233L;
	private static final String IMGPATH = "images/";
	private JLabel lblPista = new JLabel();
	private JButton btnVolver = new BotonVolver();

	public PanelInterrogar(String pista) {
		super(IMGPATH + "interrogar.gif");
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		lblPista.setText(pista);
		lblPista.setForeground(Color.black);
		lblPista.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblPista);
		btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(btnVolver);
		setVisible(true);
	}
}