package modelo.mapa;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Local {

	private int vecesVisitado;
	private String pista;
	private TipoLocal nombre;

	public Local(TipoLocal nombre, String pista) {
		this.vecesVisitado = 0;
		this.nombre = nombre;
		this.pista = pista;
	}

	public Local(TipoLocal nombre) {
		this.vecesVisitado = 0;
		this.nombre = nombre;
	}

	public int vecesVisitado() {
		return this.vecesVisitado;
	}

	public void setPista(String pista) {
		this.pista = pista;
	}

	public int getHorasProximoInterrogatorio() {
		int horasInterrogatorio;
		switch (this.vecesVisitado()) {
			case 0:
				horasInterrogatorio = 1;
				break;
			case 1:
				horasInterrogatorio = 2;
				break;
			default:
				horasInterrogatorio = 3;
				break;
		}
		return horasInterrogatorio;
	}

	public String responder() {
		this.visitar();
		return this.pista;
	}

	public void visitar() {
		this.vecesVisitado++;
	}

	public String getNombre() {
		return this.nombre.toString();
	}

	public static Local deserializar(Node elementoLocal) {

		String strNombre = ((Element) elementoLocal).getAttribute("nombre");
		TipoLocal tipo = TipoLocal.valueOf(strNombre.toUpperCase());
		String pista = ((Element) elementoLocal).getAttribute("pista");

		return new Local(tipo, pista);
	}
}
