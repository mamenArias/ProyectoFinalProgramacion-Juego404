package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;

/**
 * Pantalla en la que tenemos que introducir una clave para abrir la puerta que avanza al siguiente escenario.
 * @author Mamen Arias
 *
 */
public class PantallaOrdenador extends JPanel{

	private Ventana ventana; // ventana
	private JTextField campoClave; // campo de texto donde introducimos la clave
	//private String clavePuerta; // 
	
	/**
	 * Constructor de la clase PantallaOrdenador con todas las características de la interfaz
	 * 
	 * @param v ventana
	 */
	public PantallaOrdenador (Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(0, 0, 0));
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);
		
		JTextPane textoInformativo = new JTextPane();
		textoInformativo.setAlignmentY(CENTER_ALIGNMENT);
		textoInformativo.setEditable(false);
		textoInformativo.setText("  Introduzca la clave:");
		textoInformativo.setForeground(new Color(255, 255, 255));
		textoInformativo.setBackground(new Color(0, 102, 255));
		textoInformativo.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		textoInformativo.setBounds(202, 206, 388, 41);
		panelCentral.add(textoInformativo);
		
		campoClave = new JTextField();
		campoClave.setFont(new Font("Agency FB", Font.BOLD, 30));
		campoClave.setHorizontalAlignment(SwingConstants.CENTER);
		campoClave.setBounds(202, 239, 388, 58);
		panelCentral.add(campoClave);
		campoClave.setColumns(10);
		
		
		JPanel panelBoton = new JPanel();
		panelBoton.setBackground(new Color(255, 255, 255));
		panelBoton.setBounds(202, 297, 388, 41);
		panelCentral.add(panelBoton);
		
				JButton botonClave = new JButton("Comprobar");
				botonClave.setCursor(new Cursor(Cursor.HAND_CURSOR));
				botonClave.setBackground(new Color(0, 153, 0));
				botonClave.setFont(new Font("Maiandra GD", Font.BOLD, 18));
				panelBoton.add(botonClave);
				botonClave.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//clavePuerta = campoClave.getText();
						if (campoClave.getText().equals("7835")) {
							ventana.primeraLlave = true;
							JOptionPane.showMessageDialog(ventana, "¡Clave introducida con éxito!", "Clave correcta", JOptionPane.INFORMATION_MESSAGE);
							ventana.irAPantallaEscenario1();
						} else {
							JOptionPane.showMessageDialog(ventana, "La clave no es correcta. Vuelve a intentarlo.", "Clave errónea", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
		
		JLabel botonExit = new JLabel("");
		botonExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantallaEscenario1();
			}
		});
		botonExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonExit.setHorizontalAlignment(SwingConstants.CENTER);
		botonExit.setBounds(705, 556, 54, 68);
		panelCentral.add(botonExit);
		
		JLabel labelFondo = new JLabel("");
		labelFondo.setIcon(new ImageIcon("imagenes/pantalla.png"));
		labelFondo.setBounds(3, -10, 803, 702);
		labelFondo.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentral.add(labelFondo);
		
	}
}
