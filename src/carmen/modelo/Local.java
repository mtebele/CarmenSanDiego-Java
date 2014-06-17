package carmen.modelo;

public class Local {

	private int vecesVisitado;
	private String pista;

	public Local() {
		this.vecesVisitado = 0;
	}

	public int vecesVisitado() {
		return this.vecesVisitado;
	}

	public void setearPista(String pista) {
		this.pista = pista;
	}

	public String responder() {
		this.vecesVisitado ++; //cada vez que respondo fue visitado y deberia aumentar las visitas
		return this.pista;
		
	}

}
