package carmen.modelo;

public class Juego {

	private Policia policia;
	private LectorXML lectorXML; // Solo si lo hacemos con objetos, si va embebido en cada clase esto vuela.

	public Partida nuevaPartida() {
		
		// TODO: reemplazar estas hardcodeos por lo que devuelva el lectorXML
				
		this.policia = new Policia();
		
		Perfil perfilLadron = new Perfil("Mark", Sexo.MASCULINO, Cabello.ROJO, Senia.TATUAJE, Vehiculo.MOTO, Hobby.ALPINISMO);
		Ladron ladron = new Ladron(perfilLadron);
		
		Mapa mapa = LectorXML.cargarMapa();
		Ciudad ciudadActual = new Ciudad(new Coordenada(500,500));
		Locacion locacionInicial = new Locacion(mapa, ciudadActual, ladron);
		Turno turno = new Turno(locacionInicial);
		
		OrdenDeArresto orden = new OrdenDeArresto();
		
		return new Partida(this.policia, ladron, turno, mapa, orden);
	}
}