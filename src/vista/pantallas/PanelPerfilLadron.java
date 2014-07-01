package vista.pantallas;

import vista.panelesGenericos.PanelConFondo;

public class PanelPerfilLadron extends PanelConFondo {
	private static final long serialVersionUID = 4764145977854800531L;
	private static final String IMGPATH = "images/fichas/";

	public PanelPerfilLadron(String fileName) {
		super(IMGPATH + fileName + ".png");
		setVisible(true);
	}
}
