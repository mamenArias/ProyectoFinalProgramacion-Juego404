package clases;

import enumeraciones.Pociones;

public class Curativa extends Pocion {

	private Byte curacion; // nivel de curación de la poción



	/**
	 * @param curacion
	 */
	public Curativa(Byte curacion) {
		super(Pociones.CURATIVA);
		this.curacion = curacion;
	}

	/**
	 * Nivel de curación de la poción
	 * 
	 * @return curación obtenida
	 */
	public Byte getCuracion() {
		return curacion;
	}

	/**
	 * Establece un nuevo valor para el nivel de curación
	 * 
	 * @param nuevo valor de la curación
	 */
	public void setCuracion(Byte curacion) {
		this.curacion = curacion;
	}

}
