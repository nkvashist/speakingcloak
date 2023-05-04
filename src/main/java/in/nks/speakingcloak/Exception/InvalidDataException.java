package in.nks.speakingcloak.Exception;

/**
 * Invalid time exception
 * 
 * @author Naresh
 */
public class InvalidDataException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1793063837307601791L;

	public InvalidDataException( String message) {
		super(message);
		
	}
}
