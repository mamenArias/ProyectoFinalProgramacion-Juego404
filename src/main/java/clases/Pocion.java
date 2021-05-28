package clases;

import enumeraciones.Pociones;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

/**
 * Clase Pocion de todas las pociones que te puedes encontrar durante el juego
 * 
 * @author Mamen Arias
 *
 */
public class Pocion extends ElementoJuego {

	private Pociones tipoPocion; // tipo de poción

	/**
	 * Constructor de la clase Pocion
	 * 
	 * @param nombre     nombre de la pocion
	 * @param tipoPocion tipo de poción
	 * @throws NombreVacioException      excepción cuando el nombre del enemigo está en blanco
	 * @throws NombreConNumerosException excepción cuando el nombre del enemigo contiene números
	 */
	public Pocion(String nombre, Pociones tipoPocion) throws NombreVacioException, NombreConNumerosException {
		super(nombre);
		this.tipoPocion = tipoPocion;
	}

	/**
	 * obtiene el tipo de poción
	 * 
	 * @return tipoPocion
	 */
	public Pociones getTipoPocion() {
		return tipoPocion;
	}

	/**
	 * establece un nuevo tipo de poción
	 * 
	 * @param tipoPocion nueva
	 */
	public void setTipoPocion(Pociones tipoPocion) {
		this.tipoPocion = tipoPocion;
	}

}
