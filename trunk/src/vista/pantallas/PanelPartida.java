package vista.pantallas;

import javax.swing.*;

import vista.LabelImagen;
import vista.botonesGenericos.BotonBaseLadrones;
import vista.botonesGenericos.BotonEmitirOrdenArresto;
import vista.botonesGenericos.BotonInfoPolicia;
import vista.botonesGenericos.BotonInterrogar;
import vista.botonesGenericos.BotonViajar;
import vista.botonesGenericos.BotonVolver;
import vista.panelesGenericos.PanelConFondo;

import java.awt.Color;
import java.awt.event.ActionListener;

public class PanelPartida extends PanelConFondo {

	private static final long serialVersionUID = -441040584998861794L;
	private static final String IMGPATH = "images/";
	private static final String IMGPATHCIUDADES = "images/ciudades/";
	static final String FONDO = IMGPATH + "partida.png";
	static final String ICONOBANCO = IMGPATH + "banco.png";
	static final String ICONOCULTURA = IMGPATH + "cultura.png";
	static final String ICONOTRANSPORTE = IMGPATH + "transporte.png";
	private JLabel lblReloj = new JLabel("<HORA>");
	private JLabel lblHsRestantes = new JLabel("<HORAS RESTANTES>");
	private BotonInterrogar btnInterrogarEconomia;
	private BotonInterrogar btnInterrogarCultura;
	private BotonInterrogar btnInterrogarTransportes;
	private BotonInfoPolicia btnInfoPolicia = new BotonInfoPolicia();
	private BotonVolver btnVolver = new BotonVolver();
	private BotonBaseLadrones btnLadrones = new BotonBaseLadrones();
	private BotonViajar btnViajar = new BotonViajar();
	private BotonEmitirOrdenArresto btnOrden = new BotonEmitirOrdenArresto();
	private LabelImagen imagenCiudad;
	private LabelImagen imagenEconomia = new LabelImagen(ICONOBANCO);
	private LabelImagen imagenCultura = new LabelImagen(ICONOCULTURA);
	private LabelImagen imagenTransportes = new LabelImagen(ICONOTRANSPORTE);
	private JLabel imagenReloj = new JLabel();

	public PanelPartida(int hsRestantes, int horaActual, String nombreLocal1, String nombreLocal2, String nombreLocal3,
			String nombreCiudad) {
		super(FONDO);
		setLayout(null);

		btnInterrogarEconomia = new BotonInterrogar(nombreLocal1);
		btnInterrogarCultura = new BotonInterrogar(nombreLocal2);
		btnInterrogarTransportes = new BotonInterrogar(nombreLocal3);

		imagenCiudad = new LabelImagen(IMGPATHCIUDADES + nombreCiudad + ".png");
		ImageIcon imageIcon = new ImageIcon("images/relojarena.gif");
		imagenReloj.setIcon(imageIcon);
		imagenReloj.setBounds(230, 0, 120, 120);
		this.add(imagenReloj);
		lblReloj.setText("HORA: " + Integer.toString(horaActual) + ":00");
		lblReloj.setForeground(Color.white);
		this.add(lblReloj);
		lblReloj.setBounds(180, 60, 200, 20);
		lblHsRestantes.setText("HORAS RESTANTES: " + Integer.toString(hsRestantes));
		lblHsRestantes.setForeground(Color.white);
		this.add(lblHsRestantes);
		lblHsRestantes.setBounds(10, 60, 200, 20);
		this.add(btnInfoPolicia);
		btnInfoPolicia.setBounds(10, 160, 200, 40);
		this.add(btnVolver);
		btnVolver.setBounds(10, 110, 200, 40);
		this.add(btnViajar);
		btnViajar.setBounds(10, 210, 200, 40);
		this.add(btnLadrones);
		btnLadrones.setBounds(10, 260, 200, 40);
		this.add(btnOrden);
		btnOrden.setBounds(10, 310, 200, 40);
		this.add(imagenCiudad);
		imagenCiudad.setBounds(375, 110, 400, 200);
		this.add(imagenEconomia);
		imagenEconomia.setBounds(515, 350, 100, 100);
		this.add(imagenCultura);
		imagenCultura.setBounds(665, 350, 100, 100);
		this.add(imagenTransportes);
		imagenTransportes.setBounds(365, 350, 100, 100);
		this.add(btnInterrogarTransportes);
		btnInterrogarTransportes.setBounds(350, 450, 125, 40);
		this.add(btnInterrogarEconomia);
		btnInterrogarEconomia.setBounds(500, 450, 125, 40);
		this.add(btnInterrogarCultura);
		btnInterrogarCultura.setBounds(650, 450, 125, 40);
	}

	public void addInterrogarListener(ActionListener l) {
		btnInterrogarEconomia.addActionListener(l);
		btnInterrogarCultura.addActionListener(l);
		btnInterrogarTransportes.addActionListener(l);
	}

	public void addAbrirPanelInfoPoliciaListener(ActionListener l) {
		btnInfoPolicia.addActionListener(l);
	}

	public void addAbrirPanelLadronesListener(ActionListener l) {
		btnLadrones.addActionListener(l);
	}

	public void addAbrirPanelOrdenArrestoListener(ActionListener l) {
		btnOrden.addActionListener(l);
	}

	public void addAbrirPanelViajarListener(ActionListener l) {
		btnViajar.addActionListener(l);
	}

	public void addVolverAPanelNuevaPartidaListener(ActionListener l) {
		btnVolver.addActionListener(l);
	}

}