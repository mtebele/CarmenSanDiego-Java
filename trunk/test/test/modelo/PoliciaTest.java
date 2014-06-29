package test.modelo;

import java.util.List;

import modelo.Turno;
import modelo.excepciones.LadronNoPlaneoEscapeException;
import modelo.ladron.Ladron;
import modelo.ladron.ObjetoRobado;
import modelo.ladron.Valor;
import modelo.ladron.perfil.Cabello;
import modelo.ladron.perfil.Hobby;
import modelo.ladron.perfil.Perfil;
import modelo.ladron.perfil.Senia;
import modelo.ladron.perfil.Sexo;
import modelo.ladron.perfil.Vehiculo;
import modelo.mapa.Ciudad;
import modelo.mapa.Coordenada;
import modelo.mapa.Locacion;
import modelo.mapa.Local;
import modelo.mapa.Mapa;
import modelo.mapa.TipoLocal;
import modelo.policia.Policia;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class PoliciaTest {

	private Policia policia;
	private Turno turno;
	private Ladron ladron;

	@Before
	public void setUp() {

		// Creo Coordenadas
		Coordenada ubicacion0 = new Coordenada(0, 0);
		Coordenada ubicacion1 = new Coordenada(5, 5);
		Coordenada ubicacion2 = new Coordenada(10, 10);
		Coordenada ubicacion3 = new Coordenada(15, 15);
		Coordenada ubicacion4 = new Coordenada(20, 20);

		// Creo Ciudades
		Ciudad ciudad0 = new Ciudad(ubicacion0);
		Ciudad ciudad1 = new Ciudad(ubicacion1);
		Ciudad ciudad2 = new Ciudad(ubicacion2);
		Ciudad ciudad3 = new Ciudad(ubicacion3);
		Ciudad ciudad4 = new Ciudad(ubicacion4);

		// Creo Locales
		Local local0 = new Local(TipoLocal.BIBLIOTECA);
		local0.setearPista("Queria escalar el Monte Everest.");
		Local local1 = new Local(TipoLocal.BANCO);
		local1.setearPista("Queria cambiar su dinero a yenes.");
		Local local2 = new Local(TipoLocal.BOLSA);
		ciudad0.agregarLocal(local0);
		ciudad1.agregarLocal(local1);
		ciudad2.agregarLocal(local2);

		// Creo Mapa
		Mapa mapa = new Mapa();
		mapa.agregarCiudad(ciudad0);
		mapa.agregarCiudad(ciudad1);
		mapa.agregarCiudad(ciudad2);
		mapa.agregarCiudad(ciudad3);
		mapa.agregarCiudad(ciudad4);

		// Creo ObjetoRobado
		ObjetoRobado objeto = new ObjetoRobado(Valor.COMUN);

		// Creo Ladron
		Perfil perfil = new Perfil("Carmen SanDiego", Sexo.FEMENINO, Cabello.ROJO, Senia.ANILLO, Vehiculo.LIMUSINA,
				Hobby.ALPINISMO);
		this.ladron = new Ladron(perfil);
		ladron.planearNuevoDestino(ciudad0);
		ladron.planearNuevoDestino(ciudad1);
		ladron.planearNuevoDestino(ciudad2);
		ladron.planearNuevoDestino(ciudad3);
		ladron.robarObjeto(objeto);

		// Creo Locacion
		Locacion locacionInicial = new Locacion(mapa, ciudad0, ladron);
		locacionInicial.agregarDestino(ciudad1);
		locacionInicial.agregarDestino(ciudad2);
		locacionInicial.agregarDestino(ciudad3);
		locacionInicial.agregarDestino(ciudad4);

		// Creo Turno
		Turno turno = new Turno(locacionInicial);
		this.turno = turno;

		// Creo Policia
		this.policia = new Policia("John");
		this.policia.setTurno(turno);
	}

	@Test
	public void policiaDeberiaIniciarComoNovato() {

		Assert.assertEquals(0, policia.getCantidadArrestos());
		Assert.assertEquals("Novato", policia.getRango().getNombre());
	}

	@Test
	public void policiaDeberiaAscenderDeRango() {

		for (int i = 0; i < 5; i++) {
			policia.realizarArresto();
		}
		Assert.assertEquals("Detective", policia.getRango().getNombre());

		for (int i = 0; i < 5; i++) {
			policia.realizarArresto();
		}
		Assert.assertEquals("Investigador", policia.getRango().getNombre());

		for (int i = 0; i < 10; i++) {
			policia.realizarArresto();
		}
		Assert.assertEquals("Sargento", policia.getRango().getNombre());
	}

	@Test
	public void policiaDeberiaTenerDeterminadaVelocidadAlAscenderDeRango() {

		Assert.assertEquals(900, policia.getRango().getVelocidad().getKmPorHora());

		for (int i = 0; i < 5; i++) {
			policia.realizarArresto();
		}
		Assert.assertEquals(1100, policia.getRango().getVelocidad().getKmPorHora());

		for (int i = 0; i < 5; i++) {
			policia.realizarArresto();
		}
		Assert.assertEquals(1300, policia.getRango().getVelocidad().getKmPorHora());

		for (int i = 0; i < 10; i++) {
			policia.realizarArresto();
		}
		Assert.assertEquals(1500, policia.getRango().getVelocidad().getKmPorHora());
	}

	@Test
	public void policiaDeberiaCambiarDeLugarAlViajar() {

		List<Ciudad> listaDestinos = policia.verDestinos();
		Ciudad ciudadObjetivo = listaDestinos.get(0);

		try {
			policia.viajar(ciudadObjetivo);
		} catch (LadronNoPlaneoEscapeException e) {
			Assert.fail();
		}

		Ciudad ciudadActual = policia.ciudadActual();

		Assert.assertEquals(ciudadObjetivo, ciudadActual);
	}

	@Test
	public void interrogarDeberiaDevolverLaRespuestaCorrecta() {

		// Ladron viaja de la ciudad0 a la ciudad1.
		try {
			this.ladron.escapar();
		} catch (LadronNoPlaneoEscapeException e) {
			Assert.fail();
		}

		Local local0 = this.turno.getLocales().get(0);
		Assert.assertEquals("Queria escalar el Monte Everest.", this.turno.interrogar(local0));

		// Viajo a pais por donde paso ladron
		Ciudad destinoConLadron = this.turno.getDestinos().get(0);

		// Ladron viaja de la ciudad1 a la ciudad2.
		try {
			this.ladron.escapar();
		} catch (LadronNoPlaneoEscapeException e) {
			Assert.fail();
		}

		try {
			this.turno.viajar(destinoConLadron, this.policia.getRango().getVelocidad());
		} catch (LadronNoPlaneoEscapeException e) {
			assert false;
		}

		Local local2 = this.turno.getLocales().get(0);
		Assert.assertEquals(local2.responder(), policia.interrogar(local2));
		Assert.assertEquals("Queria cambiar su dinero a yenes.", local2.responder());
	}
}
