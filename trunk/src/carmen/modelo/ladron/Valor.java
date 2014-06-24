package carmen.modelo.ladron;

public enum Valor{
	//El enum valor contiene la cantidad de ciudades de escape
	COMUN (4),
	VALIOSO (5),
	MUY_VALIOSO (7);
	
	private final int cantidadCiudadesEscape;
	
	Valor(int cantidadCiudadesEscape){
		this.cantidadCiudadesEscape = cantidadCiudadesEscape;
	}
	
	public int getCantidadDeEscapes(){
		return this.cantidadCiudadesEscape;
	}
}
