package clases;

public class PocionCurativa extends ElementoJuego {

	private Byte curacion; // nivel de curación de la poción

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
