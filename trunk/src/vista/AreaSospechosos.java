package vista;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import modelo.ladron.Ladron;
import modelo.ladron.perfil.Cabello;
import modelo.ladron.perfil.Hobby;
import modelo.ladron.perfil.Perfil;
import modelo.ladron.perfil.Senia;
import modelo.ladron.perfil.Sexo;
import modelo.ladron.perfil.Vehiculo;

public class AreaSospechosos extends JTextArea {

	private static final long serialVersionUID = -5392495346064595432L;

	public AreaSospechosos() {
		super();
		this.setOpaque(false);
	}

	public void AgregarSospechoso(Ladron unLadron) {
		this.append(unLadron.verDatos());
	}

	public static void main(String[] args) {
		Ladron unLadron = new Ladron(new Perfil("Carmen Sandiego", Sexo.MASCULINO, Cabello.ROJO, Senia.ANILLO,
				Vehiculo.LIMUSINA, Hobby.MUSICA));
		JFrame frame = new JFrame("Sospechosos");
		AreaSospechosos area = new AreaSospechosos();
		frame.getContentPane().add(area);
		area.AgregarSospechoso(unLadron);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
}
