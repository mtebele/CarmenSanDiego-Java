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

	private JLabel lblLogInvestigacion = new JLabel("<INFORMACION DE PISTAS>");
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

	public PanelPartida(int hsRestantes, int horaActual, String nombreLocal1, String nombreCiudad) {
		super(FONDO);
		setLayout(null);

		lblReloj.setText("HORA: " + Integer.toString(horaActual));
		lblReloj.setForeground(Color.white);
		this.add(lblReloj);
		lblReloj.setBounds(150, 10, 125, 20);
		lblHsRestantes.setText("HORAS RESTANTES: " + Integer.toString(hsRestantes));
		lblHsRestantes.setForeground(Color.white);
		this.add(lblHsRestantes);
		lblHsRestantes.setBounds(10, 10, 150, 20);
		lblLogInvestigacion.setForeground(Color.white);
		this.add(lblLogInvestigacion);
		lblLogInvestigacion.setBounds(10, 300, 300, 150);
		this.add(btnInfoPolicia);
		btnInfoPolicia.setBounds(10, 50, 200, 40);
		this.add(btnVolver);
		btnVolver.setBounds(10, 100, 200, 40);
		this.add(btnViajar);
		btnViajar.setBounds(10, 150, 200, 40);
		this.add(btnLadrones);
		btnLadrones.setBounds(10, 200, 200, 40);
		this.add(imagenCiudad);
		imagenCiudad.setBounds(375, 50, 400, 200);
		this.add(imagenEconomia);
		imagenEconomia.setBounds(365, 300, 100, 100);
		this.add(imagenCultura);
		imagenCultura.setBounds(515, 300, 100, 100);
		this.add(imagenTransportes);
		imagenTransportes.setBounds(665, 300, 100, 100);
		this.add(btnInterrogarTransportes);
		btnInterrogarTransportes.setBounds(350, 400, 125, 40);
		this.add(btnInterrogarEconomia);
		btnInterrogarEconomia.setBounds(500, 400, 125, 40);
		this.add(btnInterrogarCultura);
		btnInterrogarCultura.setBounds(650, 400, 125, 40);
	}
}