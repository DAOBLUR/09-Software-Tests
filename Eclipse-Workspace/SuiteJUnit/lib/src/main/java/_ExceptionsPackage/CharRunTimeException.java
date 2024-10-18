package _ExceptionsPackage;

public class CharRunTimeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4945112706534477272L;

	public CharRunTimeException(String errorMessage, Throwable err) {
    	super(errorMessage, err);
    }
    
    public CharRunTimeException(String errorMessage) {
    	super(errorMessage);
    }
    
    public CharRunTimeException() { }
}