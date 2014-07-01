package vista.pantallas;

import javax.swing.*;

import vista.botonesGenericos.BotonVolver;
import vista.panelesGenericos.PanelConFondo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelNuevaPartida extends PanelConFondo {
	private static final long serialVersionUID = -8273049611334044944L;
	private static final String IMGPATH = "images/";
	static final String FONDO = IMGPATH + "newspaper.png";
	private JTextArea textoReporte = new JTextArea();
	private JButton btnContinuar = new JButton("Iniciar investigacion");
	private JButton btnVolver = new BotonVolver();

	public PanelNuevaPartida() {
		super(FONDO);
		setLayout(null);
		textoReporte.setOpaque(false);
		textoReporte.setEditable(false);
		textoReporte.setText
		("\nEn el dia de la fecha se ha reportado un robo de un objeto importante."
				+ "\nSe trata de <objetoRobado>."+
				"\nEl mismo se reporto en la ciudad de <nombreCiudad>."+
				"\nTiene una semana para resolver el caso.\n");
		add(textoReporte);
		textoReporte.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textoReporte.setBounds(200, 200, 500, 500);
		add(btnContinuar);
		btnContinuar.setBounds(175, 400, 200, 40);
		add(btnVolver);
		btnVolver.setBounds(425, 400, 200, 40);
		
	}

}