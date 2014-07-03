package vista.pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import vista.LabelImagen;
import vista.botonesGenericos.BotonDestinoViajar;
import vista.botonesGenericos.BotonVolver;
import vista.panelesGenericos.PanelConFondo;

public class PanelViajar extends PanelConFondo {

	private static final long serialVersionUID = 5319443758271459237L;
	private static final String IMGPATH = "images/";
	static final String FONDO = IMGPATH + "viajar.png";
	static final String MAPA = IMGPATH + "mapa.jpg";
	static final int TAMLETRA = 22;
	static final int ALTO = 50;
	static final int ANCHO = 150;
	static final int YDESTINO = 400;
	static final int XDESTINO1 = 20;
	static final int XDESTINO2 = 220;
	static final int XDESTINO3 = 420;
	static final int XDESTINO4 = 620;
	static final int ANCHO_VIAJAR = 250;
	static final int ALTO_VIAJAR = 50;
	static final int XVIAJAR = 290;
	static final int YVIAJAR = 0;
	static final int XBOTON = 700;
	static final int YBOTON = 0;
	static final int ANCHO_VOLVER = 150;
	static final int ALTO_VOLVER = 40;
	static final int XVOLVER = 320;
	static final int YVOLVER = 500;
	static final int XMAPA = 100;
	static final int YMAPA = 60;
	static final int ANCHO_MAPA = 600;
	static final int ALTO_MAPA = 300;

	private JLabel lblViajarA = new JLabel("¿A dónde desea viajar?");

	private BotonVolver btnVolver = new BotonVolver();
	private LabelImagen mapa = new LabelImagen(MAPA);
	private BotonDestinoViajar btnDestino1;
	private BotonDestinoViajar btnDestino2;
	private BotonDestinoViajar btnDestino3;
	private BotonDestinoViajar btnDestino4;
	private JLabel lblhsDestino1;
	private JLabel lblhsDestino2;
	private JLabel lblhsDestino3;
	private JLabel lblhsDestino4;

	public PanelViajar(String destino1, String destino2, String destino3, String destino4, Integer hsDestino1,
			Integer hsDestino2, Integer hsDestino3, Integer hsDestino4) {
		super(FONDO);
		Font fuenteDestinos = new Font("Trebuchet.MS", Font.BOLD, 14);
		btnDestino1 = new BotonDestinoViajar(destino1);
		btnDestino2 = new BotonDestinoViajar(destino2);
		btnDestino3 = new BotonDestinoViajar(destino3);
		btnDestino4 = new BotonDestinoViajar(destino4);
		lblhsDestino1 = new JLabel(hsDestino1.toString() + " HS");
		lblhsDestino2 = new JLabel(hsDestino2.toString() + " HS");
		lblhsDestino3 = new JLabel(hsDestino3.toString() + " HS");
		lblhsDestino4 = new JLabel(hsDestino4.toString() + " HS");

		setLayout(null);
		lblViajarA.setBounds(XVIAJAR, YVIAJAR, ANCHO_VIAJAR, ALTO_VIAJAR);
		lblViajarA.setForeground(Color.white);
		lblViajarA.setBackground(Color.black);
		lblViajarA.setOpaque(true);
		lblViajarA.setFont(new java.awt.Font("Tahoma", 0, TAMLETRA));
		btnDestino1.setBounds(XDESTINO1, YDESTINO, ANCHO, ALTO);
		btnDestino2.setBounds(XDESTINO2, YDESTINO, ANCHO, ALTO);
		btnDestino3.setBounds(XDESTINO3, YDESTINO, ANCHO, ALTO);
		btnDestino4.setBounds(XDESTINO4, YDESTINO, ANCHO, ALTO);
		lblhsDestino1.setBounds(XDESTINO1 + 60, YDESTINO + 40, ANCHO, ALTO);
		lblhsDestino1.setFont(new java.awt.Font("Tahoma", 0, 14));
		lblhsDestino1.setForeground(Color.white);
		lblhsDestino1.setBackground(Color.black);
		lblhsDestino2.setBounds(XDESTINO2 + 60, YDESTINO + 40, ANCHO, ALTO);
		lblhsDestino2.setFont(new java.awt.Font("Tahoma", 0, 14));
		lblhsDestino2.setForeground(Color.white);
		lblhsDestino2.setBackground(Color.black);
		lblhsDestino3.setBounds(XDESTINO3 + 60, YDESTINO + 40, ANCHO, ALTO);
		lblhsDestino3.setFont(new java.awt.Font("Tahoma", 0, 14));
		lblhsDestino3.setForeground(Color.white);
		lblhsDestino3.setBackground(Color.black);
		lblhsDestino4.setBounds(XDESTINO4 + 60, YDESTINO + 40, ANCHO, ALTO);
		lblhsDestino4.setFont(new java.awt.Font("Tahoma", 0, 14));
		lblhsDestino4.setForeground(Color.white);
		lblhsDestino4.setBackground(Color.black);
		btnDestino1.setText(destino1);
		btnDestino1.setFont(fuenteDestinos);
		btnDestino2.setText(destino2);
		btnDestino2.setFont(fuenteDestinos);
		btnDestino3.setText(destino3);
		btnDestino3.setFont(fuenteDestinos);
		btnDestino4.setText(destino4);
		btnDestino4.setFont(fuenteDestinos);
		btnVolver.setBounds(XVOLVER, YVOLVER, ANCHO_VOLVER, ALTO_VOLVER);
		mapa.setBounds(XMAPA, YMAPA, ANCHO_MAPA, ALTO_MAPA);
		add(lblViajarA);
		add(btnDestino1);
		add(btnDestino2);
		add(btnDestino3);
		add(btnDestino4);
		add(lblhsDestino1);
		add(lblhsDestino2);
		add(lblhsDestino3);
		add(lblhsDestino4);
		add(btnVolver);
		add(mapa);
	}

	public void addViajarListener(ActionListener l) {
		btnDestino1.addActionListener(l);
		btnDestino2.addActionListener(l);
		btnDestino3.addActionListener(l);
		btnDestino4.addActionListener(l);
	}

	public void addVolverAPanelPartida(ActionListener l) {
		btnVolver.addActionListener(l);
	}
}