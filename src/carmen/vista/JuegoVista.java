package carmen.vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import carmen.vista.pantallaInicial.BotonNuevoJuego;
import carmen.vista.pantallaInicial.BotonSalirJuego;
import carmen.vista.pantallaInicial.PanelInicial;

public class JuegoVista extends JFrame implements Observer{ 
	private static int MAX_ALTURA = 800;
	private static int MAX_ANCHURA = 600;
	
	PanelCarga carga = new PanelCarga();
	PanelInicial pnlNuevaPartida = new PanelInicial();
	
	public static void main(String[] args){
		JuegoVista vista = new JuegoVista();		
	}
	
	public JuegoVista(){
		super("Carmen SanDiego - 75.07 FIUBA");
		final PanelesAdministrador admin = new PanelesAdministrador(this);
		setSize(MAX_ALTURA,MAX_ANCHURA);
		setResizable(true);
		setVisible(true);
		getContentPane().add(pnlNuevaPartida);
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
