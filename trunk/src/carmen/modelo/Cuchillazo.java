package carmen.modelo;

public class Cuchillazo implements IAtacador {

	private int vecesRecibido;

	public int ejecutarAtaque() {
		int horasPerdidas = 2;
		if (vecesRecibido == 0) {
			horasPerdidas = 1;
			vecesRecibido++;
		}
		return horasPerdidas;
	}
}