package exceptions;

public class EspecialidadeMedicaException extends Exception {

	private static final long serialVersionUID = 8029853890692524003L;

	public EspecialidadeMedicaException(String erro) {
		super("Essa especialidade medica " + erro);
	}
	
}
