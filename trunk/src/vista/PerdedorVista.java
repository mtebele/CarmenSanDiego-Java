package vista;

import java.awt.Color;
import java.awt.event.ActionListener;

import vista.botonesGenericos.BotonMenuPrincipal;
import vista.botonesGenericos.BotonSalirJuego;

import javax.swing.JLabel;

import vista.panelesGenericos.PanelConFondo;

public class PerdedorVista extends PanelConFondo {

	private static final long serialVersionUID = -8392658315975218132L;
	private static final String IMGPATH = "images/";
	static final String FONDO = IMGPATH + "perdedor.png";
	private BotonMenuPrincipal botonSaltarInicio = new BotonMenuPrincipal();
	private BotonSalirJuego btnSalirJuego = new BotonSalirJuego();
	private JLabel mensajePerdiste = new JLabel("¡NO HAS PODIDO ATRAPAR AL LADRON!");
	private JLabel lblCarita = new JLabel(":(");

	public PerdedorVista() {
		super(FONDO);
		setLayout(null);
		add(botonSaltarInicio);
		botonSaltarInicio.setBounds(200, 500, 150, 40);
		add(btnSalirJuego);
		btnSalirJuego.setBounds(400, 500, 150, 40);
		mensajePerdiste.setBounds(120, 50, 600, 50);
		mensajePerdiste.setFont(new java.awt.Font("Tahoma", 0, 30));
		mensajePerdiste.setForeground(Color.orange);
		add(mensajePerdiste);
		lblCarita.setBounds(350, 80, 200, 150);
		lblCarita.setFont(new java.awt.Font("Tahoma", 0, 50));
		lblCarita.setForeground(Color.white);
		add(lblCarita);
		setVisible(true);
	}

	public void addVolverAPanelInicialListener(ActionListener l) {
		botonSaltarInicio.addActionListener(l);
	}

	public void addSalirJuegoListener(ActionListener l) {
		btnSalirJuego.addActionListener(l);
	}

}