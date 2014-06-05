package juego.modelo;

import junit.framework.Assert;

import org.junit.Test;

public class PoliciaTest {
	
	@Test
	public void policiaDeberiaSerAscendido() {
		Policia policia = new PoliciaNovato();
		String rangoNovato = policia.rango()
		Assert.assertEquals("Novato", rangoNovato);
		
		for(Integer i=0;i<5;i++) {
			policia.realizarArresto();
		}
		String rangoDetective = policia.rango();
		Assert.assertEquals("Detective", rangoDetective);
	}
	
	@Test
	public void policiaDeberiaCambiarDeLugarAlViajar() {
		Policia policia = new PoliciaNovato();
		Pais argentina = new Pais();
		Pais alemania = new Pais();
		policia.nuevaPartida();
		
		policia.viajar(argentina);
		Assert.assertEquals(argentina, policia.paisActual());
		
		policia.viajar(alemania);
		Assert.assertEquals(alemania, policia.paisActual());	
	}
	
}

public class LadronTest {
	
	@Test
	public void ladronDeberiaRecorrer4PaisesEnNovato() {
		Policia novato = new PoliciaNovato();
		Partida partida = novato.nuevaPartida();
		Ladron ladron = partida.ladronBuscado();
		ItinerarioDelLadron itinerario = ladron.itinerario();
		
		Assert.assertEquals(5, itinerario.cantPaises);
	}
	
}

public class ObjetoTest {
	
	@Test
	public void objetoDeberiaSerMuyValiosoEnSargento() {
		Policia sargento = new PoliciaSargento();
		Partida partida = sargento.nuevaPartida();
		ObjetoRobado objeto = partida.objetoRobado();
		
		Assert.assertEquals("Muy valioso", objeto.valor());
	}
	
}
