package clases;

import enumeraciones.Pociones;

public class DeAtaque extends Pocion {

	private Byte daño; // nivel de daño aumentado de la poción



	/**
	 * @param daño
	 */
	public DeAtaque(Byte daño) {
		super(Pociones.DEATAQUE);
		this.daño = daño;
	}

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
