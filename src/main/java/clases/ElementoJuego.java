package clases;

import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

/**
 * Clase ElementoJuego que contiene las variables comunes de las subclases
 * 
 * @author Mamen Arias
 *
 */
public abstract class ElementoJuego {

	private String nombre; // nombre del elemento del juego

	/**
	 * Constructor de la clase ElementoJuego
	 * 
	 * @param nombre nombre del elemento
	 * @throws NombreVacioException      excepción cuando el nombre del enemigo está en blanco
	 * @throws NombreConNumerosException excepción cuando el nombre del enemigo contiene números
	 */
	public ElementoJuego(String nombre) throws NombreVacioException, NombreConNumerosException {
		super();
		this.setNombre(nombre);
		;
	}

	/**
	 * Nombre del elemento del juego
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Nuevo nombre para el elemento del juego
	 * 
	 * @param nuevo nombre
	 * @throws NombreVacioException      excepción cuando el nombre del enemigo está en blanco
	 * @throws NombreConNumerosException excepción cuando el nombre del enemigo contiene números
	 */
	public void setNombre(String nombre) throws NombreVacioException, NombreConNumerosException {
		if (nombre.isBlank()) {
			throw new NombreVacioException("Escribe un nombre para tu personaje.");
		}
		if (nombre.contains("0") || nombre.contains("1") || nombre.contains("2") || nombre.contains("3")
				|| nombre.contains("4") || nombre.contains("5") || nombre.contains("6") || nombre.contains("7")
				|| nombre.contains("8") || nombre.contains("9")) {
			throw new NombreConNumerosException("El nombre no puede contener números.");
		}
		this.nombre = nombre;
	}
}
