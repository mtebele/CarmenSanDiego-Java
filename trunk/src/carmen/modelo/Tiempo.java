package carmen.modelo;

public class Tiempo {

	private int horasRestantes;
	private int horaActual;

	public void transcurrir(int horas) {
		this.horasRestantes -= horas;
	}
	
	// cambio el metodo dormir por pasarDeDia, queda mas claro.
	public void pasarDeDia() {
		int horasDeSue�o = 8;
		transcurrir(horasDeSue�o);
	}
}