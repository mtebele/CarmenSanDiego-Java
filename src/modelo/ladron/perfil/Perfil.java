package modelo.ladron.perfil;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Perfil {

	private String nombre;
	private Sexo sexo;
	private Cabello cabello;
	private Senia senia;
	private Hobby hobby;
	private Vehiculo vehiculo;

	public Perfil(String nombre, Sexo sexo, Cabello cabello, Senia senia, Vehiculo vehiculo, Hobby hobby) {
		this.nombre = nombre;
		this.sexo = sexo;
		this.cabello = cabello;
		this.senia = senia;
		this.hobby = hobby;
		this.vehiculo = vehiculo;
	}

	public static Perfil deserializar(Node elementoPerfil) {
		
		String nombre = ((Element) elementoPerfil).getAttribute("nombre");
		Sexo sexo = Sexo.valueOf(((Element) elementoPerfil).getAttribute("sexo").toUpperCase());
		Cabello cabello = Cabello.valueOf(((Element) elementoPerfil).getAttribute("cabello").toUpperCase());
		Senia senia = Senia.valueOf(((Element) elementoPerfil).getAttribute("senia").toUpperCase());
		Vehiculo vehiculo = Vehiculo.valueOf(((Element) elementoPerfil).getAttribute("vehiculo").toUpperCase());
		Hobby hobby = Hobby.valueOf(((Element) elementoPerfil).getAttribute("hobby").toUpperCase());
		
		return new Perfil(nombre, sexo, cabello, senia, vehiculo, hobby);
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public Sexo getSexo() {
		return this.sexo;
	}

	public Cabello getCabello() {
		return cabello;
	}

	public Senia getSenia() {
		return senia;
	}

	public Hobby getHobby() {
		return hobby;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}
}
