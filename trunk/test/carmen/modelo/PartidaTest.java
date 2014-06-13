package carmen.modelo;

import junit.framework.Assert;

import org.junit.Test;

import junit.framework.TestCase;

public class PartidaTest {

	@Test
	public void setUp(){
		Mapa mapa = new Mapa();
		Policia policia = new Policia();
		Ladron ladron = new Ladron();
		Partida partida = new Partida(policia);
		
		// Setear Objeto
		Ciudad ciudadOrigen = new Ciudad conUbicacion(0,0);
		Valor valorObjeto = new Valor();
		valorObjeto.setearCantidadCiudadesDeEscapes(4);
		ObjetoRobado objeto = new ObjetoRobado(ciudadOrigen);
		objeto.setearValor(valorObjeto);
		ladron.robarObjeto(objeto);
		
		// Crear Ciudades
		// Crear Ciudades por las que pasara Ladron
		Ciudad ciudad1 = Ciudad conUbicacion(10.10);
		Ciudad ciudad2 = Ciudad conUbicacion(20,20);
		Ciudad ciudad3 = Ciudad conUbicacion(30,30);
		Ciudad ciudad4 = Ciudad conUbicacion(40,40);
		// Crear resto de Ciudades
		Ciudad ciudad5 = Ciudad conUbicacion(5,5);
		Ciudad ciudad6 = Ciudad conUbicacion(15,15);
		Ciudad ciudad7 = Ciudad conUbicacion(25,25);
		Ciudad ciudad8 = Ciudad conUbicacion(35,35);
		Ciudad ciudad9 = Ciudad conUbicacion(45,45);
		Ciudad ciudad10 = Ciudad conUbicacion(50,50);
		Ciudad ciudad11 = Ciudad conUbicacion(55,55);
		Ciudad ciudad12 = Ciudad conUbicacion(60,60);
		Ciudad ciudad13 = Ciudad conUbicacion(65,65);
		Ciudad ciudad14 = Ciudad conUbicacion(70,70);
		Ciudad ciudad15 = Ciudad conUbicacion(75,75);
		Ciudad ciudad16 = Ciudad conUbicacion(80,80);
		
		// Setear Locales de las Ciudades por las que pasara Ladron
		Local banco0 = Local conPista("Moneda0");
		Local biblio0 = Local conPista("Lenguaje0");
		Local puerto0 = Local conPista("Bandera0");
		Local banco1 = Local conPista("Moneda1");
		Local biblio1 = Local conPista("Lenguaje1");
		Local puerto1 = Local conPista("Bandera1");
		Local banco2 = Local conPista("Moneda2");
		Local biblio2 = Local conPista("Lenguaje2");
		Local puerto2 = Local conPista("Bandera2");
		Local banco3 = Local conPista("Moneda3");
		Local biblio3 = Local conPista("Lenguaje3");
		Local puerto3 = Local conPista("Bandera3");
		
		ciudadOrigen.setearLocalFinanzas(banco0);
		ciudadOrigen.setearLocalCultura(biblio0);
		ciudadOrigen.setearLocalTurismo(puerto0);
		ciudad1.setearLocalFinanzas(banco1);
		ciudad1.setearLocalCultura(biblio1);
		ciudad1.setearLocalTurismo(puerto1);
		ciudad2.setearLocalFinanzas(banco2);
		ciudad2.setearLocalCultura(biblio2);
		ciudad2.setearLocalTurismo(puerto2);
		ciudad3.setearLocalFinanzas(banco3);
		ciudad3.setearLocalCultura(biblio3);
		ciudad3.setearLocalTurismo(puerto3);
		
		//Setear Mapa
		mapa.setearCiudad(ciudadOrigen);
		mapa.setearCiudad(ciudad1);
		mapa.setearCiudad(ciudad2);
		mapa.setearCiudad(ciudad3);
		mapa.setearCiudad(ciudad4);
		mapa.setearCiudad(ciudad5);
		mapa.setearCiudad(ciudad6);
		mapa.setearCiudad(ciudad7);
		mapa.setearCiudad(ciudad8);
		mapa.setearCiudad(ciudad9);
		mapa.setearCiudad(ciudad10);
		mapa.setearCiudad(ciudad11);
		mapa.setearCiudad(ciudad12);
		mapa.setearCiudad(ciudad13);
		mapa.setearCiudad(ciudad14);
		mapa.setearCiudad(ciudad15);
		mapa.setearCiudad(ciudad16);
		partida.setearMapa(mapa);
		
		
		// Setear Itinerario
		ladron.planearEscape(objeto);
		ladron.verItinerario().agregarAlRecorrido(ciudad1);
		ladron.verItinerario().agregarAlRecorrido(ciudad2);
		ladron.verItinerario().agregarAlRecorrido(ciudad3);
		ladron.verItinerario().agregarAlRecorrido(ciudad4);
		
		// Setear Ladron
		partida.setearLadron(ladron);
		
		// Setear Locacion
		Locacion locacionInicial = Locacion estandoEnCiudad(ciudadOrigen);
		locacionInicial.setearLadron(ladron);
		locacionInicial.setearMapa(mapa);
		locacionInicial.agregarDestino(ciudad1);
		locacionInicial.agregarDestino(ciudad5);
		locacionInicial.agregarDestino(ciudad6);
		locacionInicial.agregarDestino(ciudad7);
		Turno turno = Turno conLocacionInicial(locacionInicial);
		
		// Setear Turno
		partida.setearTurno(turno);

	}
	
	@Test
	public void partidaDeberiaPerderseSiAgarrasOtroLadron() {
		
		Ladron ladronIncorrecto = new Ladron();
	
		partida.emitirOrden(ladron);
		partida.atraparLadron(ladronIncorrecto);
		
		Assert.assertEquals(policia.getCantArrestos(), 0);
	}
	
	@Test
	public void partidaDeberiaPerserseSiSeAcabaTiempo() {
		
		int HORAS_TOTAL_JUEGO = 154;
		
		partida.actualizar(HORAS_TOTAL_JUEGO);
		
		Assert.assertEquals(policia.getCantArrestos(), 0);
	}
	
	@Test
	public void partidaDeberiaGanarseSiSeAgarraAlLadronCorrecto() {
		
		partida.emitirOrden(ladron);
		partida.atraparLadron(ladron);
		
		Assert.assertEquals(policia.getCantArrestos(), 1);
	}
	
	@Test
	public void viajarDeberiaConsumirTiempo() {
		
		int HORAS_TOTAL_JUEGO = 154;
		
		ArrayList listaDestinos = partida.verDestinos();
		Ciudad ciudadObjetivo = listaDestinos[0];
		
		partida.viajar(ciudadObjetivo);
		
		Assert.assertTrue(partida.verTiempoRestante < HORAS_TOTAL_JUEGO);
	
	}

	@Test
	public void interrogarDeberiaDevolverLaRespuestaCorrecta() {
		
		Turno turno = partida.getTurno();
		Locacion locacion = turno.getLocacion();
		Ciudad ciudadActual = locacion.ciudadActual();
		Local local = ciudadActual.getLocalFinanzas();
		
		local.setearPista("Se fue a Kamchatka");
		
		Assert.assertEquals(local.responder(), partida.interrogar(local));
		Assert.assertEquals("Se fue a Kamchatka", local.responder());
	}
	
	@Test
	public void interrogarDeberiaConsumir2HorasSiLoVisitaste2Veces() {
		
		int HORAS_TOTAL_JUEGO = 154;
		
		Turno turno = partida.getTurno();
		Locacion locacion = turno.getLocacion();
		Ciudad ciudadActual = locacion.ciudadActual();
		Local local = ciudadActual.getLocalFinanzas();
		
		partida.interrogar(local);
		partida.interrogar(local);
		Assert.assertEquals(2, local.vecesVisitado());
		
		Assert.assertEquals(partida.verTiempoRestante, (HORAS_TOTAL_JUEGO - 2));

	}
}