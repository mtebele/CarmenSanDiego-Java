package carmen.modelo;
import org.junit.Test;

import junit.framework.Assert;

public class CoordenadaTest {
	
	@Test
	public void testCoordenadaSeCreaOK() {
		Coordenada coord = new Coordenada(55,55);
		Assert.assertNotNull(coord);
		Assert.assertEquals((int)coord.getLatitud(), 55);
		Assert.assertEquals((int)coord.getLongitud(), 55);
	}

	@Test
	public void testDistanciaLargaEntreCoordenadas() {
		Coordenada buenosAires = new Coordenada(-58,-34);
        Coordenada tokio = new Coordenada(139,35);
        int distancia = buenosAires.distanciaAOtraCoordenada(tokio);
        Assert.assertEquals (distancia,18455);       
	}
	
	@Test
	public void testDistanciasPositivas() {
		Coordenada roma = new Coordenada (12,41);
		Coordenada tokio = new Coordenada(139,35);
		int distancia = roma.distanciaAOtraCoordenada(tokio);
		Assert.assertEquals (distancia,9980);
	}
	
	@Test
	public void testDistanciasMixtas() {
		Coordenada montreal = new Coordenada(-73,45);
		Coordenada pretoria = new Coordenada(28,-25);
		int distancia = montreal.distanciaAOtraCoordenada(pretoria);
		Assert.assertEquals (distancia,12776);	
	}	
}