package clases;

import enumeraciones.Enemigos;
import enumeraciones.TonoRespuesta;
import excepciones.NombreVacioException;

public class Adversario extends Personaje{

	private Enemigos tipoEnemigo;
	private TonoRespuesta respuesta;
	private String respuestaAmistosa;
	private String respuestaNeutral;
	private String respuestaAgresiva;
	

	/**
	 * Constructor de la clase Adversario
	 * @param nombre nombre del enemigo
	 * @param vida nivel de vida
	 * @param ataque cantidad de ataque
	 * @param tipoEnemigo tipo de enemigo
	 * @param respuesta 
	 * @param respuestaAmistosa respuesta cuando elegimos la opción correcta
	 * @param respuestaNeutral respuesta cuando elegimos la opción neutra
	 * @param respuestaAgresiva respuesta cuando elegimos la opción incorrecta
	 * @throws NombreVacioException 
	 */
	public Adversario(String nombre, Short vida, Short ataque, Enemigos tipoEnemigo, TonoRespuesta respuesta,
			String respuestaAmistosa, String respuestaNeutral, String respuestaAgresiva) throws NombreVacioException {
		super(nombre);
		super.setVida(vida);
		super.setAtaque(ataque);
		this.tipoEnemigo = tipoEnemigo;
		this.respuesta = respuesta;
		this.respuestaAmistosa = respuestaAmistosa;
		this.respuestaNeutral = respuestaNeutral;
		this.respuestaAgresiva = respuestaAgresiva;
	}
	
	public Adversario(String nombre, short vida, short ataque, Enemigos tipoEnemigo) throws NombreVacioException {
		super(nombre);
		super.setVida(vida);
		super.setAtaque(ataque);
		this.tipoEnemigo = tipoEnemigo;
	}
	/**
	 * @return the tipoEnemigo
	 */
	public Enemigos getTipoEnemigo() {
		return tipoEnemigo;
	}
	/**
	 * @param tipoEnemigo the tipoEnemigo to set
	 */
	public void setTipoEnemigo(Enemigos tipoEnemigo) {
		this.tipoEnemigo = tipoEnemigo;
	}
	/**
	 * @return the respuesta
	 */
	public TonoRespuesta getRespuesta() {
		return respuesta;
	}
	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(TonoRespuesta respuesta) {
		this.respuesta = respuesta;
	}
	/**
	 * @return the respuestaAmistosa
	 */
	public String getRespuestaAmistosa() {
		return respuestaAmistosa;
	}
	/**
	 * @param respuestaAmistosa the respuestaAmistosa to set
	 */
	public void setRespuestaAmistosa(String respuestaAmistosa) {
		this.respuestaAmistosa = respuestaAmistosa;
	}
	/**
	 * @return the respuestaNeutral
	 */
	public String getRespuestaNeutral() {
		return respuestaNeutral;
	}
	/**
	 * @param respuestaNeutral the respuestaNeutral to set
	 */
	public void setRespuestaNeutral(String respuestaNeutral) {
		this.respuestaNeutral = respuestaNeutral;
	}
	/**
	 * @return the respuestaAgresiva
	 */
	public String getRespuestaAgresiva() {
		return respuestaAgresiva;
	}
	/**
	 * @param respuestaAgresiva the respuestaAgresiva to set
	 */
	public void setRespuestaAgresiva(String respuestaAgresiva) {
		this.respuestaAgresiva = respuestaAgresiva;
	}
	
	public void atacar(Protagonista p) {
		p.bajarVida(this.getAtaque());
		if (p.getVida() <= 0) {
			p.setVida((short)0);
		}
	}
}
