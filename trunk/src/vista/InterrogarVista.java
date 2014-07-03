package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

import vista.botonesGenericos.BotonVolver;
import vista.panelesGenericos.PanelConFondo;

public class InterrogarVista extends PanelConFondo {

	private static final long serialVersionUID = 7605711877812338233L;
	private static final String IMGPATH = "images/";
	private JLabel lblPista = new JLabel();
	private JButton btnVolver = new BotonVolver();

	public InterrogarVista(String pista) {
		super(IMGPATH + "interrogar.png");
		setLayout(null);
		lblPista.setText("- " + pista);
		lblPista.setForeground(Color.black);
		lblPista.setBounds(100, 200, 700, 50);
		lblPista.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		add(lblPista);
		btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnVolver.setBounds(350, 500, 100, 40);
		btnVolver.setFont(new Font("Trebuchet MS", Font.HANGING_BASELINE, 20));
		add(btnVolver);
		setVisible(true);
	}

	public void addVolverAPanelPartida(ActionListener l) {
		btnVolver.addActionListener(l);
	}

}