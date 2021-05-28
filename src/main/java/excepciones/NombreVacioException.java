package excepciones;

/**
 * Excepción para que los nombres no puedan estar vacíos
 * 
 * @author Mamen Arias
 *
 */
public class NombreVacioException extends Exception {

	public NombreVacioException(String msg) {
		super(msg);
	}
}
