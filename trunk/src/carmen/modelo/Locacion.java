package carmen.modelo;
import java.util.ArrayList;
public class Locacion {

	private Mapa mapa;
	private Ladron ladron;
	private Ciudad ciudadActual;
	private ArrayList<Ciudad> ciudadesDestino;
	
	static void estandoEnCiudad(Ciudad ciudadOrigen) {
		
	}
	
	public int dormir(Ciudad ciudad) {
		//no sería responsabilidad de otro objeto?
		return 0;
	}
	
	public void generarNuevosDestinos() {
		
	}
	
	public void interrogar(Local local) {
		
	}
	
	public void agregarDestino(Ciudad destino) {
		
	}
	
	public Ciudad ciudadActual() {
		return ciudadActual;
	}
	
	public boolean estaLadron() {
		return (ladron != null);
	}
}