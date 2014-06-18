package carmen.modelo;

public class Cuchillazo implements IAtaque {

	private int vecesEjecutado;
	
	public Cuchillazo() {
		this.vecesEjecutado = 0;
	}

	public int ejecutarAtaque() {
		int horasPerdidas = 2;
		if (this.vecesEjecutado == 0) {
			horasPerdidas = 1;
		}
		this.vecesEjecutado++;
		return horasPerdidas;
	}	
}