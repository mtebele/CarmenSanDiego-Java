package vista.pantallas;

import java.awt.Color;

import javax.swing.JLabel;

import vista.botonesGenericos.BotonVolver;
import vista.panelesGenericos.PanelConFondo;


public class PanelOrdenError extends PanelConFondo {
	
	private static final long serialVersionUID = -7469145946869200592L;
	private static final String IMGPATH = "images/";
	static final String FONDO = IMGPATH + "error.png";
	private BotonVolver volver = new BotonVolver();
	private JLabel mensajeok = new JLabel("ERROR:Ya hay una orden en proceso!");
	
	public PanelOrdenError() {
	    super(FONDO);
		setLayout(null);
		add(volver);
		volver.setBounds(0,0,100,100);
		add(mensajeok);
		mensajeok.setForeground(Color.black);
		mensajeok.setBounds(300,0,300,100);
		
	}

}
