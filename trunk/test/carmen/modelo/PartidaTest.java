package carmen.modelo;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class PartidaTest {

	@Before
	public void setUp() {
		// Despues hago de nuevo el setUp desde cero porque tenia metodos que ya
		// borramos.
		Policia unPolicia = new Policia();
		Partida partida = new Partida(unPolicia);
	}

	@Test
	public void partidaDeberiaPerderseSiAgarrasOtroLadron() {
		Ladron ladronIncorrecto = new Ladron("nombre", "cabello", "senia", "vehiculo", "hobby", "sexo");

		partida.emitirOrden(ladron);
		partida.atraparLadron(ladronIncorrecto);

		Assert.assertEquals(unPolicia.getCantArrestos(), 0);
	}

	@Test
	public void partidaDeberiaPerserseSiSeAcabaTiempo() {
		int HORAS_TOTAL_JUEGO = 154;

		partida.actualizar(HORAS_TOTAL_JUEGO);

		Assert.assertEquals(unPolicia.getCantArrestos(), 0);
	}

	@Test
	public void partidaDeberiaGanarseSiSeAgarraAlLadronCorrecto() {
		partida.emitirOrden(ladron);
		partida.atraparLadron(ladron);

		Assert.assertEquals(unPolicia.getCantArrestos(), 1);
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