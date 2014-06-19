package carmen.modelo;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class PartidaTest {
	
	private Partida partida;
	private Policia policia;
	private Turno turno;
	private Ladron ladron;
	private String MENSAJE_NO_ESTA_LADRON = "Lo siento, nunca he visto a esa persona.";
	private int HORAS_TOTAL_JUEGO = 154;
	
	@Before
	public void setUp() {

		//Creo Coordenadas
		Coordenada ubicacion0 = new Coordenada(0,0);
		Coordenada ubicacion1 = new Coordenada(5,5);
		Coordenada ubicacion2 = new Coordenada(10,10);
		Coordenada ubicacion3 = new Coordenada(15,15);
		Coordenada ubicacion4 = new Coordenada(20,20);
		
		//Creo Ciudades
		Ciudad ciudad0 = new Ciudad(ubicacion0);
		Ciudad ciudad1 = new Ciudad(ubicacion1);
		Ciudad ciudad2 = new Ciudad(ubicacion2);
		Ciudad ciudad3 = new Ciudad(ubicacion3);
		Ciudad ciudad4 = new Ciudad(ubicacion4);
		
		//Creo Locales
		Local local0 = new Local(NombreLocal.BIBLIOTECA);
		local0.setearPista("Queria escalar el Monte Everest.");
		Local local1 = new Local(NombreLocal.BANCO);
		local1.setearPista("Queria cambiar su dinero a yenes.");
		Local local2 = new Local(NombreLocal.BOLSA);
		local2.setearPista("Ansiaba conocer verdaderos gauchos.");
		Local local3 = new Local(NombreLocal.AEROPUERTO);
		local3.setearPista("Se marcho en un barco que flameaba una bandera blanca y roja.");
		
		ciudad0.agregarLocal(local0);
		ciudad1.agregarLocal(local1);
		ciudad2.agregarLocal(local2);
		ciudad3.agregarLocal(local3);
		
		
		//Creo Mapa
		Mapa mapa = new Mapa();
		mapa.agregarCiudad(ciudad0);
		mapa.agregarCiudad(ciudad1);
		mapa.agregarCiudad(ciudad2);
		mapa.agregarCiudad(ciudad3);
		mapa.agregarCiudad(ciudad4);
		
		//Creo ObjetoRobado
		ObjetoRobado objeto = new ObjetoRobado(Valor.COMUN, ciudad0);
		
		//Creo Ladron
		Perfil perfil = new Perfil ("Carmen SanDiego",Sexo.FEMENINO,Cabello.ROJO,Senia.ANILLO,Vehiculo.LIMUSINA,Hobby.ALPINISMO);
		Ladron ladron= new Ladron(perfil);
		ladron.robarObjeto(objeto);
		ladron.planearNuevoDestino(ciudad1);
		ladron.planearNuevoDestino(ciudad2);
		ladron.planearNuevoDestino(ciudad3);
		this.ladron = ladron;
		
		//Creo Locacion
		Locacion locacionInicial = new Locacion(mapa, ciudad0, ladron);
		locacionInicial.agregarDestino(ciudad1);
		locacionInicial.agregarDestino(ciudad2);
		locacionInicial.agregarDestino(ciudad3);
		locacionInicial.agregarDestino(ciudad4);
		
		//Creo Turno
		Turno turno = new Turno(locacionInicial);
		this.turno = turno;
		
		//Creo Policia
		Policia policia = new Policia();
		policia.setTurno(turno);
		this.policia = policia;
		
		//Creo OrdenDeArresto
		OrdenDeArresto orden = new OrdenDeArresto();
		orden.agregarLadronABaseDeDatos(ladron);
		
		//Creo Partida
		this.partida = new Partida(policia, ladron, turno, orden);
	}

	@Test
	public void partidaDeberiaPerderseSiAgarrasOtroLadron() {
		this.setUp();
		
		Perfil perfilLadron = new Perfil("Josepha", Sexo.FEMENINO, Cabello.CASTANIO, Senia.CICATRIZ, Vehiculo.DESCAPOTABLE, Hobby.NATACION);
		Ladron ladronIncorrecto = new Ladron(perfilLadron);

		this.partida.emitirOrden(ladronIncorrecto);
		this.partida.atraparLadron();

		Assert.assertEquals(this.policia.getCantidadArrestos(), 0);
	}

	@Test
	public void partidaDeberiaPerderseSiSeAcabaElTiempo() {
		this.setUp();
		
		this.turno.actualizar(this.HORAS_TOTAL_JUEGO);

		Assert.assertEquals(this.policia.getCantidadArrestos(), 0);
	}
	
	@Test
	public void partidaDeberiaPerderseSiNoSeEmiteOrden() {
		this.setUp();
		
		this.partida.atraparLadron();

		Assert.assertEquals(this.policia.getCantidadArrestos(), 0);
	}

	@Test
	public void partidaDeberiaGanarseSiSeAgarraAlLadronCorrecto() {
		this.setUp();
		
		this.partida.emitirOrden(this.ladron);
		this.partida.atraparLadron();

		Assert.assertEquals(this.policia.getCantidadArrestos(), 1);
	}

	@Test
	public void interrogarEnCiudadQuePasoLadronDeberiaDevolverRespuestaCorrecta() {
		this.setUp();
		
		// Ladron viaja de la ciudad0 a la ciudad1.
		try {
			this.turno.getLocacion().getLadron().escapar();
		} catch (LadronNoPlaneoEscapeException e) {
			Assert.fail();
		}
		
		Local local0 = this.turno.getLocales().get(0);
		Assert.assertEquals("Queria escalar el Monte Everest.", this.partida.interrogar(local0));
		
		//Viajo a pais por donde paso ladron
		Ciudad destinoConLadron = this.turno.getDestinos().get(0);
		this.partida.viajar(destinoConLadron);

		
		Local local1 = this.turno.getLocales().get(0);
		Assert.assertEquals("Queria cambiar su dinero a yenes.", this.partida.interrogar(local1));
	}
	
	@Test
	public void interrogarEnCiudadSinLadronDeberiaDevolverRespuestaPorDefecto() {
		this.setUp();
		
		//Viajo a pais sin ladron
		Ciudad destinoSinLadron = this.turno.getDestinos().get(1);
		this.partida.viajar(destinoSinLadron);
		
		Local local = this.turno.getLocales().get(0);
		
		Assert.assertEquals(this.MENSAJE_NO_ESTA_LADRON, this.partida.interrogar(local));
	}

	@Test
	public void interrogarDeberiaAtraparLadronSiLadronTerminoItinerario() {
		this.setUp();
		
		// Ladron viaja de ciudad en ciudad hasta llegar a la ultima del recorrido.
		try {
			for ( int i=0; i<3; i++ ) {
				this.turno.getLocacion().getLadron().escapar();
			}
		} catch (LadronNoPlaneoEscapeException e) {
			Assert.fail();
		}
		
		// Viajamos de ciudad en ciudad hasta llegar adonde esta el ladron.
		// En la lista de destinos, la ciudad donde fue el ladron es siempre la primera.
		for ( int j=0; j<3; j++ ) {
			this.partida.viajar( this.partida.verDestinos().get(0) );
		}
		
		this.partida.emitirOrden(this.ladron);
		this.partida.interrogar( this.partida.ciudadActual().getLocales().get(0) );

		Assert.assertEquals(this.policia.getCantidadArrestos(), 1);
	}
	
	
	@Test
	public void ciudadActualDeberiaCambiarAlViajar() {
		this.setUp();
		
		Ciudad ciudadDestino = this.partida.verDestinos().get(0);		
		this.partida.viajar( ciudadDestino );
		
		Assert.assertEquals(ciudadDestino, this.partida.ciudadActual());
	}
}