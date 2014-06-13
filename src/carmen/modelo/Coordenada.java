package carmen.modelo;

public class Coordenada {
	//hay que determinar la unidad de posicion que usamos.
	private float longitud;
	private float latitud;
	
	public Coordenada(float longitud, float latitud) {
		this.longitud = longitud;
		this.latitud = latitud;
	}

	private float getLongitud() {
		return longitud;
	}
	private void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	
	private float getLatitud() {
		return latitud;
	}
	private void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	
	public float distanciaAOtraCoordenada(Coordenada otraCoord) {
		// hacer
		return 0;
	}
	
	//estaria bueno que para hacer el cálculo del tiempo igual no se use float, sino int.
}
