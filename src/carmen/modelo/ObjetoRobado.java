package carmen.modelo;

public class ObjetoRobado {

	private Valor valor;
	private Ciudad ciudadOrigen;

	public ObjetoRobado(Ciudad ciudad) {
		this.ciudadOrigen = ciudad;
		this.valor = null;
	}

	public Valor getValor() {
		return this.valor;
	}

	public void setearValor(Valor valor) {
		this.valor = valor;
	}
	
	public Ciudad ciudadOrigen() {
		return this.ciudadOrigen;
	}
}