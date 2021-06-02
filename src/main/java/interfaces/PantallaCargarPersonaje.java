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
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

/**
 * Interfaz para cargar la partida de un personaje ya guardado anteriormente
 * 
 * @author Mamen Arias
 *
 */
public class PantallaCargarPersonaje extends JPanel {

	private Ventana ventana; // ventana

	/**
	 * Constructor de la clase PantallaCargarPersonaje con todas las características
	 * de la interfaz
	 * 
	 * @param v ventana
	 */
	public PantallaCargarPersonaje(Ventana v) {
		setBackground(new Color(0, 0, 0));
		this.ventana = v;
		setLayout(null);

		JLabel labelNombre = new JLabel("Selecciona tu personaje:");
		labelNombre.setFont(new Font("MS UI Gothic", Font.PLAIN, 24));
		labelNombre.setBackground(new Color(0, 0, 0));
		labelNombre.setForeground(new Color(255, 255, 255));
		labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombre.setBounds(199, 46, 382, 77);
		add(labelNombre);

		// un scroll para poder ver todo la lista de personajes guardados
		JScrollPane scrollPersonajes = new JScrollPane();
		scrollPersonajes.setBackground(new Color(255, 255, 255));
		scrollPersonajes.setSize(382, 365);
		scrollPersonajes.setLocation(199, 133);
		add(scrollPersonajes);

		// lista de personajes guardados obtenidos de la base de datos
		JList listaPersonajes = new JList();
		listaPersonajes.setSelectionForeground(new Color(0, 0, 0));
		listaPersonajes.setSelectionBackground(new Color(255, 102, 153));
		listaPersonajes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaPersonajes.setToolTipText("");
		listaPersonajes.setBorder(new LineBorder(new Color(255, 255, 255)));

		Connection c;
		try {
			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proyectoprogramacion", "root",
					"fire_emblem3.");
			Statement smt = c.createStatement();

			// Hacemos la consulta con select buscando los nombres de todos los
			// protagonistas:
			ResultSet nombresPersonaje = smt.executeQuery("select nombre from protagonista;");

			// recorremos la base de datos para almacenar todos los nombres en el arraylist
			// de personajes guardados
			while (nombresPersonaje.next()) {

				String nombre = nombresPersonaje.getString("nombre");

				ventana.personajesRegistrados.add(nombre);
			}

			listaPersonajes.setModel(new AbstractListModel() {

				public int getSize() {
					return ventana.personajesRegistrados.size(); // tamaño del array list
				}

				public Object getElementAt(int index) {
					return ventana.personajesRegistrados.get(index); // obtiene los valores del array list
				}
			});

			smt.close();
			c.close();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		listaPersonajes.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		listaPersonajes.setForeground(new Color(255, 255, 255));
		listaPersonajes.setBackground(new Color(0, 0, 0));
		listaPersonajes.setBounds(199, 328, 397, 244);
		scrollPersonajes.setViewportView(listaPersonajes);
		// add(listaPersonajes);

		// botón para cargar el personaje y mandarnos a la pantalla en la que se haya
		// quedado durante el juego
		JButton botonCargar = new JButton("Cargar");
		botonCargar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonCargar.setForeground(new Color(255, 255, 255));
		botonCargar.setFont(new Font("MS UI Gothic", Font.BOLD, 24));
		botonCargar.setBorderPainted(false);
		botonCargar.setBackground(new Color(255, 0, 102));
		botonCargar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Cogemos de la lista de personajes que hemos cargado el nombre seleccionado
				// para hacer la consulta en la base de datos y cargar la partida
				String personaje = (String) listaPersonajes.getSelectedValue();

				Connection c;
				try {
					c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proyectoprogramacion", "root",
							"fire_emblem3.");

					Statement smt = c.createStatement();

					ResultSet datosPersonaje = smt
							.executeQuery("select * from protagonista where nombre='" + personaje + "';");

					if (datosPersonaje.next()) {
						personaje = datosPersonaje.getString("nombre");
						boolean genero = datosPersonaje.getBoolean("genero");
						short vida = datosPersonaje.getShort("vida");
						short ataque = datosPersonaje.getShort("ataque");
						byte pantalla = datosPersonaje.getByte("pantalla");

						try {
							ventana.protagonista = new Protagonista(personaje, genero, (short) vida, (short) ataque,
									(byte) pantalla);

							if (pantalla == 1) {
								v.irAPantallaEscenario1();
							} else if (pantalla == 2) {
								v.irAPantallaEscenario2();
							}
						} catch (NombreVacioException e1) {
							e1.printStackTrace();
						} catch (NombreConNumerosException e1) {
							e1.printStackTrace();
						}

					} else {
						JOptionPane.showMessageDialog(ventana, "Ese personaje no existe.", "Personaje Not Found",
								JOptionPane.ERROR_MESSAGE);
					}

					smt.close();
					c.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				botonCargar.setForeground(new Color(0, 0, 0));
				botonCargar.setBackground(new Color(255, 102, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonCargar.setForeground(new Color(255, 255, 255));
				botonCargar.setBackground(new Color(255, 0, 112));
			}
		});
		botonCargar.setBounds(327, 536, 140, 46);
		add(botonCargar);

		// botón para volver al menú inicial
		JButton botonVolver = new JButton("Volver");
		botonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.volverAInicio();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				botonVolver.setForeground(new Color(255, 0, 112));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonVolver.setForeground(new Color(255, 255, 255));
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
