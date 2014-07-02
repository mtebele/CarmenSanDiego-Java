package vista.pantallas;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;

import vista.botonesGenericos.BotonVolver;
import vista.panelesGenericos.PanelConFondo;

public class PanelInfoPolicia extends PanelConFondo {
	private static int POS_X = 500;
	private static int POS_Y = 80;
	private static int POS_BOTON = 500;
	private static int TAMLETRAS = 140;
	private static int BOT_ANCHURA = 250;
	private static int BOT_ALTURA = 50;
	private static final long serialVersionUID = -8273049611334044944L;
	private static final String IMGPATH = "images/";
	static final String FONDO = IMGPATH + "policia.png";

	private JLabel lblNombre = new JLabel();
	private JLabel lblRango = new JLabel();
	private JLabel lblCantidadArrestos = new JLabel();
	private JButton btnVolver = new BotonVolver();

	public PanelInfoPolicia(String nombre, String rango, int cantArrestos) {
		super(FONDO);
		setLayout(null);
		lblNombre.setBounds(POS_X, 0, TAMLETRAS, TAMLETRAS);
		lblNombre.setText("NOMBRE: " + nombre);
		lblNombre.setForeground(Color.black);
		lblRango.setBounds(POS_X, 40, TAMLETRAS, TAMLETRAS);
		lblRango.setText("RANGO: " + rango);
		lblRango.setForeground(Color.black);
		lblCantidadArrestos.setBounds(POS_X, POS_Y, TAMLETRAS, TAMLETRAS);
		lblCantidadArrestos.setForeground(Color.black);
		lblCantidadArrestos.setText("ARRESTOS: " + cantArrestos);
		btnVolver.setBounds(POS_BOTON, POS_BOTON, BOT_ANCHURA, BOT_ALTURA);
		add(lblCantidadArrestos);
		add(btnVolver);
		add(lblRango);
		add(lblNombre);
		setVisible(true);

	}

}