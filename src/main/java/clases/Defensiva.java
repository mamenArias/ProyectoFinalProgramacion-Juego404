package clases;

import enumeraciones.Pociones;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

public class Defensiva extends Pocion {

	private Byte proteccion; // protección que da la poción
	

	

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
	 * Protección obtenida al tomar la poción
	 * 
	 * @return protección
	 */
	public Byte getProteccion() {
		return proteccion;
	}

	/**
	 * Nuevo nivel de protección obtenida
	 * 
	 * @param nueva protección
	 */
	public void setProteccion(Byte proteccion) {
		this.proteccion = proteccion;
	}

}
