package carmen.modelo;

import junit.framework.Assert;

import org.junit.Test;

import junit.framework.TestCase;

public class TurnoTest {

	@Test
	public void setUp() {
		Mapa mapa = new Mapa();
		Ladron ladron = new Ladron();
		
		// Setear Objeto
		Ciudad ciudadOrigen = new Ciudad(0,0);
		Valor valorObjeto = new Valor();
		valorObjeto.setearCantidadCiudadesDeEscapes(1);
		ObjetoRobado objeto = new ObjetoRobado(ciudadOrigen);
		objeto.setearValor(valorObjeto);
		ladron.robarObjeto(objeto);
		
		// Crear Ciudades
		// Crear Ciudades por las que pasara Ladron
		Ciudad ciudad1 = new Ciudad(10.10);
		// Crear resto de Ciudades
		Ciudad ciudad2 = new Ciudad(5,5);
		Ciudad ciudad3 = new Ciudad(15,15);
		Ciudad ciudad4 = new Ciudad(25,25);

		
		// Setear Locales de las Ciudades por las que pasara Ladron
		Local banco0 = Local conPista("Moneda0");
		Local biblio0 = Local conPista("Lenguaje0");
		Local puerto0 = Local conPista("Bandera0");
		Local banco1 = Local conPista("Moneda1");
		Local biblio1 = Local conPista("Lenguaje1");
		Local puerto1 = Local conPista("Bandera1");
		
		ciudadOrigen.setearLocalFinanzas(banco0);
		ciudadOrigen.setearLocalCultura(biblio0);
		ciudadOrigen.setearLocalTurismo(puerto0);
		ciudad1.setearLocalFinanzas(banco1);
		ciudad1.setearLocalCultura(biblio1);
		ciudad1.setearLocalTurismo(puerto1);
		
		//Setear Mapa
		mapa.setearCiudad(ciudadOrigen);
		mapa.setearCiudad(ciudad1);
		mapa.setearCiudad(ciudad2);
		mapa.setearCiudad(ciudad3);
		mapa.setearCiudad(ciudad4);
		partida.setearMapa(mapa);
		
		
		// Setear Itinerario
		ladron.planearEscape(objeto);
		ladron.verItinerario().agregarAlRecorrido(ciudad1);
		
		// Setear Ladron
		partida.setearLadron(ladron);
		
		// Setear Locacion
		Locacion locacionInicial = Locacion estandoEnCiudad(ciudadOrigen);
		locacionInicial.setearLadron(ladron);
		locacionInicial.setearMapa(mapa);
		locacionInicial.agregarDestino(ciudad1);
		locacionInicial.agregarDestino(ciudad2);
		locacionInicial.agregarDestino(ciudad3);
		locacionInicial.agregarDestino(ciudad4);
		Turno turno = Turno conLocacionInicial(locacionInicial);
	}
	
	@Test
	public void deberianActualizarseBienLasHoras() {
		
		int HORAS_TOTAL_JUEGO = 154;
		
		Assert.assertEquals(HORAS_TOTAL_JUEGO, turno.verTiempoRestante);
		turno.actualizar(3);
		
		Assert.assertEquals(HORAS_TOTAL_JUEGO - 3, turno.verTiempoRestante);
	}
	
	@Test
	public void deberiaSaberseSiSeAcaboElTiempo() {
		
		int HORAS_TOTAL_JUEGO = 154;
		
		Assert.assertEquals(false, turno.seAcaboTiempo());
		turno.actualizar(HORAS_TOTAL_JUEGO);
		
		Assert.assertEquals(true, turno.seAcaboTiempo());
	}
	
	@Test
	public void viajarDeberiaCambiarCiudadActual() {
		
		Velocidad velocidad = new Velocidad();
		
		Assert.assertEquals(ciudadOrigen, turno.ciudadActual());
		turno.viajar(ciudad1, velocidad);
		
		Assert.assertEquals(ciudad1, turno.ciudadActual());
	}
	
	@Test
	public void interrogarDeberiaDevolverRespuestaCorrecta() {
	
		Assert.assertEquals("Moneda0", turno.interrogar(banco0));
	}
	
	@Test
	public void interrogarDeberiaConsumir1HoraSiNuncaFueVisitado() {
		
		int HORAS_TOTAL_JUEGO = 154;
		
		turno.interrogar(banco0);
		Assert.assertEquals((HORAS_TOTAL_JUEGO - 1), turno.verTiempoRestante());
		
	}
	
	@Test
	public void interrogarDeberiaConsumir2HorasSiFueVisitado2Veces(){
		
		int HORAS_TOTAL_JUEGO = 154;
		
		turno.interrogar(banco0);
		turno.interrogar(banco0);
		Assert.assertEquals((HORAS_TOTAL_JUEGO - 2), turno.verTiempoRestante());
		
	}
}