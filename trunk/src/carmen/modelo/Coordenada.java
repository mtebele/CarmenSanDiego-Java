package carmen.modelo;
import  java.lang.Math;


public class Coordenada {
	static final double RADIOTERRESTRE = 6371;
	// hay que determinar la unidad de posicion que usamos.
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

	int distanciaAOtraCoordenada(Coordenada otraCoord) {
		
		double deltaLatitud = this.getLatitud() - otraCoord.getLatitud();
		deltaLatitud= Math.toRadians(deltaLatitud);
		double deltaLongitud= this.getLongitud()- otraCoord.getLongitud();
		deltaLongitud = Math.toRadians(deltaLongitud);
		double senolat=(deltaLatitud / 2);
		double senolong= (deltaLongitud/2);
		double raiz= (senolat*senolat) + Math.cos(this.getLatitud()) * Math.cos(otraCoord.getLatitud())*senolong*senolong;
		double resultado= 2 * Math.asin (Math.min(1.0, Math.sqrt(raiz)));
		resultado= resultado * RADIOTERRESTRE;
		return (int) resultado;
	}

	// la formula es esa, estoy casteando a int porque devuelven un double esos operandos, no creo que haya problema en la conversion
	// Lucas: adhiero, que el tiempo se mida en horas.
}
