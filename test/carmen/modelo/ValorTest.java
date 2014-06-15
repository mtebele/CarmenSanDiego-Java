package carmen.modelo;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ValorTest {
	private Valor valor;

	@Before
	public void setUp() {
		String valor = "Valioso";
		int cantidadEscapes = 5;
		this.valor = new Valor(valor, cantidadEscapes);
	}

	@Test
	public void testValorSeCreaOK() {
		this.setUp();
		Assert.assertNotNull(this.valor);
		Assert.assertEquals(this.valor.getValor(), "Valioso");
		Assert.assertEquals(this.valor.getCantidadDeEscapes(), 5);
	}
}