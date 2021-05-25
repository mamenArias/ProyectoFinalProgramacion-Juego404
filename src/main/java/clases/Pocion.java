package clases;

import enumeraciones.Pociones;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

public class Pocion extends ElementoJuego {

	private Pociones tipoPocion;

	
	/**
	 * @param nombre
	 * @param tipoPocion
	 * @throws NombreConNumerosException 
	 * @throws NombreVacioException 
	 */
	public Pocion(String nombre, Pociones tipoPocion) throws NombreVacioException, NombreConNumerosException {
		super(nombre);
		this.tipoPocion = tipoPocion;
	}

	/**
	 * @return the tipoPocion
	 */
	public Pociones getTipoPocion() {
		return tipoPocion;
	}

	/**
	 * @param tipoPocion the tipoPocion to set
	 */
	public void setTipoPocion(Pociones tipoPocion) {
		this.tipoPocion = tipoPocion;
	}
	
	
}
