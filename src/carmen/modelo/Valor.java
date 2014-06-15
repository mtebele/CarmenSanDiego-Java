package carmen.modelo;

public class Valor {

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
}