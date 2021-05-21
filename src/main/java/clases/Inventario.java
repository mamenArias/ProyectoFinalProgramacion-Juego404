package clases;

import java.util.ArrayList;

public class Inventario {

	ArrayList<Pocion> pocionAUsar;

	/**
	 * @param pocionAUsar
	 */
	public Inventario(ArrayList<Pocion> pocionAUsar) {
		super();
		this.pocionAUsar = pocionAUsar;
	}

	/**
	 * @return the pocionAUsar
	 */
	public ArrayList<Pocion> getPocionAUsar() {
		return pocionAUsar;
	}

	/**
	 * @param pocionAUsar the pocionAUsar to set
	 */
	public void setPocionAUsar(ArrayList<Pocion> pocionAUsar) {
		this.pocionAUsar = pocionAUsar;
	}
	
	
}
