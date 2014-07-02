package vista.pantallas;

import javax.swing.*;
import vista.LabelImagen;
import vista.botonesGenericos.BotonBaseLadrones;
import vista.botonesGenericos.BotonInfoPolicia;
import vista.botonesGenericos.BotonInterrogar;
import vista.botonesGenericos.BotonViajar;
import vista.botonesGenericos.BotonVolver;
import vista.panelesGenericos.PanelConFondo;
import java.awt.Color;

public class PanelPartida extends PanelConFondo {

	private static final long serialVersionUID = -441040584998861794L;
	private static final String IMGPATH = "images/";
	static final String FONDO = IMGPATH + "partida.png";

	private JLabel lblReloj = new JLabel("<HORA>");
	private JLabel lblHsRestantes = new JLabel("<HORAS RESTANTES>");
	private BotonInterrogar btnInterrogarEconomia = new BotonInterrogar();
	private BotonInterrogar btnInterrogarCultura = new BotonInterrogar();
	private BotonInterrogar btnInterrogarTransportes = new BotonInterrogar();
	private BotonInfoPolicia btnInfoPolicia = new BotonInfoPolicia();
	private BotonVolver btnVolver = new BotonVolver();
	private BotonBaseLadrones btnLadrones = new BotonBaseLadrones();
	private BotonViajar btnViajar = new BotonViajar();
	private LabelImagen imagenCiudad = new LabelImagen("images/fiuba.png");
	private LabelImagen imagenEconomia = new LabelImagen("images/banco.png");
	private LabelImagen imagenCultura = new LabelImagen("images/cultura.png");
	private LabelImagen imagenTransportes = new LabelImagen("images/transporte.png");
	private JLabel imagenReloj = new JLabel();
	

	public PanelPartida(int hsRestantes, int horaActual, String nombreLocal1, String nombreLocal2, String nombreLocal3, String nombreCiudad) {
		super(FONDO);
		setLayout(null);

		ImageIcon imageIcon = new ImageIcon("images/relojarena.gif");
		imagenReloj.setIcon(imageIcon);
		imagenReloj.setBounds(230, 0, 120, 120);
		this.add(imagenReloj);
		lblReloj.setBounds(200, 60, 125, 20);
		lblReloj.setText("HORA: " + Integer.toString(horaActual) + ":00");
		lblReloj.setForeground(Color.white);
		this.add(lblReloj);
		lblReloj.setBounds(180, 60, 125, 20);
		lblHsRestantes.setText("HORAS RESTANTES: " + Integer.toString(hsRestantes));
		lblHsRestantes.setForeground(Color.white);
		this.add(lblHsRestantes);
		lblHsRestantes.setBounds(10, 60, 150, 20);
		this.add(btnInfoPolicia);
		btnInfoPolicia.setBounds(10, 110, 200, 40);
		this.add(btnVolver);
		btnVolver.setBounds(10, 160, 200, 40);
		this.add(btnViajar);
		btnViajar.setBounds(10, 210, 200, 40);
		this.add(btnLadrones);
		btnLadrones.setBounds(10, 260, 200, 40);
		this.add(imagenCiudad);
		imagenCiudad.setBounds(375, 110, 400, 200);
		this.add(imagenEconomia);
		imagenEconomia.setBounds(365, 350, 100, 100);
		this.add(imagenCultura);
		imagenCultura.setBounds(515, 350, 100, 100);
		this.add(imagenTransportes);
		imagenTransportes.setBounds(665, 350, 100, 100);
		this.add(btnInterrogarTransportes);
		btnInterrogarTransportes.setBounds(350, 450, 125, 40);
		this.add(btnInterrogarEconomia);
		btnInterrogarEconomia.setBounds(500, 450, 125, 40);
		this.add(btnInterrogarCultura);
		btnInterrogarCultura.setBounds(650, 450, 125, 40);
	}
}