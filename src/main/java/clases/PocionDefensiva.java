package clases;

public class PocionDefensiva extends ElementoJuego {

	private Byte proteccion; // protección que da la poción

	/**
	 * Protección obtenida al tomar la poción
	 * 
	 * @return protección
	 */
	public Byte getProteccion() {
		return proteccion;
	}

	/**
	 * Nuevo nivel de protección obtenida
	 * 
	 * @param nueva protección
	 */
	public void setProteccion(Byte proteccion) {
		this.proteccion = proteccion;
	}

}
