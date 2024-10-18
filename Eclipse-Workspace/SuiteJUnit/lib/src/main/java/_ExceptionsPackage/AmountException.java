package _ExceptionsPackage;

public class AmountException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8933344880529943936L;

	public AmountException() {}
	
	public AmountException(String error) {
		super(error);
	}
}