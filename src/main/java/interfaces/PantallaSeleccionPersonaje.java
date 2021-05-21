package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class PantallaSeleccionPersonaje extends JPanel {

	private Ventana ventana;
	
	public PantallaSeleccionPersonaje(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
	}
}
