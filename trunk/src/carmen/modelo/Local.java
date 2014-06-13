package carmen.modelo;

public class Local {

	private int vecesVisitado;
	private String pista;
	private Atacable ataque;
	
	public Local() {
		this.vecesVisitado = 0;
	}
	
	public static Local conPista(String pista) {
		Local local = new Local();
		local.pista = pista;
		return local;
	}

	public String responder() {
		return this.pista;
	}
	
	
	public void setearAtaque(Atacable ataque) {
		this.ataque = ataque;
	}
}
