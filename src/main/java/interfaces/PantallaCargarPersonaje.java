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

public class PantallaCargarPersonaje extends JPanel{

	private Ventana ventana;
	private JTextField campoNombrePersonaje;
	
	public PantallaCargarPersonaje(Ventana v) {
		this.ventana = v;
		setLayout(null);
		
		JLabel labelNombre = new JLabel("Introduce el nombre de tu personaje:");
		labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombre.setBounds(193, 105, 341, 77);
		add(labelNombre);
		
		campoNombrePersonaje = new JTextField();
		campoNombrePersonaje.setBounds(260, 192, 239, 46);
		add(campoNombrePersonaje);
		campoNombrePersonaje.setColumns(10);
		
		JButton botonBuscar = new JButton("Buscar");
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
		});
		botonBuscar.setBounds(329, 298, 85, 21);
		add(botonBuscar);
		
		
		
		
	}
}
