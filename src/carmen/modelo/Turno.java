package carmen.modelo;

import java.util.ArrayList;
import java.util.List;

public class Turno {

	private Tiempo tiempo;
	private Locacion locacion;
	private List<IAtacable> listaAtacables;

	public Turno(Locacion locacionInicial) {
		this.locacion = locacionInicial;
		this.tiempo = new Tiempo();
	}

	public void actualizar(int horas) {
		this.tiempo.transcurrirHoras(horas);
	}

	public void viajar(Ciudad destino, Velocidad velocidad) {

	}

	public String interrogar(Local local) {

	}

	public boolean quedaTiempo() {
		return this.tiempo.quedaTiempo();
	}

	public Ciudad ciudadActual() {
		return null;
	}

	public int getHorasRestantes() {
		
	}
	
	public List<Ciudad> getDestinos() {
		return this.locacion.getDestinos();
	}
	
	public List<Local> getLocales() {
		return this.locacion.getLocales();
	}
	
}