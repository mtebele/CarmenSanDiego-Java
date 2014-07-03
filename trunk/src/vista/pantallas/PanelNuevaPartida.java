package vista.pantallas;

import javax.swing.*;

import vista.botonesGenericos.BotonVolver;
import vista.panelesGenericos.PanelConFondo;

import java.awt.Font;
import java.awt.event.ActionListener;

public class PanelNuevaPartida extends PanelConFondo {
	private static final long serialVersionUID = -8273049611334044944L;
	private static final String IMGPATH = "images/";
	static final String FONDO = IMGPATH + "newspaper.png";
	private JTextArea textoReporte = new JTextArea();
	private JButton btnContinuar = new JButton("Investigar");
	private JButton btnVolver = new BotonVolver();

	public PanelNuevaPartida(String ciudadActual, String sexoLadron) {
		super(FONDO);
		setLayout(null);
		textoReporte.setOpaque(false);
		textoReporte.setEditable(false);
		textoReporte.setText("\nEn el día de la fecha se ha reportado un robo de un objeto importante."
				+ "\nEl mismo se reportó en la ciudad de " + ciudadActual + "."
				+ "\nUn sospechoso de sexo " + sexoLadron + " fue visto en la escena del crimen."
				+ "\nTiene una semana para resolver el caso.\n");
		add(textoReporte);
		textoReporte.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textoReporte.setBounds(200, 200, 500, 200);
		add(btnContinuar);
		btnContinuar.setBounds(340, 380, 150, 40);
		add(btnVolver);
		btnVolver.setBounds(530, 380, 150, 40);
	}

	public void addAbrirPanelPartidaListener(ActionListener l) {
		btnContinuar.addActionListener(l);
	}

	public void addVolverAPanelInicialListener(ActionListener l) {
		btnVolver.addActionListener(l);
	}

}