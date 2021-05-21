package clases;

import enumeraciones.Pociones;

public class Defensiva extends Pocion {

	private Byte proteccion; // protecci�n que da la poci�n
	


	/**
	 * @param proteccion
	 */
	public Defensiva(Byte proteccion) {
		super(Pociones.DEFENSIVA);
		this.proteccion = proteccion;
	}

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
