package carmen.modelo;

import junit.framework.Assert;

import org.junit.Test;

import junit.framework.TestCase;

public class TurnoTest {

	@Before
	public void setUp() {

		// Despues rehago el setUp cuando tengamos mejor definidos los metodos.

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
	public void interrogarDeberiaConsumir2HorasSiFueVisitado2Veces() {

		int HORAS_TOTAL_JUEGO = 154;

		turno.interrogar(banco0);
		turno.interrogar(banco0);
		Assert.assertEquals((HORAS_TOTAL_JUEGO - 2), turno.verTiempoRestante());

	}
}