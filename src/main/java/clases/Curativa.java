package clases;

import enumeraciones.Pociones;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

public class Curativa extends Pocion {

	private Byte curacion; // nivel de curaci�n de la poci�n


	

	/**
	 * @param tipoPocion
	 * @param curacion
	 * @throws NombreConNumerosException 
	 * @throws NombreVacioException 
	 */
	public Curativa(String nombre, Pociones tipoPocion, Byte curacion) throws NombreVacioException, NombreConNumerosException {
		super(nombre, tipoPocion);
		this.curacion = curacion;
	}

	/**
	 * @param curacion
	 */
	/*public Curativa(Byte curacion) {
		super(Pociones.CURATIVA);
		this.curacion = curacion;
	}*/

	/**
	 * Nivel de curaci�n de la poci�n
	 * 
	 * @return curaci�n obtenida
	 */
	public Byte getCuracion() {
		return curacion;
	}

	/**
	 * Establece un nuevo valor para el nivel de curaci�n
	 * 
	 * @param nuevo valor de la curaci�n
	 */
	public void setCuracion(Byte curacion) {
		this.curacion = curacion;
	}

}
