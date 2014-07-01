package vista.pantallas;

import javax.swing.*;

import vista.LabelImagen;
import vista.botonesGenericos.BotonInfoPolicia;
import vista.botonesGenericos.BotonInterrogar;
import vista.botonesGenericos.BotonVolver;
import vista.panelesGenericos.PanelConFondo;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPartida extends PanelConFondo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String FONDO = "partida.png";
	
	private JTextArea logInvestigacion = new JTextArea();
	private JTextArea reloj = new JTextArea();
	private JTextArea diaDeSemana = new JTextArea();
	private JLabel imagenCiudad = new JLabel();
	private BotonInterrogar btnInterrogarEconomia = new BotonInterrogar();
	private BotonInterrogar btnInterrogarCultura = new BotonInterrogar();
	private BotonInterrogar btnInterrogarTransportes = new BotonInterrogar();
	private BotonInfoPolicia btnInfoPolicia = new BotonInfoPolicia();
	private BotonVolver btnVolver = new BotonVolver();
	private LabelImagen imagenEconomia = new LabelImagen("banco.png");
	private LabelImagen imagenCultura = new LabelImagen("cultura.png");
	private LabelImagen imagenTransportes = new LabelImagen("transporte.png");
	
	public PanelPartida(){
		super(FONDO);
		this.add(reloj);
		this.add(diaDeSemana);
		this.add(logInvestigacion);
		this.add(btnInfoPolicia);
		this.add(imagenCiudad);
		this.add(imagenCiudad);
		this.add(imagenEconomia);
		this.add(imagenTransportes);
		this.add(btnInterrogarTransportes);
		this.add(btnInterrogarEconomia);
		this.add(btnInterrogarCultura);
		this.add(btnVolver);
	}
	
}