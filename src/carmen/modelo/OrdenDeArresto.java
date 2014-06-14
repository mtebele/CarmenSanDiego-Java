package carmen.modelo;

public class OrdenDeArresto {

	private Ladron ladron;

	public OrdenDeArresto() {
		this.ladron = null;
	}

	public void emitirOrden(Ladron ladron) {
		this.ladron = ladron;
	}

	public Ladron verLadron() {
		return this.ladron;
	}
}