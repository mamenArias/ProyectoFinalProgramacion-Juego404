package hilos;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase que instancia un objeto tipo HiloTexto que hereda de Thread.
 * @author Mamen Arias
 *
 */
public class HiloTexto extends Thread{

	private JLabel batalla; // label del texto de batalla que va a ir cambiando
	private JLabel vidaProta; // label con la vida del prota
	private JPanel menu; // menú con las opciones del juego
	private String mns1; // primer mensaje que va a aparecer
	private String mns2; // segundo mensaje que va a aparecer
	
	/**
	 * Función que se ejecuta al iniciar el hilo
	 */
	public void run(){
		menu.setVisible(false);
		vidaProta.setVisible(false);
		batalla.setVisible(true);
		batalla.setText(mns1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		batalla.setText(mns2);
		vidaProta.setVisible(true);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		batalla.setVisible(false);
		menu.setVisible(true);
	}
	
	
	/**
	 * Constructor de la clase HiloTexto
	 * @param batalla label de batalla que va cambiando
	 * @param vidaProta label con la vida del protagonista
	 * @param menu opciones para usar durante el combate
	 * @param mns1 primer mensaje mostrado
	 * @param mns2 segundo mensaje mostrado
	 */
	public HiloTexto(JLabel batalla, JLabel vidaProta, JPanel menu, String mns1, String mns2) {
		super();
		this.batalla = batalla;
		this.vidaProta = vidaProta;
		this.menu = menu;
		this.mns1 = mns1;
		this.mns2 = mns2;
	}

	
}
