package carmen.modelo;

public class Perfil {
	private String nombre;
	private Sexo sexo;
	private Cabello cabello;
	private Senia senia;
	private Hobby hobby;
	private Vehiculo vehiculo;


	public Perfil(String nombre, Sexo sexo, Cabello cabello, Senia senia, Vehiculo vehiculo, Hobby hobby){
		this.nombre = nombre;
		this.sexo = sexo;
		this.cabello = cabello;
		this.senia = senia;
		this.hobby = hobby;
		this.vehiculo = vehiculo;
	}
	
	public String verNombre(){
		return this.nombre;
	}
}
