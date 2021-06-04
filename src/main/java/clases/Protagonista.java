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
 * Clase de los protagonistas del juego que se crean antes de empezar éste
 * 
 * @author Mamen Arias
 *
 */
public class Protagonista extends Personaje {

	private boolean genero; // genero del protagonista
	private byte nPantalla; // nº de pantalla en el que se ha quedado el protagonista
	private Ventana ventana; // ventana del juego
	private byte reductorDaño; // al tomar la poción de defensa, el ataque del enemigo se reducirá esta cantidad

	/**
	 * Constructor de la clase Protagonista
	 * 
	 * @param nombre nombre del protagonista
	 * @param genero genero del prota
	 * @param vida   vida del prota
	 * @param ataque ataque del prota
	 * @throws NombreVacioException excepción cuando el nombre del enemigo está en blanco
	 * @throws NombreConNumerosException excepción cuando el nombre del enemigo contiene números
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
	 * @throws NombreVacioException      excepción cuando el nombre del enemigo está en blanco
	 * @throws NombreConNumerosException excepción cuando el nombre del enemigo contiene números
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
	 * obtiene el nº de la pantalla en la que se encuentra el prota
	 * 
	 * @return nº Pantalla
	 */
	public byte getnPantalla() {
		return nPantalla;
	}

	/**
	 * establece un nuevo nº pantalla del prota
	 * 
	 * @param nº pantalla nuevo
	 */
	public void setnPantalla(byte nPantalla) {
		this.nPantalla = nPantalla;
	}

	/**
	 * obtiene el género del prota
	 * 
	 * @return género
	 */
	public boolean isGenero() {
		return genero;
	}

	/**
	 * establece un nuevo género
	 * 
	 * @param género nuevo
	 */
	public void setGenero(boolean genero) {

		this.genero = genero;
	}

	
	/**
	 * obtiene la reducción de daño al usar la poción defensiva
	 * @return reducción de daño
	 */
	public byte getReductorDaño() {
		return reductorDaño;
	}

	/**
	 * establece una nueva reducción de daño
	 * @param reductorDaño nuevo
	 */
	public void setReductorDaño(byte reductorDaño) {
		this.reductorDaño = reductorDaño;
	}

	/**
	 * Función para que el protagonista pueda huir de la batalla. Si lo consigue, se
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
	 * Función en la que el protagonista va a atacar al enemigo. Si la vida del
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
				JOptionPane.showMessageDialog(ventana, "Parece que se ha caído una llave...", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(ventana, "Has vencido", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	/**
	 * Función para atacar al enemigo mediante la opción hablar en lugar de atacar.
	 * Cuando escojamos la opción correcta, le quitaremos cierta cantidad de vida al
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
	 * Función para el uso de pociones por parte del personaje
	 * @param p poción
	 * @param habilidadPocion cantidad de efecto de la poción
	 * @param a enemigo sobre el que aplicar la poción
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
