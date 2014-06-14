package carmen.modelo;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Tiempo {

	private int horasRestantes;
	private List<Integer> horasDelDia;
	private int horaActual;
	private Iterator<Integer> iterador;

	public Tiempo() {
		this.horasRestantes = 154;
		this.horaActual = 7;
	}
	
	public void transcurrirHoras(int horas) {
		this.horasRestantes -= horas;
		
		if ( (this.horaActual + horas) < 24) {
			this.horaActual += horas;
		} else {
			this.horaActual = horas - (24 - this.horaActual);
		}

		int horaMinimaParaDormir = 22;
		int horaMaximaParaDormir = 6;
		if ( this.horaActual < horaMaximaParaDormir || this.horaActual > horaMinimaParaDormir ) {
			this.pasarLaNoche();
		}
	}
	
	private void pasarLaNoche() {
		int horasDeSueño = 8;
		transcurrirHoras(horasDeSueño);
	}
	
	public int horaActual() {
		return this.horaActual;
	} 
	
	public int horasRestantes() {
		return this.horasRestantes;
	}
	
}