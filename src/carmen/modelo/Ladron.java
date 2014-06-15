package carmen.modelo;

public class Ladron {

	private String nombre;
	private String sexo;
	private String cabello;
	private String senia;
	private String hobby;
	private String vehiculo;
	private Ciudad ciudadActual;
	private ObjetoRobado objeto;
	private Itinerario itinerario;

	public Ladron(String nombre, String sexo, String cabello, String senia, String hobby, String vehiculo) {
		this.nombre = nombre;
		this.cabello = cabello;
		this.senia = senia;
		this.vehiculo = vehiculo;
		this.hobby = hobby;
		this.sexo = sexo;
		this.ciudadActual = null;
		this.objeto = null;
		
		this.itinerario = new Itinerario();
	}

	public Ciudad ciudadActual() {
		return this.ciudadActual;
	}

	public boolean escapar() {
		int cantDeEscapes = this.objeto.getValor().getCantidadDeEscapes();
		if (this.itinerario.ciudadNro(cantDeEscapes).equals(this.ciudadActual)) {
			return false;
		}

		int posActual = this.itinerario.ciudades().indexOf(ciudadActual);
		this.ciudadActual = this.itinerario.ciudadNro(posActual + 1);
		return true;
	}

	public void robarObjeto(ObjetoRobado objeto) {
		this.objeto = objeto;
		Ciudad ciudadActual = objeto.ciudadOrigen();
		this.ciudadActual = ciudadActual;
	}

	
	public void planearNuevoDestino(Ciudad ciudad) {
		this.itinerario.agregarAlRecorrido(ciudad);
	}

	public boolean hizoUltimoEscape() {
		int cantDeEscapes = this.objeto.getValor().getCantidadDeEscapes();
		if (this.ciudadActual.equals(this.itinerario.ciudadNro(cantDeEscapes))) {
			return true;
		}
		return false;
	}
}