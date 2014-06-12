package carmen.modelo;

import java.util.ArrayList;

public class Ciudad {

	private ArrayList<Local> locales;
	private Coordenada ubicacion;
	
	public Ciudad(Coordenada ubicacion) {
		ubicacion = ubicacion;
	}
	
	public void interrogar(Local local) {
		//la ciudad no deberia interrogar, sino el policia (ver como adaptar a mi disenio)
	}
	
	public void setearLocal(Local local) {
		this.locales.add(local);
	}
	
	public void setearUbicacion(int ubicacion) {
		this.ubicacion = ubicacion;
	}
}