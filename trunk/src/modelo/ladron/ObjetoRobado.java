package modelo.ladron;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ObjetoRobado {

	private Valor valor;
	

	public ObjetoRobado(Valor unValor) {
	
		this.valor = unValor;
	}

	public Valor getValor() {
		return this.valor;
	}
	
	public static ObjetoRobado deserializar(Node elementoObjeto) {
        Valor valor = Valor.valueOf(((Element) elementoObjeto).getAttribute("valor").toUpperCase());
        ObjetoRobado objetoRobado = new ObjetoRobado(valor);    
        return objetoRobado;
	}

}