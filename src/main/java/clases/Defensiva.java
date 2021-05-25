package clases;

import enumeraciones.Pociones;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

public class Defensiva extends Pocion {

	private Byte proteccion; // protecci�n que da la poci�n
	

	

	/**
	 * @param tipoPocion
	 * @param proteccion
	 * @throws NombreConNumerosException 
	 * @throws NombreVacioException 
	 */
	public Defensiva(String nombre, Pociones tipoPocion, Byte proteccion) throws NombreVacioException, NombreConNumerosException {
		super(nombre, tipoPocion);
		this.proteccion = proteccion;
	}

	/**
	 * @param proteccion
	 */
	/*public Defensiva(Byte proteccion) {
		super(Pociones.DEFENSIVA);
		this.proteccion = proteccion;
	}*/

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
