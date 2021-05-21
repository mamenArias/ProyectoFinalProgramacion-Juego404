package clases;

import excepciones.NombreVacioException;

public abstract class ElementoJuego {

	private String nombre; // nombre del elemento del juego


	/**
	 * @param nombre
	 * @throws NombreVacioException 
	 */
	public ElementoJuego(String nombre) throws NombreVacioException {
		super();
		this.setNombre(nombre);;
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
	 * @throws NombreVacioException 
	 */
	public void setNombre(String nombre) throws NombreVacioException {
		if (nombre.isBlank()) {
			throw new NombreVacioException("Escribe un nombre para tu personaje.");
		}
		this.nombre = nombre;
	}
}
