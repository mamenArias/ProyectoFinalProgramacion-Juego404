package excepciones;

/**
 * Excepción para que los nombres no puedan contener números
 * 
 * @author Mamen Arias
 *
 */
public class NombreConNumerosException extends Exception {
	/**
	 * Constructor de la excepción que lanza un mensaje
	 * @param msg mensaje de la excepción
	 */
	public NombreConNumerosException(String msg) {
		super(msg);
	}
}
