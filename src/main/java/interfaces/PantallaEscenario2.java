package interfaces;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

import clases.Adversario;
import clases.Curativa;
import clases.DeAtaque;
import enumeraciones.Enemigos;
import enumeraciones.Pociones;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

/**
 * Interfaz de la segunda pantalla del juego
 * 
 * @author Mamen Arias
 *
 */
public class PantallaEscenario2 extends JPanel {

	private Ventana ventana; // ventana
	private boolean llave; // llave para avanzar de escenario

	/**
	 * Constructor de la clase PantallaEscenario2 con todas las características de
	 * la interfaz
	 * 
	 * @param v ventana
	 */
	public PantallaEscenario2(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		// lo primero que hacemos al pasar a esta pantalla, es hacer un guardado del
				// personaje en la base de datos, para que al cargar, aparezca aquí directamente
				Connection c;
				try {
					c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proyectoprogramacion", "root",
							"fire_emblem3.");

					Statement smt = c.createStatement();

					smt.executeUpdate("update protagonista set pantalla=2, vida=" + ventana.protagonista.getVida()
							+ " where nombre='" + ventana.protagonista.getNombre() + "';");

					smt.close();
					c.close();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		JPanel panelCentral = new JPanel();
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);
		
		JTextPane textoJuego = new JTextPane();
		textoJuego.setText("\r\nParece que vas a tener que buscar otra llave para salir de aqu\u00ED, otra vez...");
		textoJuego.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		textoJuego.setEditable(false);
		textoJuego.setForeground(new Color(255, 255, 255));
		textoJuego.setBackground(new Color(0, 0, 0));
		textoJuego.setBounds(0, 595, 800, 107);
		panelCentral.add(textoJuego);
		
		JLabel labelPuerta = new JLabel("");
		labelPuerta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (llave) {
					int opcionSalir = JOptionPane.showConfirmDialog(ventana,
							"No podrás volver, ¿estás seguro que deseas continuar?", "Aviso",
							JOptionPane.YES_NO_OPTION);
					if (opcionSalir == JOptionPane.YES_OPTION) {
						ventana.irAPantallaFinDemo();
					}
				} else {
					textoJuego.setText("\r\nPuerta Cerrada");
				}
			}
		});
		labelPuerta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelPuerta.setBounds(368, 162, 135, 322);
		panelCentral.add(labelPuerta);
		
		//Poción de ataque 
		JLabel labelPocionManzana = new JLabel("");
		labelPocionManzana.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!ventana.pocionesTomadas.contains(Pociones.DEATAQUE)) {
					try {
						ventana.pocion = new DeAtaque("Manzana", Pociones.DEATAQUE, (short) 50);
						int opcionPocion = JOptionPane.showConfirmDialog(ventana,
								"Has encontrado una " + ventana.pocion.getNombre() + ", ¿quieres tomártela?",
								"Poción encontrada", JOptionPane.YES_NO_OPTION);
						if (opcionPocion == JOptionPane.YES_OPTION) {
								ventana.protagonista.usoDePociones(ventana.pocion, (short) 50, ventana.enemigo);
								textoJuego.setText(
										"\r\nPerfecto, te vendrá bien para la batalla.");
								ventana.pocionesTomadas.add(ventana.pocion.getTipoPocion());
						}
					} catch (NombreVacioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NombreConNumerosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					textoJuego.setText("\r\nYa te has tomado la poción, será mejor que busques otra.");
				}
			}
		});
		labelPocionManzana.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelPocionManzana.setBounds(101, 387, 78, 97);
		panelCentral.add(labelPocionManzana);
		
		JLabel labelEnemigo = new JLabel("");
		labelEnemigo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!ventana.enemigosDerrotados.contains(Enemigos.BUG)) {
					try {
						ventana.enemigo = new Adversario("Glitchy", (short) 300, (short) 100, Enemigos.BUG,
								"¡ES MUY EFECTIVO!", "WannaCry se ríe en tu cara...",
								"WannaCry parece contento... pero quiere más y te ataca para conseguirlo.");
					} catch (NombreVacioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NombreConNumerosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ventana.irAPantallaBatalla();
				} else {
					textoJuego.setText("\r\nYa has derrotado a Glitchy, tu ordenador está en perfecto estado.");
				}
			}
		});
		
		labelEnemigo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelEnemigo.setBounds(217, 170, 78, 97);
		panelCentral.add(labelEnemigo);
		
		JLabel labelFondo = new JLabel("");
		labelFondo.setIcon(new ImageIcon("F:\\Mamen\\1DAM\\GitHub\\Programaci\u00F3n\\ProyectoFinalProgramacion-Juego404\\imagenes\\salon.jpg"));
		labelFondo.setBounds(0, -52, 800, 702);
		panelCentral.add(labelFondo);
		
	}
}
