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
	 * @throws NombreVacioException      excepci�n cuando el nombre del enemigo est� en blanco
	 * @throws NombreConNumerosException excepci�n cuando el nombre del enemigo contiene n�meros
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
	 * Cantidad de da�o de ataque que realiza el personaje
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
	 * Funci�n usada en los ataques para bajar la vida de los personajes cada vez
	 * que el otro ataca
	 * 
	 * @param ataque de los personajes
	 */
	public void bajarVida(short ataque) {
		this.vida = (short) (vida - ataque);
	}

	/**
	 * Funci�n para usar las pociones que te encuentras a lo largo del juego
	 * 
	 * @param p               poci�n hallada
	 * @param habilidadPocion efecto de la poci�n sobre el personaje
	 * @param a               enemigo sobre el que recae el efecto de la poci�n
	 */
	public void usoDePociones(Pocion p, short habilidadPocion, Adversario a) {
		if (p.getTipoPocion() == Pociones.CURATIVA) {
			this.vida = (short) (vida + habilidadPocion);
			if (this.vida > 500) {
				this.vida = 500;
			}
		} else if (p.getTipoPocion() == Pociones.DEATAQUE) {
			this.ataque = (short) (ataque + habilidadPocion);
		} else if (p.getTipoPocion() == Pociones.DEFENSIVA) {
			a.setAtaque((short) (ataque - habilidadPocion));
			if (a.getAtaque() < 0) {
				a.setAtaque((short) 0);
			}
		}
	}

}
