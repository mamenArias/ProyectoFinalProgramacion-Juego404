package clases;

import enumeraciones.Pociones;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

/**
 * Clase de la poción de ataque
 * 
 * @author Mamen Arias
 *
 */
public class DeAtaque extends Pocion {

	private short daño; // nivel de daño aumentado de la poción

	/**
	 * Constructor de la clase DeAtaque
	 * 
	 * @param tipoPocion tipo de poción
	 * @param daño       cantidad de aumento del ataque del personaje
	 * @throws NombreVacioException      excepción cuando el nombre del enemigo está en blanco
	 * @throws NombreConNumerosException excepción cuando el nombre del enemigo contiene números
	 */
	public DeAtaque(String nombre, Pociones tipoPocion, short daño)
			throws NombreVacioException, NombreConNumerosException {
		super(nombre, tipoPocion);
		this.daño = daño;
	}

	/**
	 * Nivel de daño obtenido al tomar la poción
	 * 
	 * @return daño obtenido
	 */
	public short getDaño() {
		return daño;
	}

	/**
	 * Establece un nuevo nivel de daño
	 * 
	 * @param nuevo nivel de daño
	 */
	public void setDaño(short daño) {
		this.daño = daño;
	}

}
