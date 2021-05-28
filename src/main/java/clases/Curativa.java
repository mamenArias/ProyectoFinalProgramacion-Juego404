package clases;

import enumeraciones.Pociones;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

/**
 * Clase de la poci�n curativa
 * 
 * @author Mamen Arias
 *
 */
public class Curativa extends Pocion {

	private short curacion; // nivel de curaci�n de la poci�n

	/**
	 * Constructor de la clase Curativa
	 * 
	 * @param tipoPocion tipo de poci�n
	 * @param curacion   curaci�n sobre la vida del personaje
	 * @throws NombreVacioException      excepci�n cuando el nombre del enemigo est� en blanco
	 * @throws NombreConNumerosException excepci�n cuando el nombre del enemigo contiene n�meros
	 */
	public Curativa(String nombre, Pociones tipoPocion, short curacion)
			throws NombreVacioException, NombreConNumerosException {
		super(nombre, tipoPocion);
		this.curacion = curacion;
	}

	/**
	 * Nivel de curaci�n de la poci�n
	 * 
	 * @return curaci�n obtenida
	 */
	public short getCuracion() {
		return curacion;
	}

	/**
	 * Establece un nuevo valor para el nivel de curaci�n
	 * 
	 * @param nuevo valor de la curaci�n
	 */
	public void setCuracion(short curacion) {
		this.curacion = curacion;
	}

}
