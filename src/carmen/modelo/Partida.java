package carmen.modelo;

import java.util.ArrayList;

public class Partida {

	private Policia policia;
    private Ladron ladron;
    private Turno turno;
    private Mapa mapa;
    private OrdenDeArresto orden;
    
    static void dePolicia (Policia policia){
    	this.policia = policia;
    }
    
    public void emitirOrden(Ladron ladron) {

    }
    
    public boolean atraparLadron(Ladron ladron) {

    }
     
    public void viajar(Ciudad destino) {

    }
    
    public void interrogar(Local local) {

    }
    
    public void perder() {

    }
    
    public void ganar() {

    }
    
    public ArrayList verDestinos() {
    	// Ver bien el tipo que devuelve
    }
    
    public int verTiempoRestante() {
    	return turno.getHorasRestantes;
    }
    
    public void setearMapa(Mapa mapa) {
    	this.mapa = mapa;
    }
    
    public void setearLadron(Ladron ladron) {
    	this.ladron = ladron;
    }
    
    public void setearTurno(Turno turno) {
    	this.turno = turno;
    }
}