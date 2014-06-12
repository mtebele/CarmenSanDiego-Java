package carmen.modelo;

import java.util.ArrayList;

public class Ciudad {

	private ArrayList<Local> locales;
	private int ubicacion;
	
	static void conUbicacion(int ubicacion) {
		ubicacion = ubicacion;
	}
	
	public void interrogar(Local local) {
		
	}
	
	public void setearLocal(Local local) {
		this.locales.add(local);
	}
	
	public void setearUbicacion(int ubicacion) {
		this.ubicacion = ubicacion;
	}
}