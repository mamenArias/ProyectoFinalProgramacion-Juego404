package excepciones;

/**
 * Excepción para que los nombres no puedan contener números
 * 
 * @author Mamen Arias
 *
 */
public class NombreConNumerosException extends Exception {
	public NombreConNumerosException(String msg) {
		super(msg);
	}
}
