package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyleConstants;
import javax.swing.JTextArea;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import java.awt.FlowLayout;

public class PantallaInicio extends JPanel {

	private Ventana ventana;

	public PantallaInicio(Ventana v) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 0, 0));
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		JLabel labelLogoJuego = new JLabel("");
		labelLogoJuego.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogoJuego.setIcon(new ImageIcon("imagenes//titulo.png"));
		Border border = labelLogoJuego.getBorder();
		Border margin = new EmptyBorder(60,0,0,0);
		labelLogoJuego.setBorder(new CompoundBorder(border, margin));
		add(labelLogoJuego, BorderLayout.NORTH);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setForeground(new Color(255, 255, 255));
		panelCentral.setBackground(new Color(0, 0, 0));
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);
		
		final JButton botonNuevoPersonaje = new JButton("Nuevo Personaje");
		botonNuevoPersonaje.setContentAreaFilled(false);
		botonNuevoPersonaje.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonNuevoPersonaje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botonNuevoPersonaje.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botonNuevoPersonaje.setForeground(new Color(255,255,255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantallaNuevoPersonaje();
			}
		});
		botonNuevoPersonaje.setFont(new Font("MS UI Gothic", Font.PLAIN, 26));
		botonNuevoPersonaje.setForeground(new Color(255, 255, 255));
		botonNuevoPersonaje.setBackground(new Color(0, 0, 0));
		botonNuevoPersonaje.setBounds(269, 92, 261, 39);
		botonNuevoPersonaje.setBorderPainted(false);
		botonNuevoPersonaje.setFocusable(false);
		panelCentral.add(botonNuevoPersonaje);
		
		final JButton botonSalir = new JButton("Salir");
		botonSalir.setContentAreaFilled(false);
		botonSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botonSalir.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botonSalir.setForeground(new Color(255,255,255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {	
				System.exit(0);
			}
		});
		botonSalir.setFont(new Font("MS UI Gothic", Font.PLAIN, 26));
		botonSalir.setForeground(new Color(255, 255, 255));
		botonSalir.setBackground(new Color(0, 0, 0));
		botonSalir.setBounds(279, 190, 244, 39);
		botonSalir.setBorderPainted(false);
		botonSalir.setFocusable(false);
		panelCentral.add(botonSalir);
		
		final JButton botonCargarPersonaje = new JButton("Cargar Personaje");
		botonCargarPersonaje.setContentAreaFilled(false);
		botonCargarPersonaje.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonCargarPersonaje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botonCargarPersonaje.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botonCargarPersonaje.setForeground(new Color(255,255,255));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantallaEscenario1();
				//ir a pantalla de búsqueda de personaje
				//ventana.cargarPartida(ventana.protagonista.getNombre()); esto va en el botón de la nueva pantalla
				//crear personaje con los datos de la base da datos
			}
		});
		botonCargarPersonaje.setFont(new Font("MS UI Gothic", Font.PLAIN, 26));
		botonCargarPersonaje.setForeground(new Color(255, 255, 255));
		botonCargarPersonaje.setBackground(new Color(0, 0, 0));
		botonCargarPersonaje.setBounds(269, 141, 261, 39);
		botonCargarPersonaje.setBorderPainted(false);
		botonCargarPersonaje.setFocusable(false);
		panelCentral.add(botonCargarPersonaje);
		
		JPanel panelInferior = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelInferior.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelInferior.setForeground(new Color(255, 255, 255));
		panelInferior.setBackground(new Color(0, 0, 0));
		add(panelInferior, BorderLayout.SOUTH);
		
		JTextPane textoInformativo = new JTextPane();
		textoInformativo.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		textoInformativo.setForeground(new Color(255, 255, 255));
		textoInformativo.setBackground(new Color(0, 0, 0));
		textoInformativo.setText("M\u00AA Carmen Arias de Haro\r\nProyecto Final de Programaci\u00F3n\r\n1\u00BA DAM");
		panelInferior.add(textoInformativo);
	}
}
