package carmen.modelo;
import  java.lang.Math;


public class Coordenada {
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
		// Calculo que dijo Lucas va acá que ni conozco.
		int resultado = (int) Math.pow (this.getLongitud() - otraCoord.getLongitud(),2) + (int) Math.pow (this.getLatitud() - otraCoord.getLatitud(),2) ; 
		resultado= (int) Math.sqrt(resultado);
		return resultado;
	}

	// la formula es esa, estoy casteando a int porque devuelven un double esos operandos, no creo que haya problema en la conversion
	// Lucas: adhiero, que el tiempo se mida en horas.
}
