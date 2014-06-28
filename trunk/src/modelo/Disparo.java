package modelo;

import modelo.interfaces.IAtaque;

public class Disparo implements IAtaque {
	
	private int probabilidad;
	
	public Disparo() {
		this.probabilidad = 10;
	}

	public int ejecutarAtaque() {
		int horasPerdidas = 4;
		return horasPerdidas;
	}
	
	public int getProbabilidadDeAtaque() {
		return this.probabilidad;
	}
	
	public void setProbabilidadDeAtaque(int porcentaje) {
		this.probabilidad = porcentaje;
	}
}