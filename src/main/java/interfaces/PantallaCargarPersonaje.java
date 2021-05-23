package interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import clases.Protagonista;
import excepciones.NombreVacioException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

public class PantallaCargarPersonaje extends JPanel{

	private Ventana ventana;
	private JTextField campoNombrePersonaje;
	
	public PantallaCargarPersonaje(Ventana v) {
		setBackground(new Color(0, 0, 0));
		this.ventana = v;
		setLayout(null);
		
		JLabel labelNombre = new JLabel("Introduce el nombre de tu personaje:");
		labelNombre.setFont(new Font("MS UI Gothic", Font.PLAIN, 24));
		labelNombre.setBackground(new Color(0, 0, 0));
		labelNombre.setForeground(new Color(255, 255, 255));
		labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombre.setBounds(199, 211, 382, 77);
		add(labelNombre);
		
		campoNombrePersonaje = new JTextField();
		campoNombrePersonaje.setFont(new Font("MS UI Gothic", Font.PLAIN, 22));
		campoNombrePersonaje.setHorizontalAlignment(SwingConstants.CENTER);
		campoNombrePersonaje.setForeground(new Color(255, 0, 102));
		campoNombrePersonaje.setBackground(new Color(0, 0, 0));
		campoNombrePersonaje.setBounds(199, 298, 382, 46);
		add(campoNombrePersonaje);
		campoNombrePersonaje.setColumns(10);
		
		JButton botonBuscar = new JButton("Buscar");
		botonBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonBuscar.setForeground(new Color(255, 255, 255));
		botonBuscar.setFont(new Font("MS UI Gothic", Font.BOLD, 24));
		botonBuscar.setBorderPainted(false);
		botonBuscar.setBackground(new Color(255, 0, 102));
		botonBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String personaje = campoNombrePersonaje.getText();
				
				Connection c;
				try {
					c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proyectoprogramacion", "root",
							"fire_emblem3.");
					
					Statement smt = c.createStatement();
					
					ResultSet datosPersonaje = smt.executeQuery("select * from protagonista where nombre='" + personaje + "';");
					
					if(datosPersonaje.next()) {
						personaje = datosPersonaje.getString("nombre");
						boolean genero = datosPersonaje.getBoolean("genero");
						short vida = datosPersonaje.getShort("vida");
						short ataque = datosPersonaje.getShort("ataque");
						byte pantalla = datosPersonaje.getByte("pantalla");
						
						try {
							ventana.protagonista = new Protagonista(personaje, genero, (short)vida, (short)ataque, (byte)pantalla);
							
							if (pantalla == 1) {
								v.irAPantallaEscenario1();
							}
							
							if (pantalla == 2) {
								v.irAPantallaEscenario2();
							}
						} catch (NombreVacioException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					} else {
						JOptionPane.showMessageDialog(ventana, "Ese personaje no existe.", "Personaje Not Found", JOptionPane.ERROR_MESSAGE);
					}
					
					smt.close();
					c.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				botonBuscar.setForeground(new Color(0,0,0));
				botonBuscar.setBackground(new Color(255,102,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botonBuscar.setForeground(new Color(255, 255, 255));
				botonBuscar.setBackground(new Color(255, 0, 112));
			}
		});
		botonBuscar.setBounds(321, 389, 140, 46);
		add(botonBuscar);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.volverAInicio();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				botonVolver.setForeground(new Color(255,0,112));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botonVolver.setForeground(new Color(255,255,255));
			}
		});
		botonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonVolver.setFocusable(false);
		botonVolver.setContentAreaFilled(false);
		botonVolver.setBorderPainted(false);
		botonVolver.setFont(new Font("MS UI Gothic", Font.PLAIN, 22));
		botonVolver.setForeground(new Color(255, 255, 255));
		botonVolver.setBackground(new Color(0, 0, 0));
		botonVolver.setBounds(660, 610, 132, 46);
		add(botonVolver);
		
		
		
		
	}
}
