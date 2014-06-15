package carmen.modelo;

public class Velocidad {

	private int kmPorHora;

	public Velocidad(int kmPorHora) {
		this.kmPorHora = kmPorHora;
	}

	public int calcularTiempo(int distancia) {
		return (distancia / this.kmPorHora);
	}

	public int getKmPorHora() {
		return this.kmPorHora;
	}
}