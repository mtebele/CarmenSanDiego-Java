package carmen.modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class OrdenDeArresto {
	private ArrayList<Ladron> baseLadrones;

	private Ladron ladron;

	public OrdenDeArresto() {
		this.ladron = null;
		this.baseLadrones = new ArrayList<Ladron>();
	}

	public boolean arrestoEsValido(Ladron ladron) {
		return baseLadrones.contains(ladron);
	}

	public void agregarLadronABaseDeDatos(Ladron ladron) {
		if (!arrestoEsValido(ladron)) {
			baseLadrones.add(ladron);
		}
	}

	public void emitirOrden(Ladron ladron) {
		if (arrestoEsValido(ladron)) {
			this.ladron = ladron;
		}
	}

	public Ladron verLadron() {
		return this.ladron;
	}
	
	public void CargarBaseDeDatos() throws ParserConfigurationException, SAXException, IOException
	{
		this.baseLadrones = LectorXML.cargarLadrones();
	}
}