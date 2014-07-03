package test.modelo;

import junit.framework.Assert;
import modelo.ladron.ObjetoRobado;
import modelo.ladron.Valor;

import org.junit.Before;
import org.junit.Test;

public class ObjetoRobadoTest {

	private ObjetoRobado objeto;
	private Valor valor;

	@Before
	public void setUp() {
		this.valor = Valor.COMUN;
		this.objeto = new ObjetoRobado(Valor.COMUN);
	}

	@Test
	public void deberiaCrearseOK() {

		Assert.assertNotNull(this.objeto);
		Assert.assertEquals(this.valor, this.objeto.getValor());

	}
}