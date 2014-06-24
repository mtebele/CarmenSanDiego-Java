package carmen.modelo;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import carmen.modelo.ladron.ObjetoRobado;
import carmen.modelo.ladron.Valor;
import carmen.modelo.mapa.Ciudad;
import carmen.modelo.mapa.Coordenada;

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
		this.setUp();
		
		Assert.assertNotNull(this.objeto);
		Assert.assertEquals(this.valor, this.objeto.getValor());
	
	}
}