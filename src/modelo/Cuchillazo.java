package modelo;

import modelo.interfaces.IAtaque;

public class Cuchillazo implements IAtaque {

	private int vecesEjecutado;
	private int probabilidad;
	
	public Cuchillazo() {
		this.vecesEjecutado = 0;
		this.probabilidad = 10;
	}

	public int ejecutarAtaque() {
		int horasPerdidas = 2;
		if (this.vecesEjecutado == 0) {
			horasPerdidas = 1;
		}
		this.vecesEjecutado++;
		return horasPerdidas;
	}
	
	public int getProbabilidadDeAtaque() {
		return this.probabilidad;
	}
	
	public void setProbabilidadDeAtaque(int porcentaje) {
		this.probabilidad = porcentaje;
	}
}