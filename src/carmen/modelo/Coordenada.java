package carmen.modelo;

public class Coordenada {
	//hay que determinar la unidad de posicion que usamos.
	private double longitud;
	private double latitud;
	
	public Coordenada(double longitud, double latitud){
		this.longitud = longitud;
		this.latitud = latitud;
	}

	private double getLongitud() {
		return longitud;
	}
	private void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	private double getLatitud() {
		return latitud;
	}
	private void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	
	public double distanciaAOtraCoordenada(Coordenada otraCoord){
		return 0;
	}
}
