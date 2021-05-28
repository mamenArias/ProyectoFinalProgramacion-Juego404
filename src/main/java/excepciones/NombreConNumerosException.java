package excepciones;

/**
 * Excepci�n para que los nombres no puedan contener n�meros
 * 
 * @author Mamen Arias
 *
 */
public class NombreConNumerosException extends Exception {
	public NombreConNumerosException(String msg) {
		super(msg);
	}
}
