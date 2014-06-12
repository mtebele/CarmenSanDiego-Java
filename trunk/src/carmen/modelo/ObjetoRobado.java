package carmen.modelo;

public class ObjetoRobado {

	private Valor valor;
	private Ciudad ciudadOrigen;

	public ObjetoRobado(Ciudad ciudad) {
		ciudadOrigen = ciudad;
	}
	
	public void setearValor(Valor valor) {
		this.valor = valor;
	}
}