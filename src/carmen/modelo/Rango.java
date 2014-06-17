package carmen.modelo;

public abstract class Rango {

	protected Valor valorObjetoBuscado;
	protected Velocidad velocidad;
	protected String nombre;

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