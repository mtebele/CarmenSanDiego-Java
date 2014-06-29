package test.modelo;

import junit.framework.Assert;
import modelo.ladron.ObjetoRobado;
import modelo.ladron.Valor;
import modelo.mapa.Ciudad;
import modelo.mapa.Coordenada;

import org.junit.Before;
import org.junit.Test;

public class ObjetoRobadoTest {

	private ObjetoRobado objeto;
	private Ciudad ciudad;
	private Valor valor;

	@Before
	public void setUp() {
		this.ciudad = new Ciudad(new Coordenada(10, 10));
		this.valor = Valor.COMUN;
		this.objeto = new ObjetoRobado(Valor.COMUN);
	}

	@Test
	public void deberiaCrearseOK() {

		Assert.assertNotNull(this.objeto);
		Assert.assertEquals(this.valor, this.objeto.getValor());

	}
}