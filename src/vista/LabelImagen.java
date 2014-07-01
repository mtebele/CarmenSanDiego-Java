package vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LabelImagen extends JLabel {

	private BufferedImage img;

	public LabelImagen(String filename) {
		try {
			img = ImageIO.read(new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setIcon(new ImageIcon(img));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// pinta el panel con el fondo
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}

}
