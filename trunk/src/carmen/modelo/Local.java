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

	public int getHorasProximoInterrogatorio() {
		int horasInterrogatorio;
		switch (this.vecesVisitado()) {
		case 0:
			horasInterrogatorio = 1;
			break;
		case 1:
			horasInterrogatorio = 2;
			break;
		default:
			horasInterrogatorio = 3;
			break;
		}
		return horasInterrogatorio;
	}
	
	public String responder() {
		this.visitar();
		return this.pista;		
	}
	
	public void visitar() {
		this.vecesVisitado++;
	}
}
