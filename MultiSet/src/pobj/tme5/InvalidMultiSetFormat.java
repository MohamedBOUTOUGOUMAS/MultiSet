package pobj.tme5;

public class InvalidMultiSetFormat extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -594528488714706141L;
	
	
	public InvalidMultiSetFormat(String error){
		super(error);
	}
	public InvalidMultiSetFormat(String error, Throwable cause){
		super(error, cause);
	}
	
}
