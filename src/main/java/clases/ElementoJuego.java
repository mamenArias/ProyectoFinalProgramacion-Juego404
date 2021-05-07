package clases;

public abstract class ElementoJuego {

	private String nombre; // nombre del elemento del juego

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
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
