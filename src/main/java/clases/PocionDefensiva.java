package clases;

public class PocionDefensiva extends ElementoJuego {

	private Byte proteccion; // protecci�n que da la poci�n

	/**
	 * Protecci�n obtenida al tomar la poci�n
	 * 
	 * @return protecci�n
	 */
	public Byte getProteccion() {
		return proteccion;
	}

	/**
	 * Nuevo nivel de protecci�n obtenida
	 * 
	 * @param nueva protecci�n
	 */
	public void setProteccion(Byte proteccion) {
		this.proteccion = proteccion;
	}

}
