package carmen.modelo;

public enum DefinicionRangoPolicia {
	NOVATO(0, 4, new RangoPoliciaNovato()), 
	DETECTIVE(5, 9, new RangoPoliciaDetective()), 
	INVESTIGADOR(10, 19, new RangoPoliciaInvestigador()), 
	SARGENTO(20, Integer.MAX_VALUE, new RangoPoliciaSargento());
	
	private int arrestosMinimos;
	private int arrestosMaximos;
	private Rango rango;

	private DefinicionRangoPolicia(int arrestosMinimos, int arrestosMaximos, Rango rango) {
		this.arrestosMinimos = arrestosMinimos;
		this.arrestosMaximos = arrestosMaximos;
		this.rango = rango;
	}
	
	public static Rango getObjetoRango(int cantidadArrestos) {
		for (DefinicionRangoPolicia definicionRango : DefinicionRangoPolicia.values()) {
			if (cantidadArrestos >= definicionRango.arrestosMinimos && cantidadArrestos <= definicionRango.arrestosMaximos){
				return definicionRango.rango;
			}
		}
		return null;
	}	
}
