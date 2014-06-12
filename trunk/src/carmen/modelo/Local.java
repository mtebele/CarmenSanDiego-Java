package carmen.modelo;

public class Local {

	private int vecesVisitado;
	private String pista;
	private Ataque ataque;
	
	static void conPista(String pista) {
		//es el constructor?
		setearPista(pista);
	}
	
	public void responder() {
		
	}
	
	public void setearPista(String pista) {
		this.pista = pista;
	}
	
	public void setearAtaque(Ataque ataque) {
		this.ataque = ataque;
	}
}