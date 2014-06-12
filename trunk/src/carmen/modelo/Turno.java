package carmen.modelo;

public class Turno {

	private Tiempo tiempo;
	private Locacion locacion;

	static void conLocacionInicial(Locacion locacion) {
		setearLocacion(locacion);
	}
	
	public void actualizar(int horas){
		
	}
	
	public void viajar(Ciudad destino, Velocidad velocidad){
		
	}
	
	public void interrogar(Local local){
		
	}
	
	public boolean finalizoTiempo(){
		
	}
	
	public Ciudad ciudadActual(){
		
	}
	
	public void setearLocacion(Locacion locacion){
		this.locacion = locacion;
	}
}