package clases;

public class Personaje extends ElementoJuego {

	private Short vida; // vida del personaje
	private Short ataque; // nivel de ataque del personaje

	/**
	 * Cantidad de vida del personaje
	 * @return vida del personaje
	 */
	public Short getVida() {
		return vida;
	}

	/**
	 * Nuevo nivel de vida del personaje
	 * @param nuevo nivel de vida
	 */
	public void setVida(Short vida) {
		this.vida = vida;
	}

	/**
	 * Cantidad de da�o de ataque que realiza el personaje
	 * @return ataque del personaje
	 */
	public Short getAtaque() {
		return ataque;
	}

	/**
	 * Nueva cantidad de ataque que realiza el personaje
	 * @param nuevo ataque
	 */
	public void setAtaque(Short ataque) {
		this.ataque = ataque;
	}
	
	/**
	 * Funci�n para los ataques realizados por los personajes
	 */
	public void atacar() {
		
	}

}