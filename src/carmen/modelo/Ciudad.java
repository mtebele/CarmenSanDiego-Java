package carmen.modelo;

public class Ciudad {

	private ArrayList<Local> locales;
	private int ubicacion;
	
	static void conUbicacion(int ubicacion) {
		setearUbicacion(ubicacion);
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