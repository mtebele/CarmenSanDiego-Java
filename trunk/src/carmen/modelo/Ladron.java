package carmen.modelo;

public class Ladron {
	private Perfil perfil;
	private Ciudad ciudadActual;
	private ObjetoRobado objeto;
	private Itinerario itinerario;

	public Ladron(Perfil perfil) {
		
		this.perfil = perfil;
		this.ciudadActual = null;
		this.objeto = null;
		this.itinerario = new Itinerario();
	}

	public void planearNuevoDestino(Ciudad ciudad) {
		this.itinerario.agregarAlRecorrido(ciudad);
	}
	
	public Ciudad ciudadActual() {
		return this.ciudadActual;
	}

	public boolean escapar() throws LadronNoHaRobadoException {
		if (this.objeto == null) throw new LadronNoHaRobadoException("El ladron no robo ningun objeto");
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

	public boolean hizoUltimoEscape() {
		int cantDeEscapes = this.objeto.getValor().getCantidadDeEscapes();
		if (this.ciudadActual.equals(this.itinerario.ciudadNro(cantDeEscapes))) {
			return true;
		}
		return false;
	}
	
	//Lo puse porque me hacía falta para un test
	public String verNombre(){
		return this.perfil.verNombre();
	}
}