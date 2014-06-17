package carmen.modelo;

import junit.framework.Assert;

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
		this.objeto = new ObjetoRobado(Valor.COMUN, ciudad);
	}
	
	@Test
	public void deberiaCrearseOK() {
		this.setUp();
		
		Assert.assertNotNull(this.objeto);
		Assert.assertEquals(this.valor, this.objeto.getValor());
		Assert.assertEquals(this.ciudad, this.objeto.ciudadOrigen());
	}
}