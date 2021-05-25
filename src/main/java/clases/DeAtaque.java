package clases;

import enumeraciones.Pociones;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

public class DeAtaque extends Pocion {

	private Byte da�o; // nivel de da�o aumentado de la poci�n


	

	/**
	 * @param tipoPocion
	 * @param da�o
	 * @throws NombreConNumerosException 
	 * @throws NombreVacioException 
	 */
	public DeAtaque(String nombre, Pociones tipoPocion, Byte da�o) throws NombreVacioException, NombreConNumerosException {
		super(nombre, tipoPocion);
		this.da�o = da�o;
	}

	/**
	 * @param da�o
	 */
	/*public DeAtaque(Byte da�o) {
		super(Pociones.DEATAQUE);
		this.da�o = da�o;
	}*/

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
