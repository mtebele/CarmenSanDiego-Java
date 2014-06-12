package carmen.modelo;

public class Turno {

	private Tiempo tiempo;
	private Locacion locacion;

	static void conLocacionInicial(Locacion locacion) {
		locacion = locacion;
	}
	
	public void actualizar(int horas){
		
	}
	
	public void viajar(Ciudad destino, Velocidad velocidad){
		
	}
	
	public void interrogar(Local local){
		
	}
	
	public boolean finalizoTiempo(){
		return false;
	}
	
	public Ciudad ciudadActual(){
		return null;
	}
	
	public void setearLocacion(Locacion locacion){
		this.locacion = locacion;
	}

	public int getHorasRestantes(){
		return 0;
	}
}