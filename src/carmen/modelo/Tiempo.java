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
		this.horasDelDia = new ArrayList<Integer>();
		for (int i=0; i<24; i++) {
			this.horasDelDia.add(i);
		}
		this.horaActual = this.horasDelDia.get(10);
		this.iterador = this.horasDelDia.iterator();
	}
	
	public void transcurrirHora() {
		this.horasRestantes -= 1;
		
		if (this.iterador.hasNext()) {
			this.horaActual = this.iterador.next();
		} else {
			this.horaActual = this.horasDelDia.get(0);
			this.iterador = this.horasDelDia.iterator();    //Creo un iterador para el nuevo dia.
		}
		
		
		if ( this.horaActual < 6 || this.horaActual > 22 ) {	//Hardcodeo, si es muy tarde duerme.
			this.pasarLaNoche();
		}
	}
	
	private void pasarLaNoche() {
		int horasDeSueño = 8;
		for (int i=0; i<horasDeSueño; i++) {
			transcurrirHora();
		}
	}
	
	public int horaActual() {
		return this.horaActual;
	} 
	
	public int horasRestantes() {
		return this.horasRestantes;
	}
	
}