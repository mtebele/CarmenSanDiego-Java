package carmen.modelo;

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
/*public class Valor {

	private String valor;
	private int cantCiudadesDeEscape;
	
	public Valor(String valor, int cantCiudadesDeEscape){
		this.valor = valor;
		this.cantCiudadesDeEscape = cantCiudadesDeEscape;
	}

	public int getCantidadDeEscapes() {
		return this.cantCiudadesDeEscape;
	}
	
	public String getValor() {
		return this.valor;
	}
}*/