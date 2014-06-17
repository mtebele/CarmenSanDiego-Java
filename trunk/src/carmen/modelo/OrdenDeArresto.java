package carmen.modelo;

import java.util.ArrayList;
import java.util.List;

public class OrdenDeArresto {
	private List<Ladron> baseLadrones;

	private Ladron ladron;
	

	public OrdenDeArresto() {
		this.ladron = null;
		this.baseLadrones = new ArrayList<Ladron>();
	}

	
	public boolean arrestoEsValido(Ladron ladron){
		return baseLadrones.contains(ladron);
	}
	
	
	public void AgregarLadronABaseDeDatos (Ladron ladron){
		if  (arrestoEsValido(ladron)== false) {
			baseLadrones.add(ladron);
		}
	}
	
	

	public void emitirOrden(Ladron ladron) {
		if (arrestoEsValido (ladron))  {
			this.ladron= ladron;	
		}
	}
	
	
	public Ladron verLadron() {
		return this.ladron;
	}
}