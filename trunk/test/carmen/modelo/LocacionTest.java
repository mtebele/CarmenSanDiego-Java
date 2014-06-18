package carmen.modelo;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.Before;

public class LocacionTest {
	
	private String MENSAJE_NO_ESTA_LADRON = "Lo siento, nunca he visto a esa persona.";
	private Locacion locacion;
	private Ladron ladron;
	
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
		Local local2 = new Local(NombreLocal.AEROPUERTO);
		ciudad0.agregarLocal(local0);
		ciudad1.agregarLocal(local1);
		ciudad2.agregarLocal(local2);
		
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
		this.ladron= new Ladron(perfil);
		ladron.robarObjeto(objeto);
		ladron.planearNuevoDestino(ciudad1);
		ladron.planearNuevoDestino(ciudad2);
		ladron.planearNuevoDestino(ciudad3);
		
		//Creo Locacion
		Locacion locacion = new Locacion(mapa, ciudad0, ladron);
		locacion.agregarDestino(ciudad1);
		locacion.agregarDestino(ciudad2);
		locacion.agregarDestino(ciudad3);
		locacion.agregarDestino(ciudad4);
		this.locacion = locacion;

	}
	
	@Test
	public void interrogarEnCiudadQuePasoLadronDeberiaDevolverRespuestaCorrecta() {
		this.setUp();
		
		// Ladron viaja de la ciudad0 a la ciudad1.
		try {
		this.ladron.escapar();
		} catch (LadronNoPlaneoEscapeException e) {
			Assert.fail();
		}
		
		// Una vez que escapo, en la ciudad0 saben a donde se fue. 
		Local local0 = this.locacion.getLocales().get(0);
		Assert.assertEquals("Queria escalar el Monte Everest.", this.locacion.interrogar(local0));
		
		// Ladron viaja de la ciudad1 a la ciudad2.
		try {
		this.ladron.escapar();
		} catch (LadronNoPlaneoEscapeException e) {
			Assert.fail();
		}
		
		Ciudad destinoConLadron = this.locacion.getDestinos().get(0);
		try {
			this.locacion.viajar(destinoConLadron);
		} catch (LadronNoPlaneoEscapeException e) {
			Assert.fail();
		}
		
		// Una vez que escapo, en la ciudad1 saben a donde se fue.
		Local local1 = this.locacion.getLocales().get(0);
		Assert.assertEquals("Queria cambiar su dinero a yenes.", this.locacion.interrogar(local1));
	}
	
	@Test
	public void interrogarEnCiudadSinLadronDeberiaDevolverRespuestaPorDefecto() {
		this.setUp();
		
		// Viajo a pais sin ladron.
		Ciudad destinoSinLadron = this.locacion.getDestinos().get(1);
		try {
			this.locacion.viajar(destinoSinLadron);
		} catch (LadronNoPlaneoEscapeException e) {
			Assert.fail();
		}
		
		Local local2 = this.locacion.getLocales().get(0);
		Assert.assertEquals(this.MENSAJE_NO_ESTA_LADRON, this.locacion.interrogar(local2));
	}
	
	@Test
	public void viajarDeberiaCambiarCiudadActual() {
		this.setUp();

		Ciudad destino = this.locacion.getDestinos().get(0);
		try {
			this.locacion.viajar(destino);
		} catch (LadronNoPlaneoEscapeException e) {
			Assert.fail();
		}

		Assert.assertEquals(destino, this.locacion.ciudadActual());
	}
	
	@Test
	public void siempreDeberiaHaber4DestinosPosibles() {
		this.setUp();
		
		Assert.assertEquals(4, this.locacion.getDestinos().size());
		
		try {
			this.locacion.viajar(this.locacion.getDestinos().get(0));
		} catch (LadronNoPlaneoEscapeException e) {
			Assert.fail();
		}
		Assert.assertEquals(4, this.locacion.getDestinos().size());	
	}
}