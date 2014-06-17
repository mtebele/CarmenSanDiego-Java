package carmen.modelo;

public class Ladron {
	private Perfil perfil;
	private Ciudad ciudadActual;
	private Ciudad ciudadAnterior;
	private ObjetoRobado objeto;
	private Itinerario itinerario;

	public Ladron(Perfil perfil) {
		
		this.perfil = perfil;
		this.ciudadActual = null;
		this.ciudadAnterior = null;
		this.objeto = null;
		this.itinerario = new Itinerario();
	}

	public void planearNuevoDestino(Ciudad ciudad) {
		this.itinerario.agregarAlRecorrido(ciudad);
	}
	
	public Ciudad ciudadActual() {
		return this.ciudadActual;
	}
	
	public Ciudad ciudadAnterior() {
		return this.ciudadAnterior;
	}

	public boolean escapar() throws LadronNoHaRobadoException {
		if (this.objeto == null) throw new LadronNoHaRobadoException("El ladron no robo ningun objeto");
		if (this.hizoUltimoEscape()) return false;
		int posActual = this.itinerario.ciudades().indexOf(this.ciudadActual);
		this.ciudadAnterior = this.ciudadActual;
		this.ciudadActual = this.itinerario.ciudadNro(posActual + 1);
		return true;
	}

	public void robarObjeto(ObjetoRobado objeto) {
		this.objeto = objeto;
		Ciudad ciudadActual = objeto.ciudadOrigen();
		this.ciudadActual = ciudadActual;
	}

	public boolean hizoUltimoEscape() {
		int cantDeEscapes = this.objeto.getValor().getCantidadDeEscapes();
		return this.ciudadActual.equals(this.itinerario.ciudadNro(cantDeEscapes));
	}
	
	//Lo puse porque me hac�a falta para un test
	public String verNombre(){
		return this.perfil.verNombre();
	}
}