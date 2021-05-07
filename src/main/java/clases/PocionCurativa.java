package clases;

public class PocionCurativa extends ElementoJuego {

	private Byte curacion; // nivel de curaci�n de la poci�n

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
