package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaFinDemo extends JPanel{

	private Ventana ventana;
	
	public PantallaFinDemo (Ventana v) {
		this.ventana = v;
		setLayout(null);
		
		JLabel labelTexto = new JLabel("\u00A1Gracias por jugar a la demo de 404!");
		labelTexto.setForeground(new Color(0, 0, 0));
		labelTexto.setFont(new Font("MS Gothic", Font.BOLD, 30));
		labelTexto.setHorizontalAlignment(SwingConstants.CENTER);
		labelTexto.setBounds(96, 56, 592, 121);
		add(labelTexto);
		
		JLabel labelSalir = new JLabel("Salir del juego");
		labelSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labelSalir.setForeground(new Color(255,0,112));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelSalir.setForeground(new Color(0,0,0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		labelSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelSalir.setForeground(new Color(0,0,0));
		labelSalir.setFont(new Font("MS Gothic", Font.BOLD, 30));
		labelSalir.setBounds(509, 577, 254, 69);
		add(labelSalir);
		
		JLabel labelFondo = new JLabel("");
		labelFondo.setIcon(new ImageIcon("F:\\Mamen\\1DAM\\GitHub\\Programaci\u00F3n\\ProyectoFinalProgramacion-Juego404\\imagenes\\finDemo.jpg"));
		labelFondo.setHorizontalAlignment(SwingConstants.CENTER);
		labelFondo.setBounds(0, 0, 800, 700);
		add(labelFondo);
		
		
		
		
	}
}
