package clases;

import java.util.Random;

public class Protagonista extends Personaje{

	public void hablar (Adversario a) {
		
	}
	
	/**
	 * Función para que el protagonista pueda huir de la batalla. Si lo consigue, se vuelve a la pantalla en la que se encontraba.
	 * Si no lo consigue, recibe un ataque del enemigo.
	 * @param a
	 */
	public void huir(Adversario a) {
		Random r = new Random();
		if (r.nextInt(100)>90) {
			//volver a la pantalla
		}else {
			a.atacar();
		}
	}
}
