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

	private Pociones tipoPocion; // tipo de poci�n

	/**
	 * Constructor de la clase Pocion
	 * 
	 * @param nombre     nombre de la pocion
	 * @param tipoPocion tipo de poci�n
	 * @throws NombreVacioException      excepci�n cuando el nombre del enemigo est� en blanco
	 * @throws NombreConNumerosException excepci�n cuando el nombre del enemigo contiene n�meros
	 */
	public Pocion(String nombre, Pociones tipoPocion) throws NombreVacioException, NombreConNumerosException {
		super(nombre);
		this.tipoPocion = tipoPocion;
	}

	/**
	 * obtiene el tipo de poci�n
	 * 
	 * @return tipoPocion
	 */
	public Pociones getTipoPocion() {
		return tipoPocion;
	}

	/**
	 * establece un nuevo tipo de poci�n
	 * 
	 * @param tipoPocion nueva
	 */
	public void setTipoPocion(Pociones tipoPocion) {
		this.tipoPocion = tipoPocion;
	}

}
