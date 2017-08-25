package exceptions;

public class AdministradorException extends Exception {
	
	private static final long serialVersionUID = -1143108953650888155L;

	public AdministradorException() {
		super("Problema ao tentar realizar login.");
	}

}
