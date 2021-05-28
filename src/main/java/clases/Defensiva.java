package clases;

import enumeraciones.Pociones;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

/**
 * Clase de la poción Defensiva
 * 
 * @author Mamen Arias
 *
 */
public class Defensiva extends Pocion {

	private short proteccion; // protección que da la poción

	/**
	 * Constructor de la clase Defensiva
	 * 
	 * @param tipoPocion tipo de poción
	 * @param proteccion cantidad de disminución del ataque del personaje
	 * @throws NombreVacioException      excepción cuando el nombre del enemigo está en blanco
	 * @throws NombreConNumerosException excepción cuando el nombre del enemigo contiene números
	 */
	public Defensiva(String nombre, Pociones tipoPocion, short proteccion)
			throws NombreVacioException, NombreConNumerosException {
		super(nombre, tipoPocion);
		this.proteccion = proteccion;
	}

	/**
	 * Protección obtenida al tomar la poción
	 * 
	 * @return protección
	 */
	public short getProteccion() {
		return proteccion;
	}

	/**
	 * Nuevo nivel de protección obtenida
	 * 
	 * @param nueva protección
	 */
	public void setProteccion(short proteccion) {
		this.proteccion = proteccion;
	}

}
