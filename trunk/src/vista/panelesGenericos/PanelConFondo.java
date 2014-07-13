package vista.panelesGenericos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelConFondo extends JPanel {
	private static final long serialVersionUID = 690194458739127251L;
	private BufferedImage img;

	public PanelConFondo(String filename) {
		try {
			img = ImageIO.read(new File(filename));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		// setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}

	public void esconder() {
		setVisible(false);
	}

	public void mostrar() {
		setVisible(true);
	}
}