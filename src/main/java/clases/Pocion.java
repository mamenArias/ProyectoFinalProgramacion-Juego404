package clases;

import enumeraciones.Pociones;

public class Pocion {

	private Pociones tipoPocion;

	
	/**
	 * @param tipoPocion
	 */
	public Pocion(Pociones tipoPocion) {
		super();
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
