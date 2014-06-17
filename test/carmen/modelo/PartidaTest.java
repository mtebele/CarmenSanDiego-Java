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
		Perfil perfilLadron = new Perfil("Mark", Sexo.MASCULINO, Cabello.ROJO, Senia.TATUAJE, Vehiculo.MOTO, Hobby.ALPINISMO);
		this.ladron = new Ladron(perfilLadron);
		Mapa mapa = new Mapa();
		Locacion locacionInicial = new Locacion(mapa, new Ciudad(new Coordenada(500,500)), this.ladron);
		Turno turno = new Turno(locacionInicial);		
		OrdenDeArresto orden = new OrdenDeArresto();
		this.partida = new Partida(policia, ladron, turno, mapa, orden);
		
	}

	@Test
	public void partidaDeberiaPerderseSiAgarrasOtroLadron() {
		Perfil perfilLadron = new Perfil("Josepha", Sexo.FEMENINO, Cabello.CASTANIO, Senia.CICATRIZ, Vehiculo.DESCAPOTABLE, Hobby.NATACION);
		Ladron ladronIncorrecto = new Ladron(perfilLadron);

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

		ArrayList<Ciudad> listaDestinos = partida.verDestinos();
		Ciudad ciudadObjetivo = listaDestinos.get(0);

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