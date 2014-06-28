package vista.pantallaInicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class BotonSalirJuego extends JButton {

	public BotonSalirJuego() {
		super("Salir del Juego");
		setVisible(true);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int salida = JOptionPane.showOptionDialog(null, "¿Desea Salir del Juego?", "Confirmar salida",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Si", "No" }, "default");
				if (salida == 0) {
					System.exit(0);
				}
			}
		});
	}

}
