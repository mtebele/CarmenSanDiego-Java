package carmen.modelo;

import junit.framework.Assert;

import org.junit.Test;

import junit.framework.TestCase;

public class PartidaTest {

	@Test
	public void setUp(){
		Turno turno = new Turno();
		Mapa mapa = new Mapa();
		Policia policia = new Policia();
		Ladron ladron = new Ladron();
		Partida partida = Partida dePolicia(policia);
		
		setearMapa(mapa);
		setearLadron(ladron);
		setearTurno(turno);
		
		Valor
		ObjetoRobado objeto = ObjetoRobado conValor()
		

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
		Pais paisObjetivo = listaDestinos[0];
		
		Integer horasDeViaje = policia.viajar(paisObjetivo);
		
		Assert.assertEquals(partida.verTiempoRestante, (HORAS_TOTAL_JUEGO - horasDeViaje));
	
	}

	@Test
	public void interrogarDeberiaDevolverLaRespuestaCorrecta() {
		
		Turno turno = partida.getTurno();
		Locacion locacion = turno.getLocacion();
		Pais paisActual = locacion.paisActual();
		Local local = paisActual.getLocalFinanzas();
		
		local.setearPista("Se fue a Kamchatka");
		
		Assert.assertEquals(local.responder(), partida.interrogar(local));
		Assert.assertEquals("Se fue a Kamchatka", local.responder());
	}
	
	@Test
	public void interrogarDeberiaConsumir2HorasSiLoVisitaste2Veces() {
		
		int HORAS_TOTAL_JUEGO = 154;
		
		Turno turno = partida.getTurno();
		Locacion locacion = turno.getLocacion();
		Pais paisActual = locacion.paisActual();
		Local local = paisActual.getLocalFinanzas();
		
		partida.interrogar(local);
		parttida.interrogar(local);
		Assert.assertEquals(2, local.vecesVisitados());
		
		Assert.assertEquals(partida.verTiempoRestante, (HORAS_TOTAL_JUEGO - 2));

	}
}