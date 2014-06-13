package carmen.modelo;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

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
		this.horaActual = this.horasDelDia.get(11);
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
		
		
		if ( this.horaActual < 4 || this.horaActual > 22 ) {	//Hardcodeo, si es muy tarde duerme.
			this.pasarDeDia();
		}
	}
	
	private void pasarDeDia() {
		int horasDeSueño = 8;
		for (int i=0; i<horasDeSueño; i++) {
			transcurrirHora();
		}
	}
}