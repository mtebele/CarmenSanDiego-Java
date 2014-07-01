package vista.pantallas;

import javax.swing.JComboBox;
import vista.botonesGenericos.BotonEmitirOrdenArresto;
import vista.botonesGenericos.BotonVolver;
import vista.panelesGenericos.PanelConFondo;

public class PanelOrdenArresto extends PanelConFondo {

	private static final long serialVersionUID = 7731072860454486108L;
	private static final String IMGPATH = "images/";
	static final String FONDO = IMGPATH + "ordenarresto.jpg";

	private BotonVolver btnVolver = new BotonVolver();
	private BotonEmitirOrdenArresto btnArresto = new BotonEmitirOrdenArresto();

	private String[] ladrones = { "Seleccione un ladron", "Nick Brunch", "Len Bulk", "Ihor Ihorovitch",
			"Fast Eddie B.", "Scar Graynolt", "Merey Laroc", "Lady Agatha", "Katherine Drib", "Dazzle Annie",
			"Carmen Sandiego" };

	private JComboBox<String> cmbLadrones = new JComboBox<String>(ladrones);

	public PanelOrdenArresto() {
		super(FONDO);
		add(cmbLadrones);
		add(btnArresto);
		add(btnVolver);
	}

}
