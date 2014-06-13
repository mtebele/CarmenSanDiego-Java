package carmen.modelo;

import java.util.ArrayList;

public class Ciudad {

	private ArrayList<Local> locales;
	private Coordenada ubicacion;
	
	public Ciudad(Coordenada coordenadas) {
		this.locales = new ArrayList<Local>();
		this.ubicacion = coordenadas;
	}
	
	//no tiene sentido que interrogue posta, asi que le pongo de nombre ingresar.
	public String ingresar(Local local) {
		return local.responder();
	}
	
	public void setearLocal(Local local) {
		this.locales.add(local);
	}
	
}