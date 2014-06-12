package carmen.modelo;

public class Disparo implements Atacable {

	private int vecesRecibido;

	public int ejecutarAtaque() {
		int horasPerdidas = 4;
		return horasPerdidas;
	}
}