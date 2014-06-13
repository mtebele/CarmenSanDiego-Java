package carmen.modelo;

import java.util.ArrayList;

public class Ciudad {

	private ArrayList<Local> locales;
	private Coordenada ubicacion;
	
	//pongo private asi no se puede crear ciudad sin ubicacion
	private Ciudad() {
	}
	
	public static Ciudad conUbicacion(Coordenada coordenadas) {
		Ciudad ciudad = new Ciudad();
		ciudad.ubicacion = coordenadas;
		return ciudad;
	}
	
	//no tiene sentido que interrogue posta, asi que le pongo de nombre ingresar.
	//public void interrogar(Local local) {
		//la ciudad no deberia interrogar, sino el policia (ver como adaptar a mi disenio)
	//}
	public char[] ingresar(Local local) {
		return local.responder();
	}
	
	public void setearLocal(Local local) {
		this.locales.add(local);
	}
	
	//public void setearUbicacion(int ubicacion) {
	//	this.ubicacion = ubicacion;
	//}
	//creo método de clase y la ciudad se inicia con ubicacion si o si.
}