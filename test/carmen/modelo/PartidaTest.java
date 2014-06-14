package carmen.modelo;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class PartidaTest {

	private Policia policia;
	private Partida partida;
	private Ladron ladron;
	private static int HORAS_TOTAL_JUEGO = 154;

	@Before
	public void setUp() {
		// Despues hago de nuevo el setUp desde cero porque tenia metodos que ya borramos.
		this.policia = new Policia();
		this.partida = new Partida(policia);
		this.ladron = new Ladron("nombre", "cabello", "senia", "vehiculo", "hobby", "sexo");
	}

	@Test
	public void partidaDeberiaPerderseSiAgarrasOtroLadron() {
		Ladron ladronIncorrecto = new Ladron("nombre", "cabello", "senia", "vehiculo", "hobby", "sexo");

		partida.emitirOrden(ladron);
		partida.atraparLadron(ladronIncorrecto);

		Assert.assertEquals(policia.getCantidadArrestos(), 0);
	}

	@Test
	public void partidaDeberiaPerderseSiSeAcabaElTiempo() {
		// TODO: metodo actualizar
		partida.actualizar(HORAS_TOTAL_JUEGO);

		Assert.assertEquals(policia.getCantidadArrestos(), 0);
	}

	@Test
	public void partidaDeberiaGanarseSiSeAgarraAlLadronCorrecto() {
		partida.emitirOrden(ladron);
		partida.atraparLadron(ladron);

		Assert.assertEquals(policia.getCantidadArrestos(), 1);
	}

	@Test
	public void viajarDeberiaConsumirTiempo() {

		ArrayList listaDestinos = partida.verDestinos();
		Ciudad ciudadObjetivo = (Ciudad) listaDestinos.get(0);

		partida.viajar(ciudadObjetivo);

		Assert.assertTrue(partida.verTiempoRestante() < HORAS_TOTAL_JUEGO);

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

		Turno turno = partida.getTurno();
		Locacion locacion = turno.getLocacion(); // Es correcto?
		Ciudad ciudadActual = locacion.ciudadActual();
		Local local = ciudadActual.getLocalFinanzas(); // Es correcto?

		partida.interrogar(local);
		partida.interrogar(local);
		Assert.assertEquals(2, local.vecesVisitado());

		Assert.assertEquals(partida.verTiempoRestante(), (HORAS_TOTAL_JUEGO - 2));

	}
}