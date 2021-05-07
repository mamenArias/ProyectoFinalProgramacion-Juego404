package clases;

public class PocionDeAtaque extends ElementoJuego {

	private Byte daño; // nivel de daño aumentado de la poción

	/**
	 * Nivel de daño obtenido al tomar la poción
	 * 
	 * @return daño obtenido
	 */
	public Byte getDaño() {
		return daño;
	}

	/**
	 * Establece un nuevo nivel de daño
	 * 
	 * @param nuevo nivel de daño
	 */
	public void setDaño(Byte daño) {
		this.daño = daño;
	}

}
