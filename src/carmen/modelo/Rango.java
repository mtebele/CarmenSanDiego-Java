package carmen.modelo;

public class Rango {

	private Valor valorObjetoBuscado;
	private Velocidad velocidad;
	private String nombre;

	public Rango() {
		// No se bien como es eso del enum
	}

	public Valor getValorObjetoBuscado() {
		return this.valorObjetoBuscado;
	}

	public Velocidad getVelocidad() {
		return this.velocidad;
	}

	public String getNombre() {
		return this.nombre;
	}
}