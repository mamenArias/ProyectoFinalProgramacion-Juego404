package excepciones;

/**
 * Excepci�n para que los nombres no puedan contener n�meros
 * 
 * @author Mamen Arias
 *
 */
public class NombreConNumerosException extends Exception {
	/**
	 * Constructor de la excepci�n que lanza un mensaje
	 * @param msg mensaje de la excepci�n
	 */
	public NombreConNumerosException(String msg) {
		super(msg);
	}
}
