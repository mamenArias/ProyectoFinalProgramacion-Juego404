package clases;

import enumeraciones.Enemigos;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

public class JefeFinal extends Adversario{

	private short ataqueEspecial;

	/**
	 * @param nombre
	 * @param vida
	 * @param ataque
	 * @param tipoEnemigo
	 * @param respuestaAmistosa
	 * @param respuestaNeutral
	 * @param respuestaAgresiva
	 * @param ataqueEspecial
	 * @throws NombreVacioException
	 * @throws NombreConNumerosException
	 */
	public JefeFinal(String nombre, Short vida, Short ataque, Enemigos tipoEnemigo, String respuestaAmistosa,
			String respuestaNeutral, String respuestaAgresiva, short ataqueEspecial)
			throws NombreVacioException, NombreConNumerosException {
		super(nombre, vida, ataque, tipoEnemigo, respuestaAmistosa, respuestaNeutral, respuestaAgresiva);
		this.ataqueEspecial = ataqueEspecial;
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
	public void setAtaqueEspecial() {
		this.ataqueEspecial = (short) (2 * this.getAtaque());
	}
	
	
}
