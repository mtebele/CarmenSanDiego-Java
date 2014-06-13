package carmen.modelo;

public class Ladron {

	private String nombre;
	private String cabello;
	private String senia;
	private String vehiculo;
	private String hobby;
	private String sexo;
	private Ciudad ciudadActual;
	private ObjetoRobado objeto;
	private ItinerarioDeLadron itinerario;
	
	public Ladron(String nombre, String cabello, String senia, String vehiculo, String hobby, String sexo) {
		this.nombre = nombre;
		this.cabello = cabello;
		this.senia = senia;
		this.vehiculo = vehiculo;
		this.hobby = hobby;
		this.sexo = sexo;
	} 
	
	public Ciudad ciudadActual() {
		return this.ciudadActual;
	}
	
    public boolean escapar() {
    	int cantDeEscapes = this.objeto.getValor().getCantidadDeEscapes();
    	if ( this.itinerario.ciudadNro(cantDeEscapes).equals(this.ciudadActual) ) {
    		return false;
    	}
    	
    	int posActual = this.itinerario.ciudades().indexOf(ciudadActual);
    	this.ciudadActual = this.itinerario.ciudadNro(posActual + 1);
    	return true;
    }
    
    public void robarObjeto(ObjetoRobado objeto) {
    	this.objeto = objeto;
    }
    
    public void planearEscape(ObjetoRobado objeto) {
    	int cantDeEscapes = objeto.getValor().getCantidadDeEscapes();
    	this.itinerario = new ItinerarioDeLadron(cantDeEscapes);
    }
    
    public boolean hizoUltimoEscape() {
    	int cantDeEscapes = this.objeto.getValor().getCantidadDeEscapes();
    	if ( this.ciudadActual = this.itinerario.ciudadNro(cantDeEscapes) ) {
    		return true;
    	}
    	return false;
    }
}