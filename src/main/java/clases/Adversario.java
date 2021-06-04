package clases;

import java.util.Random;

import enumeraciones.Enemigos;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;
import interfaces.Ventana;

/**
 * Clase de los enemigos creados en el juego
 * 
 * @author Mamen Arias
 *
 */
public class Adversario extends Personaje {

	private Enemigos tipoEnemigo; // tipo de enemigo
	private String respuestaAmistosa; // respuesta cuando eliges la opción correcta al hablar en las batallas
	private String respuestaNeutral; // respuesta cuando eliges la opción neutral al hablar en las batallas
	private String respuestaAgresiva; // respuesta cuando eliges la opción incorrecta al hablar en las batallas

	/**
	 * Constructor de la clase Adversario
	 * 
	 * @param nombre            nombre del enemigo
	 * @param vida              nivel de vida
	 * @param ataque            cantidad de ataque
	 * @param tipoEnemigo       tipo de enemigo
	 * @param respuestaAmistosa respuesta cuando elegimos la opción correcta
	 * @param respuestaNeutral  respuesta cuando elegimos la opción neutra
	 * @param respuestaAgresiva respuesta cuando elegimos la opción incorrecta
	 * @throws NombreVacioException      excepción cuando el nombre del enemigo está en blanco
	 * @throws NombreConNumerosException excepción cuando el nombre del enemigo contiene números
	 */
	public Adversario(String nombre, Short vida, Short ataque, Enemigos tipoEnemigo, String respuestaAmistosa,
			String respuestaNeutral, String respuestaAgresiva) throws NombreVacioException, NombreConNumerosException {
		super(nombre);
		super.setVida(vida);
		super.setAtaque(ataque);
		this.tipoEnemigo = tipoEnemigo;
		this.respuestaAmistosa = respuestaAmistosa;
		this.respuestaNeutral = respuestaNeutral;
		this.respuestaAgresiva = respuestaAgresiva;
	}

	/**
	 * Constructor de la clase Adversario
	 * 
	 * @param nombre      nombre del enemigo
	 * @param vida        vida del enemigo
	 * @param ataque      ataque del enemigo
	 * @param tipoEnemigo tipo de enemigo
	 * @throws NombreVacioException      excepción cuando el nombre del enemigo está en blanco
	 * @throws NombreConNumerosException excepción cuando el nombre del enemigo contiene números
	 */
	public Adversario(String nombre, short vida, short ataque, Enemigos tipoEnemigo)
			throws NombreVacioException, NombreConNumerosException {
		super(nombre);
		super.setVida(vida);
		super.setAtaque(ataque);
		this.tipoEnemigo = tipoEnemigo;
	}

	/**
	 * Obtiene el tipo de enemigo
	 * 
	 * @return tipoEnemigo
	 */
	public Enemigos getTipoEnemigo() {
		return tipoEnemigo;
	}

	/**
	 * Establece un nuevo tipo de enemigo
	 * 
	 * @param tipoEnemigo nuevo
	 */
	public void setTipoEnemigo(Enemigos tipoEnemigo) {
		this.tipoEnemigo = tipoEnemigo;
	}

	/**
	 * Obtiene el tipo de respuesta amistosa
	 * 
	 * @return respuestaAmistosa
	 */
	public String getRespuestaAmistosa() {
		return respuestaAmistosa;
	}

	/**
	 * Establece una nueva respuesta amistosa
	 * 
	 * @param respuestaAmistosa nueva
	 */
	public void setRespuestaAmistosa(String respuestaAmistosa) {
		this.respuestaAmistosa = respuestaAmistosa;
	}

	/**
	 * Obtiene el tipo de respuesta neutral
	 * 
	 * @return respuestaNeutral
	 */
	public String getRespuestaNeutral() {
		return respuestaNeutral;
	}

	/**
	 * Establece una nueva respuesta neutral
	 * 
	 * @param respuestaNeutral nueva
	 */
	public void setRespuestaNeutral(String respuestaNeutral) {
		this.respuestaNeutral = respuestaNeutral;
	}

	/**
	 * Obtiene el tipo de respuesta agresiva
	 * 
	 * @return respuestaAgresiva
	 */
	public String getRespuestaAgresiva() {
		return respuestaAgresiva;
	}

	/**
	 * Establece una nueva respuesta agresiva
	 * 
	 * @param respuestaAgresiva nueva
	 */
	public void setRespuestaAgresiva(String respuestaAgresiva) {
		this.respuestaAgresiva = respuestaAgresiva;
	}

	/**
	 * Función usada para atacar al protagonista del juego
	 * 
	 * @param p protagonista
	 */
	public void atacar(Protagonista p) {
		p.bajarVida((short) new Random().nextInt(this.getAtaque()));
		//p.bajarVida((short) 100);
		if (p.getVida() <= 0) {
			p.setVida((short) 0);
		}
	}
	
	/**
	 * Función que ejecuta un ataque especial aleatoriamente que es el doble del normal
	 * @param p protagonista
	 */
	public void ataqueEspecial(Protagonista p) {
		p.bajarVida((short) (2*this.getAtaque()));
		if (p.getVida() <= 0) {
			p.setVida((short) 0);
		}
	}
	
	/**
	 * Función a usar cuando el protagonista se tome una poción y baja el ataque del enemigo
	 * @param p protagonista
	 */
	public void atacarConPocion (Protagonista p) {
		p.bajarVida((short) (this.getAtaque() - p.getReductorDaño()));
		if (p.getVida() <= 0) {
			p.setVida((short) 0);
		}
	}
}
