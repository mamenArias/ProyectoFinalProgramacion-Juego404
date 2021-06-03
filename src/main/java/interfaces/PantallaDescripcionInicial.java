package interfaces;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Interfaz de la descripción inicial de la historia del juego
 * 
 * @author Mamen Arias
 *
 */
public class PantallaDescripcionInicial extends JPanel {

	private Ventana ventana; // ventana

	/**
	 * Constructor de la clase PantallaDescripcionInicial con todas las
	 * características de la interfaz
	 * 
	 * @param v ventana
	 */
	public PantallaDescripcionInicial(Ventana v) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 0, 0));
		this.ventana = v;
		setLayout(null);

		// texto descriptivo de la historia del juego
		JLabel labelDescripcion = new JLabel(
				"<html><body style=\"text-align: center\">Ya son varios d\u00EDas teniendo los mismos sue\u00F1os, sue\u00F1os extra\u00F1os en los que despierto atrapado en otra dimensi\u00F3n. Encerrado en mi propia casa sin saber c\u00F3mo salir y rodeado de criaturas extra\u00F1as.<br>\r\n\u00BFQu\u00E9 est\u00E1 pasando? Quiz\u00E1s paso demasiadas horas trabajando, quiz\u00E1 tanta cafe\u00EDna est\u00E1 empezando a afectarme en mis sue\u00F1os.<br>\r\nEste proyecto me est\u00E1 costando demasiado.. y es que \u00A1arg!<br>\r\nEl cliente no deja de hacer cambios y m\u00E1s cambios, sin escucharnos si quiera. \u00A1Aaaaarg quiero acabar yaaa!<br>\r\nEn fin...</body></html>\r\n");
		labelDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		labelDescripcion.setFont(new Font("MS Gothic", Font.BOLD, 28));
		labelDescripcion.setForeground(new Color(0, 0, 0));
		labelDescripcion.setBackground(new Color(0, 0, 0));
		labelDescripcion.setBounds(45, 10, 715, 444);
		add(labelDescripcion);

		// botón para pasar al primer escenario del juego
		JLabel labelAvanzar = new JLabel(ventana.protagonista.getNombre() + " es hora de despertar... otra vez.");
		labelAvanzar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labelAvanzar.setForeground(new Color(255, 0, 112));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labelAvanzar.setForeground(new Color(0, 0, 0));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantallaEscenario1();
			}
		});
		labelAvanzar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelAvanzar.setForeground(new Color(0, 0, 0));
		labelAvanzar.setFont(new Font("MS Gothic", Font.BOLD, 28));
		labelAvanzar.setHorizontalAlignment(SwingConstants.RIGHT);
		labelAvanzar.setBounds(10, 561, 750, 72);
		add(labelAvanzar);

		// imagen de fondo
		JLabel labelFondo = new JLabel("");
		labelFondo.setIcon(new ImageIcon(
				"F:\\Mamen\\1DAM\\GitHub\\Programaci\u00F3n\\ProyectoFinalProgramacion-Juego404\\imagenes\\fondoDescripcion.jpg"));
		labelFondo.setBounds(0, 0, 808, 703);
		add(labelFondo);

	}
}
