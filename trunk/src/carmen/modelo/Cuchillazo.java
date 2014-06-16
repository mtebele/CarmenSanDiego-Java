package carmen.modelo;

public class Cuchillazo implements IAtacador {

	private int vecesEjecutado;

	public int ejecutarAtaque() {
		int horasPerdidas = 2;
		if (this.vecesEjecutado == 0) {
			horasPerdidas = 1;
			this.vecesEjecutado++;
		}
		return horasPerdidas;
	}
	
	
}