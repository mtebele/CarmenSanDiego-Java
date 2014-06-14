package carmen.modelo;

public class Velocidad {

	private int kmPorHora;

	public Velocidad() {
	}

	public int calcularTiempo(int distancia) {
		return (distancia / this.kmPorHora);
	}

	public void setearKmPorHora(int kmPorHora) {
		this.kmPorHora = kmPorHora;
	}

	public int getKmPorHora() {
		return this.kmPorHora;
	}
}