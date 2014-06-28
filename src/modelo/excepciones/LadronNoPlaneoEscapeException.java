package modelo.excepciones;

public class LadronNoPlaneoEscapeException extends Exception {
	
	private static final long serialVersionUID = 42L;  // unique id
	
	public LadronNoPlaneoEscapeException(String msg) {
		super(msg);
	}
}
