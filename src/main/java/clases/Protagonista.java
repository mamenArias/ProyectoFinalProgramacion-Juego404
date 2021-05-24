package clases;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import enumeraciones.Enemigos;
import excepciones.NombreConNumerosException;
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
	 * @throws NombreConNumerosException 
	 */
	public Protagonista(String nombre, boolean genero, short vida, short ataque) throws NombreVacioException, NombreConNumerosException {
		super(nombre);
		this.genero = genero;
		super.setVida(vida);
		super.setAtaque(ataque);
		this.nPantalla = 1;
	}
	
	public Protagonista(String nombre, boolean genero, short vida, short ataque, byte pantalla) throws NombreVacioException, NombreConNumerosException {
		super(nombre);
		this.genero = genero;
		super.setVida(vida);
		super.setAtaque(ataque);
		this.nPantalla = pantalla;
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

	public void hablar(JButton b) {
		
		if(b.equals("botonOpcion1")) {
			JOptionPane.showMessageDialog(ventana, "Boton 1", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		} else if (b.equals("botonOpcion2")) {
			JOptionPane.showMessageDialog(ventana, "Boton2", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
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
		a.bajarVida((short)new Random().nextInt(this.getAtaque()));
		if (a.getVida() <= 0) {
			a.setVida((short)0);
			JOptionPane.showMessageDialog(ventana, "Has vencido", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
