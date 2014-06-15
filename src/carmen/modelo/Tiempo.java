package carmen.modelo;


public class Tiempo {

	private int horasRestantes;
	private int horaActual;

	public Tiempo() {
		this.horasRestantes = 154;
		this.horaActual = 7;
	}

	public void transcurrirHoras(int horas) {
		this.horasRestantes -= horas;

		int nuevaHoraActual = (this.horaActual + horas) % 24;
		this.horaActual = nuevaHoraActual;

		int horaMinimaParaDormir = 22;
		int horaMaximaParaDormir = 6;
		if (this.horaActual < horaMaximaParaDormir || this.horaActual > horaMinimaParaDormir) {
			this.pasarLaNoche();
		}
	}

	private void pasarLaNoche() {
		int horasDeSuenio = 8;
		transcurrirHoras(horasDeSuenio);
	}

	public boolean quedaTiempo() {
		return (this.horasRestantes > 0);
	}

	public int horaActual() {
		return this.horaActual;
	}

	public int horasRestantes() {
		return this.horasRestantes;
	}

}