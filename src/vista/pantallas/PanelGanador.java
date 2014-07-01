package vista.pantallas;
import vista.botonesGenericos.BotonMenuPrincipal;
import vista.botonesGenericos.BotonSalirJuego;

import javax.swing.JFrame;
import javax.swing.JButton;

import vista.panelesGenericos.PanelConFondo;
public class PanelGanador extends PanelConFondo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String FONDO = "ganador.png";
	private BotonMenuPrincipal botonSaltarInicio = new BotonMenuPrincipal();
	
	public PanelGanador(){
		super(FONDO);
		this.add(botonSaltarInicio);
		this.add(new BotonSalirJuego());
	}
	
}