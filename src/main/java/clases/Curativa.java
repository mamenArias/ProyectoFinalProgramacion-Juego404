package clases;

import enumeraciones.Pociones;

public class Curativa extends Pocion {

	private Byte curacion; // nivel de curaci�n de la poci�n



	/**
	 * @param curacion
	 */
	public Curativa(Byte curacion) {
		super(Pociones.CURATIVA);
		this.curacion = curacion;
	}

	/**
	 * Nivel de curaci�n de la poci�n
	 * 
	 * @return curaci�n obtenida
	 */
	public Byte getCuracion() {
		return curacion;
	}

	/**
	 * Establece un nuevo valor para el nivel de curaci�n
	 * 
	 * @param nuevo valor de la curaci�n
	 */
	public void setCuracion(Byte curacion) {
		this.curacion = curacion;
	}

}
