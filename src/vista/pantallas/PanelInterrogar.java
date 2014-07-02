package vista.pantallas;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

import vista.botonesGenericos.BotonVolver;
import vista.panelesGenericos.PanelConFondo;

public class PanelInterrogar extends PanelConFondo {

	private static final long serialVersionUID = 7605711877812338233L;
	private static final String IMGPATH = "images/";
	private JLabel lblPista = new JLabel();
	private JButton btnVolver = new BotonVolver();

	public PanelInterrogar(String pista) {
		super(IMGPATH + "interrogar.gif");
		setLayout(null);
		lblPista.setText("- " + pista);
		lblPista.setForeground(Color.black);
		lblPista.setBounds(50, 525, 800, 50);
		add(lblPista);
		btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnVolver.setBounds(350, 0, 100, 40);
		add(btnVolver);
		setVisible(true);
	}
	
	public void addVolverAPanelPartida(ActionListener l) {
		btnVolver.addActionListener(l);
	}
	
}