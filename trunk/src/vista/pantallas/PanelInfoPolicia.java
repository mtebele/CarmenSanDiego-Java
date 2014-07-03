package vista.pantallas;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

import vista.LabelImagen;
import vista.botonesGenericos.BotonVolver;
import vista.panelesGenericos.PanelConFondo;

public class PanelInfoPolicia extends PanelConFondo {
	private static int POS_X = 200;
	private static int POS_Y = 120;
	private static int POS_X_BOTON = 300;
	private static int POS_Y_BOTON = 500;
	private static int TAM_FOTO = 100;
	private static int TAMLETRAS = 140;
	private static int BOT_ANCHURA = 200;
	private static int BOT_ALTURA = 40;
	private static final long serialVersionUID = -8273049611334044944L;
	private static final String IMGPATH = "images/";
	static final String FONDO = IMGPATH + "policia.png";
	static final String FOTOPOLICIA = IMGPATH + "fotopolicia.png";

	private JLabel lblNombre = new JLabel();
	private JLabel lblRango = new JLabel();
	private JLabel lblCantidadArrestos = new JLabel();
	private JButton btnVolver = new BotonVolver();
	private LabelImagen fotopolicia = new LabelImagen(FOTOPOLICIA);

	public PanelInfoPolicia(String nombre, String rango, int cantArrestos) {
		super(FONDO);
		setLayout(null);
		lblNombre.setBounds(POS_X, 40, TAMLETRAS, TAMLETRAS);
		lblNombre.setText("NOMBRE: " + nombre);
		lblNombre.setForeground(Color.black);
		lblRango.setBounds(POS_X, 80, TAMLETRAS, TAMLETRAS);
		lblRango.setText("RANGO: " + rango);
		lblRango.setForeground(Color.black);
		lblCantidadArrestos.setBounds(POS_X, POS_Y, TAMLETRAS, TAMLETRAS);
		lblCantidadArrestos.setForeground(Color.black);
		lblCantidadArrestos.setText("ARRESTOS: " + cantArrestos);
		btnVolver.setBounds(POS_X_BOTON, POS_Y_BOTON, BOT_ANCHURA, BOT_ALTURA);
		fotopolicia.setBounds(465, 60, TAM_FOTO + 25, TAM_FOTO);
		add(lblCantidadArrestos);
		add(btnVolver);
		add(lblRango);
		add(lblNombre);
		add(fotopolicia);
		setVisible(true);
	}

	public void addVolverAPanelPartida(ActionListener l) {
		btnVolver.addActionListener(l);
	}
}