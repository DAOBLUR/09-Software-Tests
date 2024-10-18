package _ExceptionsPackage;

public class AuthenticationException extends Exception{
/**
	 * 
	 */
	private static final long serialVersionUID = 3835433576500838975L;

public AuthenticationException() { }
	
	public AuthenticationException(String error) {
		super(error);
	}
}