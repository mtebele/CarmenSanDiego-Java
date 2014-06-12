package carmen.modelo;

public class ObjetoRobado {

	private Valor valor;
	private Ciudad ciudadOrigen;

	static void deCiudad(Ciudad ciudad) {
		this.ciudadOrigen = ciudad;
	}
	
	public void setearValor(Valor valor) {
		this.valor = valor;
	}
}