package carmen.modelo;

public class ObjetoRobado {

	private Valor valor;
	private Ciudad ciudadOrigen;

	public ObjetoRobado(Valor unValor, Ciudad unaCiudad) {
		this.ciudadOrigen = unaCiudad;
		this.valor = unValor;
	}

	public Valor getValor() {
		return this.valor;
	}
	
	public Ciudad ciudadOrigen() {
		return this.ciudadOrigen;
	}
}