package excepciones;

/**
 * Excepci�n para que los nombres no puedan estar vac�os
 * 
 * @author Mamen Arias
 *
 */
public class NombreVacioException extends Exception {

	public NombreVacioException(String msg) {
		super(msg);
	}
}
