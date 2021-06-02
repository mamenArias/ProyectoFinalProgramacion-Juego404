package clases;

import java.util.Random;

import enumeraciones.Enemigos;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

/**
 * Clase del tipo enemigo Usuario, que es el jefe final del juego
 * @author Mamen Arias
 *
 */
public class Usuario extends Adversario{

	private short ataqueEspecial; // ataque especial del personaje

	/**
	 * Constructor de la clase Usuario
	 * @param nombre nombre del enemigo
	 * @param vida vida del enemigo
	 * @param ataque ataque del enemigo
	 * @param tipoEnemigo tipo de enemigo
	 * @param respuestaAmistosa respuesta cuando eliges la opción buena
	 * @param respuestaNeutral respuesta cuando eliges la opción neutra
	 * @param respuestaAgresiva respuesta cuando eliges la opción mala
	 * @param ataqueEspecial ataque especial del enemigo
	 * @throws NombreVacioException excepción cuando el nombre del enemigo está en blanco
	 * @throws NombreConNumerosException excepción cuando el nombre del enemigo contiene números
	 */
	public Usuario(String nombre, Short vida, Short ataque, Enemigos tipoEnemigo, String respuestaAmistosa,
			String respuestaNeutral, String respuestaAgresiva, short ataqueEspecial)
			throws NombreVacioException, NombreConNumerosException {
		super(nombre, vida, ataque, tipoEnemigo, respuestaAmistosa, respuestaNeutral, respuestaAgresiva);
		this.setAtaque(ataqueEspecial);
	}
	
	/**
	 * Constructor de la clase Usuario sin strings de respuesta, ya que este enemigo sólo puede vencerse atacándolo.
	 * @param nombre nombre del enemigo
	 * @param vida vida del enemigo
	 * @param ataque ataque del enemigo
	 * @param tipoEnemigo tipo de enemigo
	 * @param ataqueEspecial ataque especial del enemigo
	 * @throws NombreVacioException excepción cuando el nombre del enemigo está en blanco
	 * @throws NombreConNumerosException excepción cuando el nombre del enemigo contiene números
	 */
	public Usuario (String nombre, Short vida, Short ataque, Enemigos tipoEnemigo, short ataqueEspecial) throws NombreVacioException, NombreConNumerosException {
		super(nombre, vida, ataque, tipoEnemigo);
		this.setAtaque(ataqueEspecial);
	}

	/**
	 * @return the ataqueEspecial
	 */
	public short getAtaqueEspecial() {
		return ataqueEspecial;
	}

	/**
	 * Ataque especial del Jefe que va a ser el ataque normal multiplicado por 2
	 * @param ataqueEspecial the ataqueEspecial to set
	 */
	public void setAtaqueEspecial(short ataqueEspecial) {
		this.ataqueEspecial = (short) (2 * this.getAtaque());
		//this.ataqueEspecial = ataqueEspecial;
	}
	
	public void ataqueEspecialUsuario(Protagonista p) {
		p.bajarVida((short) new Random().nextInt(this.getAtaqueEspecial()));
		if (p.getVida() <= 0) {
			p.setVida((short) 0);
		}
	}
}
