package carmen.modelo;
import  java.lang.Math;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Coordenada {
	// hay que determinar la unidad de posicion que usamos.
	private double longitud;
	private double latitud;
	static final double RADIOTERRESTRE= 6371;

	public Coordenada(double longitud, double latitud) {
		this.longitud = longitud;
		this.latitud = latitud;
	}

	double getLongitud() {
		return longitud;
	}

	double getLatitud() {
		return latitud;
	}
		
	int distanciaAOtraCoordenada(Coordenada otraCoord) {  
		double deltaLat = Math.toRadians(otraCoord.getLatitud()-this.getLatitud());  
        double deltaLong = Math.toRadians(otraCoord.getLongitud() -this.getLongitud());  
        double senodeltaLat = Math.sin(deltaLat / 2);  
        double senodeltaLong = Math.sin(deltaLong / 2);  
        double raiz = Math.pow(senodeltaLat, 2) + Math.pow(senodeltaLong, 2) * Math.cos(Math.toRadians(this.getLatitud())) * Math.cos(Math.toRadians(otraCoord.getLatitud()));  
        double resul = 2 * Math.atan2(Math.sqrt(raiz), Math.sqrt(1 - raiz));  
        double distancia = RADIOTERRESTRE * resul;  
  
        return (int) distancia;
	}
	
	public static Coordenada localizar(Node elementoCoordenada) {
		double latitud = Double.parseDouble(((Element)elementoCoordenada).getAttribute("latitud"));
		double longitud = Double.parseDouble(((Element)elementoCoordenada).getAttribute("longitud"));
		return new Coordenada(longitud, latitud);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitud);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitud);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		
		if (Double.doubleToLongBits(latitud) != Double
				.doubleToLongBits(other.latitud))
			return false;
		if (Double.doubleToLongBits(longitud) != Double
				.doubleToLongBits(other.longitud))
			return false;
		return true;
	}
}
