package clases;

import enumeraciones.Pociones;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

/**
 * Clase de la poci�n Defensiva
 * 
 * @author Mamen Arias
 *
 */
public class Defensiva extends Pocion {

	private short proteccion; // protecci�n que da la poci�n

	/**
	 * Constructor de la clase Defensiva
	 * 
	 * @param tipoPocion tipo de poci�n
	 * @param proteccion cantidad de disminuci�n del ataque del personaje
	 * @throws NombreVacioException      excepci�n cuando el nombre del enemigo est� en blanco
	 * @throws NombreConNumerosException excepci�n cuando el nombre del enemigo contiene n�meros
	 */
	public Defensiva(String nombre, Pociones tipoPocion, short proteccion)
			throws NombreVacioException, NombreConNumerosException {
		super(nombre, tipoPocion);
		this.proteccion = proteccion;
	}

	/**
	 * Protecci�n obtenida al tomar la poci�n
	 * 
	 * @return protecci�n
	 */
	public short getProteccion() {
		return proteccion;
	}

	/**
	 * Nuevo nivel de protecci�n obtenida
	 * 
	 * @param nueva protecci�n
	 */
	public void setProteccion(short proteccion) {
		this.proteccion = proteccion;
	}

}
