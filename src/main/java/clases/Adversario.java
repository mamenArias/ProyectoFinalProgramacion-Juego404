package clases;

public class Adversario extends Personaje{

	private Enemigos tipoEnemigo;
	private TonoRespuesta respuesta;
	private String respuestaAmistosa;
	private String respuestaNeutral;
	private String respuestaAgresiva;
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
	
	public void atacar() {
		
	}
}
