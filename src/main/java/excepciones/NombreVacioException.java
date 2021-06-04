package excepciones;

/**
 * Excepción para que los nombres no puedan estar vacíos
 * 
 * @author Mamen Arias
 *
 */
public class NombreVacioException extends Exception {

	/**
	 * * Constructor de la excepción que lanza un mensaje
	 * @param msg mensaje de la excepción
	 */
	public NombreVacioException(String msg) {
		super(msg);
	}
}
