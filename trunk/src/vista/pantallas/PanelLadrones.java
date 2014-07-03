package vista.pantallas;

import java.awt.event.ActionListener;

import vista.LabelImagen;
import vista.botonesGenericos.BotonVolver;
import vista.panelesGenericos.PanelConFondo;

/*Este seria el panel que muestra la base de datos de los ladrones.
 Podria ser una lista de ladrones y cuando clickeas en uno se abre el panel
 correspodiente a cada ladron particular (PanelPerfilLadron.java).
 */

public class PanelLadrones extends PanelConFondo {

	private static final long serialVersionUID = -7469145946869200592L;
	private static final String IMGPATH = "images/";
	private static final String IMGPATHFICHAS = "images/fichas/";

	private static final String FONDO = IMGPATH + "partida.png";
	private static final String LADRON1 = IMGPATHFICHAS + "Carmen Sandiego.png";
	private static final String LADRON2 = IMGPATHFICHAS + "Dazzle Annie.png";
	private static final String LADRON3 = IMGPATHFICHAS + "Fast Eddie B.png";
	private static final String LADRON4 = IMGPATHFICHAS + "Ihor Ihorovitch.png";
	private static final String LADRON5 = IMGPATHFICHAS + "Katherine Drib.png";
	private static final String LADRON6 = IMGPATHFICHAS + "Lady Agatha.png";
	private static final String LADRON7 = IMGPATHFICHAS + "Len Bulk.png";
	private static final String LADRON8 = IMGPATHFICHAS + "Merey Laroc.png";
	private static final String LADRON9 = IMGPATHFICHAS + "Nick Brunch.png";
	private static final String LADRON10 = IMGPATHFICHAS + "Scar Graynolt.png";
	private LabelImagen ladron1 = new LabelImagen(LADRON1);
	private LabelImagen ladron2 = new LabelImagen(LADRON2);
	private LabelImagen ladron3 = new LabelImagen(LADRON3);
	private LabelImagen ladron4 = new LabelImagen(LADRON4);
	private LabelImagen ladron5 = new LabelImagen(LADRON5);
	private LabelImagen ladron6 = new LabelImagen(LADRON6);
	private LabelImagen ladron7 = new LabelImagen(LADRON7);
	private LabelImagen ladron8 = new LabelImagen(LADRON8);
	private LabelImagen ladron9 = new LabelImagen(LADRON9);
	private LabelImagen ladron10 = new LabelImagen(LADRON10);
	private BotonVolver btnVolver= new BotonVolver();

	public PanelLadrones() {
		super(FONDO);
		setLayout(null);
		add(ladron1);
		ladron1.setBounds(0, 0, 160, 250);
		add(ladron2);
		ladron2.setBounds(160,0,160,250);
		add(ladron3);
		ladron3.setBounds(320,0,160,250);
		add(ladron4);
		ladron4.setBounds(480,0,150,250);
		add(ladron5);
		ladron5.setBounds(630,0,170,250);
		add(ladron6);
		ladron6.setBounds(0,250,160,250);
		add(ladron7);
		ladron7.setBounds(160,250,160,250);
		add(ladron8);
		ladron8.setBounds(320,250,160,250);
		add(ladron9);
		ladron9.setBounds(480,250,160,250);
		add(ladron10);
		add(btnVolver);
		btnVolver.setBounds(0,500,795,75);
		ladron10.setBounds(630,250,170,250);
	}
	
	public void addVolverAPanelPartidaListener(ActionListener l) {
		btnVolver.addActionListener(l);
	}
	
}