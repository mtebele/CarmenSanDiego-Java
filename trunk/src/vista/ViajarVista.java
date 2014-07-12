package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import vista.botonesGenericos.BotonDestinoViajar;
import vista.botonesGenericos.BotonVolver;
import vista.controlesGenericos.LabelImagen;
import vista.panelesGenericos.PanelConFondo;

public class ViajarVista extends PanelConFondo {

	private static final long serialVersionUID = 5319443758271459237L;
	private static final String IMGPATH = "images/";
	static final String FONDO = IMGPATH + "viajar.png";
	static final String MAPA = IMGPATH + "mapa.jpg";
	static final int TAMLETRA = 22;
	static final int ALTO = 50;
	static final int ANCHO = 150;
	static final int YDESTINO = 400;
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

	private BotonDestinoViajar btnDestino;
	private JLabel lblHsDestino;
	private List<BotonDestinoViajar> botones;

	public ViajarVista(List<String> destinos, List<Integer> horas) {
		super(FONDO);

		Font fuenteDestinos = new Font("Trebuchet.MS", Font.BOLD, 14);
		botones = new ArrayList<BotonDestinoViajar>();
		int XDESTINO = 20;

		for (int i = 0; i < destinos.size(); i++) {
			String unDestino = destinos.get(i);
			Integer unaHora = horas.get(i);

			btnDestino = new BotonDestinoViajar(unDestino);
			btnDestino.setBounds(XDESTINO, YDESTINO, ANCHO, ALTO);
			btnDestino.setFont(fuenteDestinos);
			botones.add(btnDestino);

			lblHsDestino = new JLabel(unaHora.toString() + " HS");
			lblHsDestino.setBounds(XDESTINO + 60, YDESTINO + 40, ANCHO, ALTO);
			lblHsDestino.setFont(new java.awt.Font("Tahoma", 0, 14));
			lblHsDestino.setForeground(Color.white);
			lblHsDestino.setBackground(Color.black);

			add(btnDestino);
			add(lblHsDestino);

			XDESTINO += 200;
		}

		setLayout(null);
		lblViajarA.setBounds(XVIAJAR, YVIAJAR, ANCHO_VIAJAR, ALTO_VIAJAR);
		lblViajarA.setForeground(Color.white);
		lblViajarA.setBackground(Color.black);
		lblViajarA.setOpaque(true);
		lblViajarA.setFont(new java.awt.Font("Tahoma", 0, TAMLETRA));
		btnVolver.setBounds(XVOLVER, YVOLVER, ANCHO_VOLVER, ALTO_VOLVER);
		mapa.setBounds(XMAPA, YMAPA, ANCHO_MAPA, ALTO_MAPA);
		add(lblViajarA);
		add(btnVolver);
		add(mapa);
	}

	public void addViajarListener(ActionListener l) {
		for (BotonDestinoViajar btnDestino : botones) {
			btnDestino.addActionListener(l);
		}
	}

	public void addVolverAPanelPartida(ActionListener l) {
		btnVolver.addActionListener(l);
	}
}