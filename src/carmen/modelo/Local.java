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

	public int getHorasInterrogatorio() {
		int horasInterrogatorio;
		switch (this.vecesVisitado()) {
		case 0:
			horasInterrogatorio = 1;
		case 1:
			horasInterrogatorio = 2;
		default:
			horasInterrogatorio = 3;
		}
		return horasInterrogatorio;
	}
	
	public String responder() {
		this.vecesVisitado ++;
		return this.pista;		
	}
}
