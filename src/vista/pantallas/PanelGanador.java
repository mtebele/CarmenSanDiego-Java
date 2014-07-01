package vista.pantallas;
import vista.botonesGenericos.BotonMenuPrincipal;
import vista.botonesGenericos.BotonSalirJuego;

import javax.swing.JFrame;
import javax.swing.JButton;

import vista.panelesGenericos.PanelConFondo;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class PanelGanador extends PanelConFondo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String IMGPATH = "images/";
	static final String FONDO = IMGPATH + "ganador.png";
	private BotonMenuPrincipal botonSaltarInicio = new BotonMenuPrincipal();
	private BotonSalirJuego btnSalirJuego = new BotonSalirJuego();
	private JLabel mensajeGanaste = new JLabel("FELICITACIONES, HAS RESUELTO EL CASO");
	
	public PanelGanador(){
		super(FONDO);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, botonSaltarInicio, -60, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, botonSaltarInicio, -450, SpringLayout.EAST, this);
		setLayout(springLayout);
		this.add(botonSaltarInicio);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSalirJuego, -60, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnSalirJuego, -250, SpringLayout.EAST, this);
		this.add(btnSalirJuego);
		springLayout.putConstraint(SpringLayout.SOUTH, mensajeGanaste, -400, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, mensajeGanaste, -100, SpringLayout.EAST, this);
		mensajeGanaste.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		mensajeGanaste.setForeground(Color.WHITE);
		this.add(mensajeGanaste);
	}
	
}