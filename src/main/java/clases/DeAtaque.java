package clases;

import enumeraciones.Pociones;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

/**
 * Clase de la poci�n de ataque
 * 
 * @author Mamen Arias
 *
 */
public class DeAtaque extends Pocion {

	private short da�o; // nivel de da�o aumentado de la poci�n

	/**
	 * Constructor de la clase DeAtaque
	 * 
	 * @param tipoPocion tipo de poci�n
	 * @param da�o       cantidad de aumento del ataque del personaje
	 * @throws NombreVacioException      excepci�n cuando el nombre del enemigo est� en blanco
	 * @throws NombreConNumerosException excepci�n cuando el nombre del enemigo contiene n�meros
	 */
	public DeAtaque(String nombre, Pociones tipoPocion, short da�o)
			throws NombreVacioException, NombreConNumerosException {
		super(nombre, tipoPocion);
		this.da�o = da�o;
	}

	/**
	 * Nivel de da�o obtenido al tomar la poci�n
	 * 
	 * @return da�o obtenido
	 */
	public short getDa�o() {
		return da�o;
	}

	/**
	 * Establece un nuevo nivel de da�o
	 * 
	 * @param nuevo nivel de da�o
	 */
	public void setDa�o(short da�o) {
		this.da�o = da�o;
	}

}
