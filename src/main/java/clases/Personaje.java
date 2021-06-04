package clases;

import enumeraciones.Pociones;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

/**
 * Clase Personaje del juego
 * 
 * @author Mamen Arias
 *
 */
public class Personaje extends ElementoJuego {

	private Short vida; // vida del personaje
	private Short ataque; // nivel de ataque del personaje

	/**
	 * Constructor para la clase Personaje
	 * 
	 * @param nombre nombre del personaje
	 * @param vida   vida del personaje
	 * @param ataque ataque del personaje
	 * @throws NombreVacioException      excepción cuando el nombre del enemigo está en blanco
	 * @throws NombreConNumerosException excepción cuando el nombre del enemigo contiene números
	 */
	public Personaje(String nombre) throws NombreVacioException, NombreConNumerosException {
		super(nombre);
		this.vida = 0;
		this.ataque = 0;
	}

	/**
	 * Cantidad de vida del personaje
	 * 
	 * @return vida del personaje
	 */
	public Short getVida() {
		return vida;
	}

	/**
	 * Nuevo nivel de vida del personaje
	 * 
	 * @param nuevo nivel de vida
	 */
	public void setVida(Short vida) {
		this.vida = vida;
	}

	/**
	 * Cantidad de daño de ataque que realiza el personaje
	 * 
	 * @return ataque del personaje
	 */
	public Short getAtaque() {
		return ataque;
	}

	/**
	 * Nueva cantidad de ataque que realiza el personaje
	 * 
	 * @param nuevo ataque
	 */
	public void setAtaque(Short ataque) {
		this.ataque = ataque;
	}

	/**
	 * Función usada en los ataques para bajar la vida de los personajes cada vez
	 * que el otro ataca
	 * 
	 * @param ataque de los personajes
	 */
	public void bajarVida(short ataque) {
		this.vida = (short) (vida - ataque);
	}

}
