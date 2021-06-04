package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Interfaz de la pantalla Game Over cuando te matan
 * 
 * @author Mamen Arias
 *
 */
public class PantallaGameOver extends JPanel {

	private Ventana ventana; // ventana

	/**
	 * Constructor de la clase PantallaGameOver con todas las características de la
	 * interfaz
	 * 
	 * @param v ventana
	 */
	public PantallaGameOver(Ventana v) {
		this.ventana = v;
		setLayout(null);

		// botón para volver al menú inicial
		JButton botonVolver = new JButton("Volver a la pantalla de t\u00EDtulo");
		botonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botonVolver.setForeground(new Color(255, 0, 102));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonVolver.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				v.volverAInicio();
			}
		});
		botonVolver.setContentAreaFilled(false);
		botonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonVolver.setFocusable(false);
		botonVolver.setBorderPainted(false);
		botonVolver.setForeground(new Color(255, 255, 255));
		botonVolver.setBackground(new Color(0, 0, 0));
		botonVolver.setFont(new Font("MS UI Gothic", Font.BOLD, 24));
		botonVolver.setBounds(200, 589, 409, 70);
		add(botonVolver);

		// imagen de fondo
		JLabel labelGameOver = new JLabel("");
		labelGameOver.setIcon(new ImageIcon(
				"imagenes/gameover1.jpg"));
		labelGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		labelGameOver.setBounds(0, -96, 801, 788);
		add(labelGameOver);

	}
}
