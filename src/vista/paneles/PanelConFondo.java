package vista.paneles;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanelConFondo extends JPanel {
	private BufferedImage img;

	public PanelConFondo(String filename) {
		try {
			img = ImageIO.read(new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// pinta el panel con el fondo
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}

	public void esconder() {
		setVisible(false);
	}

	public void mostrar() {
		setVisible(true);
	}
}