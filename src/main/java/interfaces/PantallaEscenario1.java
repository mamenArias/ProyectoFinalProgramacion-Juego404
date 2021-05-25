package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import clases.Adversario;
import clases.Curativa;
import clases.Pocion;
import enumeraciones.Enemigos;
import enumeraciones.Pociones;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

public class PantallaEscenario1 extends JPanel {

	private Ventana ventana;
	private boolean llave;
	private Adversario enemigo;

	public PantallaEscenario1(Ventana v) {
		this.ventana = v;
		llave = false;
		setLayout(new BorderLayout(0, 0));

		JPanel panelCentral = new JPanel();

		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		JTextPane textoJuego = new JTextPane();
		textoJuego.setLocation(0, 600);
		panelCentral.add(textoJuego);
		textoJuego.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		textoJuego.setForeground(new Color(255, 255, 255));
		textoJuego.setBackground(new Color(0, 0, 0));
		textoJuego.setSize(802, 120);

		JLabel labelSilla = new JLabel("");
		labelSilla.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelSilla.setBackground(new Color(153, 255, 0));
		labelSilla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textoJuego.setText("No es momento de ponerse a trabajar, busca la forma de salir de aquí.");
			}
		});
		// labelSIlla.setOpaque(false);
		labelSilla.setBounds(150, 225, 80, 100);
		labelSilla.setSize(80, 150);
		panelCentral.add(labelSilla);

		JLabel labelEnemigo = new JLabel("");
		labelEnemigo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ventana.enemigo = new Adversario("Donaldo", (short)200, (short)100, Enemigos.PATITO);
				} catch (NombreVacioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NombreConNumerosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ventana.irAPantallaBatalla();
			}
		});
		
		labelEnemigo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelEnemigo.setBounds(100, 350, 45, 45);
		panelCentral.add(labelEnemigo);


		JLabel labelLlave = new JLabel("");
		labelLlave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textoJuego.setText("¡Has encontrado la llave! Prueba a salir de la habitación.");
				llave = true;
			}
		});
		labelLlave.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelLlave.setBounds(490, 210, 45, 40);
		panelCentral.add(labelLlave);

		JLabel labelPuerta = new JLabel("");
		labelPuerta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (llave) {
					JOptionPane.showConfirmDialog(ventana, "No podrás volver, ¿estás seguro que deseas continuar?",
							"Aviso", JOptionPane.OK_CANCEL_OPTION);
					v.irAPantallaEscenario2();
					// JOptionPane.showMessageDialog(ventana, "No podrás volver a esta habitación,
					// ¿estás seguro que deseas salir?", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				} else {
					textoJuego.setText("Puerta Cerrada");
				}
			}
		});
		labelPuerta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelPuerta.setBounds(679, 225, 111, 309);
		panelCentral.add(labelPuerta);

		JLabel labelEnemigo2 = new JLabel("");
		labelEnemigo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					v.enemigo = new Adversario("DSADFS", (short)300, (short)100, Enemigos.VIRUS);
				} catch (NombreVacioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NombreConNumerosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ventana.irAPantallaBatalla();
			}
		});
		labelEnemigo2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelEnemigo2.setBounds(231, 178, 118, 106);
		panelCentral.add(labelEnemigo2);
		
		JLabel labelPocion1 = new JLabel("");
		labelPocion1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*try {
					Pocion galleta = new Curativa("Galleta", Pociones.CURATIVA, (byte)30);
					ArrayList<Pocion >inventario = ventana.protagonista.getInventario();
					inventario.add(galleta);
					
					Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proyectoprogramacion",
							"root", "fire_emblem3.");
					Statement smt = c.createStatement();
					
					
					smt.executeUpdate("insert into pocion values ('" + galleta.getNombre()
					+ "'," + ventana.protagonista.isGenero() + "," + ventana.protagonista.getVida()
					+ "," + ventana.protagonista.getAtaque() + "," + ventana.protagonista.getnPantalla()
					+ ");");
					
					smt.close();
					c.close();
					
					
				} catch (NombreVacioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NombreConNumerosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
			}
		});
		labelPocion1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelPocion1.setBounds(375, 409, 88, 68);
		panelCentral.add(labelPocion1);
		
		JLabel labelFondo = new JLabel("");
		labelFondo.setBackground(new Color(0, 0, 0));
		labelFondo.setIcon(new ImageIcon(
				"F:\\Mamen\\1DAM\\GitHub\\Programaci\u00F3n\\ProyectoFinalProgramacion-Juego404\\imagenes\\habitacion2.jpg"));
		labelFondo.setHorizontalAlignment(SwingConstants.CENTER);
		labelFondo.setBounds(0, 0, 800, 600);
		// labelFondo.setSize(800, 600);
		panelCentral.add(labelFondo);
		
		
		
		

	}
}
