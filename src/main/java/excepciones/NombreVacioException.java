package excepciones;

/**
 * Excepci?n para que los nombres no puedan estar vac?os
 * 
 * @author Mamen Arias
 *
 */
public class NombreVacioException extends Exception {

	/**
	 * * Constructor de la excepci?n que lanza un mensaje
	 * @param msg mensaje de la excepci?n
	 */
	public NombreVacioException(String msg) {
		super(msg);
	}
}
