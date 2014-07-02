package vista.pantallas;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import vista.botonesGenericos.BotonVolver;
import vista.panelesGenericos.PanelConFondo;


public class PanelOrdenOK extends PanelConFondo {
	
	private static final long serialVersionUID = -7469145946869200592L;
	private static final String IMGPATH = "images/";
	static final String FONDO = IMGPATH + "ok.jpg";
	private BotonVolver volver = new BotonVolver();
	private JLabel mensajeok = new JLabel("La orden fue emitida correctamente.");
	
	public PanelOrdenOK() {
	    super(FONDO);
		setLayout(null);
		add(volver);
		volver.setBounds(0,0,100,100);
		add(mensajeok);
		mensajeok.setForeground(Color.black);
		mensajeok.setBounds(250,0,300,100);
		
	}
	
	public void addVolverAPanelPartidaListener(ActionListener l) {
		volver.addActionListener(l);
	}

}
