package carmen.vista.pantallaOrdenArresto;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import carmen.modelo.ladron.Ladron;
import carmen.modelo.ladron.perfil.Cabello;
import carmen.modelo.ladron.perfil.Hobby;
import carmen.modelo.ladron.perfil.Perfil;
import carmen.modelo.ladron.perfil.Senia;
import carmen.modelo.ladron.perfil.Sexo;
import carmen.modelo.ladron.perfil.Vehiculo;

public class AreaSospechosos extends JTextArea{
	
	public AreaSospechosos(){
		super();
		this.setOpaque(false); //hacer que esto sea opaco
		//o hacer una imagen que permita que al hacer append se vea el texto
		//si tienen dudas de como se ven los resultados, corran el main de aca
		//o hagan un append en el constructor para ver como se ve el texto.
	}

	public void AgregarSospechoso(Ladron unLadron){
		this.append(unLadron.toString());
	}

	public static void main(String[] args){
		Ladron unLadron = new Ladron(new Perfil("Carmen Sandiego", Sexo.MASCULINO, Cabello.ROJO, Senia.ANILLO, Vehiculo.LIMUSINA, Hobby.MUSICA));
		JFrame frame = new JFrame("HOLA");
		AreaSospechosos area = new AreaSospechosos();
		frame.getContentPane().add(area);
		area.AgregarSospechoso(unLadron);
		area.AgregarSospechoso(unLadron);
		frame.setSize(800,600);
		frame.setVisible(true);
	}
}
