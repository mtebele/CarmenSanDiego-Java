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
	
	public int cantidadLocales(){
		/*no se me ocurrio como validar que meti locales sin usar mocks, si es
		 * muy cabeza me avisan y lo cambio */
		return this.locales.size();
	}
	//public void setearUbicacion(int ubicacion) {
	//	this.ubicacion = ubicacion;
	//}
	//creo metodo de clase y la ciudad se inicia con ubicacion si o si.
}