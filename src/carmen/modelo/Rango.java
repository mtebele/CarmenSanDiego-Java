package carmen.modelo;

public class Rango {

	private Valor valorObjetoBuscado;
	private Velocidad velocidad;
	private String rango;
	
	public Rango() {
		// No se bien como es eso del enum
	}
	
	public Valor getValorObjetoBuscado() {
		return this.valorObjetoBuscado;
	}
	
	public Velocidad getVelocidad() {
		return this.velocidad;
	}
	
	public String rango() {
		return this.rango;
	}
}