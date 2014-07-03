package vista;

import vista.botonesGenericos.BotonMenuPrincipal;
import vista.botonesGenericos.BotonSalirJuego;
import vista.panelesGenericos.PanelConFondo;

import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

public class GanadorVista extends PanelConFondo {
	
	private static final long serialVersionUID = 1L;
	private static final String IMGPATH = "images/";
	static final String FONDO = IMGPATH + "ganador.png";
	private BotonMenuPrincipal botonSaltarInicio = new BotonMenuPrincipal();
	private BotonSalirJuego btnSalirJuego = new BotonSalirJuego();
	private JLabel mensajeGanaste = new JLabel("FELICITACIONES, HAS RESUELTO EL CASO");

	public GanadorVista() {
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
		setVisible(true);
	}

	public void addVolverAPanelInicialListener(ActionListener l) {
		botonSaltarInicio.addActionListener(l);
	}

	public void addSalirJuegoListener(ActionListener l) {
		btnSalirJuego.addActionListener(l);
	}
	
}