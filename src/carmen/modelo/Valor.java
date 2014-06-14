package carmen.modelo;

public class Valor {

	private String valor;
	private int cantCiudadesDeEscape;

	public int getCantidadDeEscapes() {
		return this.cantCiudadesDeEscape;
	}

	public void setearCantDeEscapes(int cantidad) {
		this.cantCiudadesDeEscape = cantidad;
	}
}