package test.modelo;

import modelo.Tiempo;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TiempoTest {

	private Tiempo tiempo;

	@Before
	public void setUp() {
		this.tiempo = new Tiempo();
	}

	@Test
	public void deberiaCrearseOK() {

		Assert.assertEquals(7, this.tiempo.horaActual());
		Assert.assertEquals(154, this.tiempo.horasRestantes());
	}

	@Test
	public void deberiaTranscurrirUnaHora() {

		this.tiempo.transcurrirHoras(1);
		Assert.assertEquals(8, this.tiempo.horaActual());
		Assert.assertEquals(153, this.tiempo.horasRestantes());
	}

	@Test
	public void deberiaTranscurrirCincoHoras() {

		this.tiempo.transcurrirHoras(5);
		Assert.assertEquals(12, this.tiempo.horaActual());
		Assert.assertEquals(149, this.tiempo.horasRestantes());
	}

	@Test
	public void deberiaPasarLaNocheSiendoLas23hs() {

		this.tiempo.transcurrirHoras(16); // Se hacen las 23, tiene que dormir 8 horas.
		Assert.assertEquals(7, this.tiempo.horaActual());
		Assert.assertEquals(130, this.tiempo.horasRestantes());
	}

	@Test
	public void noDeberiaPasarLaNocheSiendoLas22hs() {

		this.tiempo.transcurrirHoras(15);
		Assert.assertEquals(22, this.tiempo.horaActual());
	}

	@Test
	public void deberiaNoQuedarTiempoSiPasaronTodasLasHoras() {

		this.tiempo.transcurrirHoras(154);
		Assert.assertEquals(false, this.tiempo.quedaTiempo());
		Assert.assertEquals(17, this.tiempo.horaActual());
		Assert.assertEquals(0, this.tiempo.horasRestantes());
	}

	@Test
	public void deberiaQuedarTiempoSiNoPasaronTodasLasHoras() {

		this.tiempo.transcurrirHoras(153);
		Assert.assertEquals(1, this.tiempo.horasRestantes());
		Assert.assertEquals(16, this.tiempo.horaActual());
		Assert.assertEquals(true, this.tiempo.quedaTiempo());
	}

}