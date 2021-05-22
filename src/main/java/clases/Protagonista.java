package clases;

import java.util.Random;

import javax.swing.JOptionPane;

import enumeraciones.Enemigos;
import excepciones.NombreVacioException;
import interfaces.Ventana;

public class Protagonista extends Personaje {

	private boolean genero;
	private byte nPantalla;
	private Ventana ventana;

	/**
	 * Constructo de la clase Protagonista, donde vamos a establecer su nombre, su
	 * nivel de vida y su ataque básico.
	 * 
	 * @param nombre nombre del personaje
	 * @throws NombreVacioException
	 */
	public Protagonista(String nombre, boolean genero, short vida, short ataque) throws NombreVacioException {
		super(nombre);
		this.genero = genero;
		super.setVida(vida);
		super.setAtaque(ataque);
		this.nPantalla = 1;
	}

	
	/**
	 * @return the nPantalla
	 */
	public byte getnPantalla() {
		return nPantalla;
	}


	/**
	 * @param nPantalla the nPantalla to set
	 */
	public void setnPantalla(byte nPantalla) {
		this.nPantalla = nPantalla;
	}


	/**
	 * @return the genero
	 */
	public boolean isGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(boolean genero) {

		this.genero = genero;
	}

	public void hablar(Adversario a) {

	}

	/**
	 * Función para que el protagonista pueda huir de la batalla. Si lo consigue, se
	 * vuelve a la pantalla en la que se encontraba. Si no lo consigue, recibe un
	 * ataque del enemigo.
	 * 
	 * @param a
	 */
	public void huir(Adversario a) {
		Random r = new Random();
		if (r.nextInt(100) > 90) {
			if (a.getTipoEnemigo() == Enemigos.PATITO) {
				ventana.irAPantallaEscenario1();
			}
		} else {
			JOptionPane.showMessageDialog(ventana, "No puedes escapar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			//a.atacar();
		}
	}
	
	public void atacar(Adversario a) {
		a.bajarVida(this.getAtaque());
		if (a.getVida() <= 0) {
			a.setVida((short)0);
			JOptionPane.showMessageDialog(ventana, "Has vencido", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
