package clases;

import enumeraciones.Pociones;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

/**
 * Clase de la poción curativa
 * 
 * @author Mamen Arias
 *
 */
public class Curativa extends Pocion {

	private short curacion; // nivel de curación de la poción

	/**
	 * Constructor de la clase Curativa
	 * 
	 * @param tipoPocion tipo de poción
	 * @param curacion   curación sobre la vida del personaje
	 * @throws NombreVacioException      excepción cuando el nombre del enemigo está en blanco
	 * @throws NombreConNumerosException excepción cuando el nombre del enemigo contiene números
	 */
	public Curativa(String nombre, Pociones tipoPocion, short curacion)
			throws NombreVacioException, NombreConNumerosException {
		super(nombre, tipoPocion);
		this.curacion = curacion;
	}

	/**
	 * Nivel de curación de la poción
	 * 
	 * @return curación obtenida
	 */
	public short getCuracion() {
		return curacion;
	}

	/**
	 * Establece un nuevo valor para el nivel de curación
	 * 
	 * @param nuevo valor de la curación
	 */
	public void setCuracion(short curacion) {
		this.curacion = curacion;
	}

}
