package clases;

import enumeraciones.Pociones;

public class DeAtaque extends Pocion {

	private Byte da�o; // nivel de da�o aumentado de la poci�n



	/**
	 * @param da�o
	 */
	public DeAtaque(Byte da�o) {
		super(Pociones.DEATAQUE);
		this.da�o = da�o;
	}

	/**
	 * Nivel de da�o obtenido al tomar la poci�n
	 * 
	 * @return da�o obtenido
	 */
	public Byte getDa�o() {
		return da�o;
	}

	/**
	 * Establece un nuevo nivel de da�o
	 * 
	 * @param nuevo nivel de da�o
	 */
	public void setDa�o(Byte da�o) {
		this.da�o = da�o;
	}

}
