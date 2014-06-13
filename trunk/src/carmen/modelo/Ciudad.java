package carmen.modelo;

import java.util.ArrayList;

public class Ciudad {

	private ArrayList<Local> locales;
	private Coordenada ubicacion;
	
	public Ciudad(Coordenada coordenadas) {
		this.ubicacion = coordenadas;
	}
	
	//no tiene sentido que interrogue posta, asi que le pongo de nombre ingresar.
	//public void interrogar(Local local) {
		//la ciudad no deberia interrogar, sino el policia (ver como adaptar a mi disenio)
	//}
	public String ingresar(Local local) {
		return local.responder();
	}
	
	public void setearLocal(Local local) {
		this.locales.add(local);
	}
	
}