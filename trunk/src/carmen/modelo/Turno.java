package carmen.modelo;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Turno {

	private Tiempo tiempo;
	private Locacion locacion;
	private List<IAtacador> atacadores;
	private int probabilidadDeCuchillazo;
	private int probabilidadDeDisparo;

	public Turno(Locacion locacionInicial) {
		this.locacion = locacionInicial;
		this.tiempo = new Tiempo();
		IAtacador cuchillazo = new Cuchillazo();
		IAtacador disparo = new Disparo();
		this.atacadores = new ArrayList<IAtacador>();
		this.atacadores.add(cuchillazo);
		this.atacadores.add(disparo);
		
		this.probabilidadDeCuchillazo = 10;
		this.probabilidadDeDisparo = 5;
	}
	
	public void setearProbabilidadCuchillazo(int porcentaje) {
		this.probabilidadDeCuchillazo = porcentaje;
	}
	
	public void setearProbabilidadDisparo(int porcentaje) {
		this.probabilidadDeDisparo = porcentaje;
	}

	public void actualizar(int horas) {
		this.tiempo.transcurrirHoras(horas);
	}

	public void viajar(Ciudad destino, Velocidad velocidad) {
		int distancia = this.ciudadActual().distanciaAOtraCiudad(destino);
		int horasDeViaje = velocidad.calcularTiempo(distancia);
		
		this.locacion.viajar(destino);
		
		this.actualizar(horasDeViaje);

	}

	public String interrogar(Local local) {
		int horasInterrogatorio;
		switch(local.vecesVisitado()) {
			case 0: horasInterrogatorio = 1;
					break;
			case 1: horasInterrogatorio = 2;
					break;
			default: horasInterrogatorio = 3;
					break;
		
		}
		
		int horasPerdidasPorCuchillazo = this.recibirCuchillazo();
		int horasPerdidasPorDisparo = 0;
		if (horasPerdidasPorCuchillazo == 0) {
			horasPerdidasPorDisparo = this.recibirDisparo();
		}
		
		this.actualizar(horasInterrogatorio + horasPerdidasPorCuchillazo + horasPerdidasPorDisparo);
		
		return this.locacion.interrogar(local);
	}

	public boolean quedaTiempo() {
		return this.tiempo.quedaTiempo();
	}
	
	
	private int recibirCuchillazo() {
		Random random = new Random();
		int horasPerdidas = 0;
		if ( random.nextInt(100) < this.probabilidadDeCuchillazo ) {
				horasPerdidas = this.atacadores.get(0).ejecutarAtaque();
			}
		return horasPerdidas;
	}
	
	private int recibirDisparo() {
		Random random = new Random();
		int horasPerdidas = 0;
		if ( random.nextInt(100) < this.probabilidadDeDisparo ) {
				horasPerdidas = this.atacadores.get(1).ejecutarAtaque();
			}
		return horasPerdidas;
	}

	public Ciudad ciudadActual() {
		return this.locacion.ciudadActual();
		
	}

	public int getHorasRestantes() {
		return this.tiempo.horasRestantes();
	}
	
	public List<Ciudad> getDestinos() {
		return this.locacion.getDestinos();
	}
	
	public List<Local> getLocales() {
		return this.locacion.getLocales();
	}
	
}