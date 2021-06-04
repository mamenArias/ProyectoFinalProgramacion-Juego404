package clases;

import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import enumeraciones.Enemigos;
import enumeraciones.Pociones;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;
import hilos.HiloBatalla;
import interfaces.Ventana;

/**
 * Clase de los protagonistas del juego que se crean antes de empezar �ste
 * 
 * @author Mamen Arias
 *
 */
public class Protagonista extends Personaje {

	private boolean genero; // genero del protagonista
	private byte nPantalla; // n� de pantalla en el que se ha quedado el protagonista
	private Ventana ventana; // ventana del juego
	private byte reductorDa�o; // al tomar la poci�n de defensa, el ataque del enemigo se reducir� esta cantidad

	/**
	 * Constructor de la clase Protagonista
	 * 
	 * @param nombre nombre del protagonista
	 * @param genero genero del prota
	 * @param vida   vida del prota
	 * @param ataque ataque del prota
	 * @throws NombreVacioException excepci�n cuando el nombre del enemigo est� en blanco
	 * @throws NombreConNumerosException excepci�n cuando el nombre del enemigo contiene n�meros
	 */
	public Protagonista(String nombre, boolean genero, short vida, short ataque)
			throws NombreVacioException, NombreConNumerosException {
		super(nombre);
		this.genero = genero;
		super.setVida(vida);
		super.setAtaque(ataque);
		this.nPantalla = 1;
	}

	/**
	 * Constructor de la clase Protagonista
	 * 
	 * @param nombre   nombre del protagonista
	 * @param genero   genero del prota
	 * @param vida     vida del prota
	 * @param ataque   ataque del prota
	 * @param pantalla pantalla actual del protagonista
	 * @throws NombreVacioException      excepci�n cuando el nombre del enemigo est� en blanco
	 * @throws NombreConNumerosException excepci�n cuando el nombre del enemigo contiene n�meros
	 */
	public Protagonista(String nombre, boolean genero, short vida, short ataque, byte pantalla)
			throws NombreVacioException, NombreConNumerosException {
		super(nombre);
		this.genero = genero;
		super.setVida(vida);
		super.setAtaque(ataque);
		this.nPantalla = pantalla;
	}

	/**
	 * obtiene el n� de la pantalla en la que se encuentra el prota
	 * 
	 * @return n� Pantalla
	 */
	public byte getnPantalla() {
		return nPantalla;
	}

	/**
	 * establece un nuevo n� pantalla del prota
	 * 
	 * @param n� pantalla nuevo
	 */
	public void setnPantalla(byte nPantalla) {
		this.nPantalla = nPantalla;
	}

	/**
	 * obtiene el g�nero del prota
	 * 
	 * @return g�nero
	 */
	public boolean isGenero() {
		return genero;
	}

	/**
	 * establece un nuevo g�nero
	 * 
	 * @param g�nero nuevo
	 */
	public void setGenero(boolean genero) {

		this.genero = genero;
	}

	
	/**
	 * obtiene la reducci�n de da�o al usar la poci�n defensiva
	 * @return reducci�n de da�o
	 */
	public byte getReductorDa�o() {
		return reductorDa�o;
	}

	/**
	 * establece una nueva reducci�n de da�o
	 * @param reductorDa�o nuevo
	 */
	public void setReductorDa�o(byte reductorDa�o) {
		this.reductorDa�o = reductorDa�o;
	}

	/**
	 * Funci�n para que el protagonista pueda huir de la batalla. Si lo consigue, se
	 * vuelve a la pantalla en la que se encontraba. Si no lo consigue, recibe un
	 * ataque del enemigo.
	 * 
	 * @param a enemigo
	 */
	public void huir(Adversario a, Protagonista p, JLabel batalla, JLabel vida, Ventana v, HiloBatalla h) {
		if (new Random().nextInt(100) > 70) {
			if (a.getTipoEnemigo() == Enemigos.PATITO
					|| a.getTipoEnemigo() == Enemigos.VIRUS) {
				h.parar();
				v.irAPantallaEscenario1();
			} else if (a.getTipoEnemigo() == Enemigos.BUG
					|| a.getTipoEnemigo() == Enemigos.USUARIO) {
				h.parar();
				v.irAPantallaEscenario2();
			}
		} else {
			batalla.setText("No has podido huir.");
			a.atacar(p);
			vida.setText("<html><body style='text-align:center'>" + p.getNombre()
					+ ":<br>Vida: " + p.getVida() + "</body></html>");
			if (p.getVida() == 0) {
				h.parar();
				v.irAPantallaGameOver();
			}
		}
	}

	/**
	 * Funci�n en la que el protagonista va a atacar al enemigo. Si la vida del
	 * enemigo llega a 0, sale un aviso indicando que lo hemos vencido
	 * 
	 * @param a enemigo
	 */
	public void atacar(Adversario a) {
		a.bajarVida((short) new Random().nextInt(this.getAtaque()));
		//a.bajarVida(this.getAtaque());
		if (a.getVida() <= 0) {
			a.setVida((short) 0);
			if (a.getTipoEnemigo() == Enemigos.USUARIO) {
				JOptionPane.showMessageDialog(ventana, "Parece que se ha ca�do una llave...", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(ventana, "Has vencido", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	/**
	 * Funci�n para atacar al enemigo mediante la opci�n hablar en lugar de atacar.
	 * Cuando escojamos la opci�n correcta, le quitaremos cierta cantidad de vida al
	 * enemigo, hasta derrotarlo
	 * 
	 * @param a      vida
	 * @param ataque ataque realizado sobre el enemigo
	 */
	public void ataqueHablando(Adversario a, short ataque) {
		a.bajarVida(ataque);
		if (a.getVida() <= 0) {
			a.setVida((short) 0);
			JOptionPane.showMessageDialog(ventana, "Has vencido", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	
	/**
	 * Funci�n para el uso de pociones por parte del personaje
	 * @param p poci�n
	 * @param habilidadPocion cantidad de efecto de la poci�n
	 * @param a enemigo sobre el que aplicar la poci�n
	 */
	public void usoDePociones(Pocion p, short habilidadPocion, Adversario a) {
		if (p.getTipoPocion() == Pociones.CURATIVA) {
			super.setVida(((short) (super.getVida() + habilidadPocion)));
			if (super.getVida() > 500) {
				super.setVida((short)500);;
			}
		} else if (p.getTipoPocion() == Pociones.DEATAQUE) {
			super.setAtaque((short) (super.getAtaque() + habilidadPocion));
		}
	}

}
