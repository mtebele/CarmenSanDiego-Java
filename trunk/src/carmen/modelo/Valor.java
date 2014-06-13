package carmen.modelo;

public class Valor {

	private String valor;
	private int cantidadCiudadesDeEscape;

	public int getCantidadDeEscapes(){
		return this.cantidadCiudadesDeEscape;
	}
	
	public void setearCantidadCiudadesDeEscapes(int cantidad) {
		this.cantidadCiudadesDeEscape = cantidad;
	}
}