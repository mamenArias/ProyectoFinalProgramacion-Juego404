package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import clases.Adversario;
import clases.Curativa;
import enumeraciones.Enemigos;
import enumeraciones.Pociones;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

/**
 * Interfaz del primer escenario del juego
 * 
 * @author Mamen Arias
 *
 */
public class PantallaEscenario1 extends JPanel {

	private Ventana ventana; // ventana
	private boolean llave; // llave para abrir la puerta y pasar al siguiente escenario

	/**
	 * Constructor de la clase PantallaEscenario1 con todas las caracter�sticas de
	 * la interfaz
	 * 
	 * @param v ventana
	 */
	public PantallaEscenario1(Ventana v) {
		this.ventana = v;
		llave = false;
		setLayout(new BorderLayout(0, 0));

		JPanel panelCentral = new JPanel();

		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		// texto del juego que ir� cambiando seg�n las interacciones que vayan pasando.
		JTextPane textoJuego = new JTextPane();
		textoJuego.setText("Busca el modo de abrir la puerta.");
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
				textoJuego.setText("No es momento de ponerse a trabajar, busca la forma de salir de aqu�.");
			}
		});
		// labelSIlla.setOpaque(false);
		labelSilla.setBounds(150, 225, 80, 100);
		labelSilla.setSize(80, 150);
		panelCentral.add(labelSilla);

		// label que genera al enemigo patito cuando comprueba que no lo hemos derrotado
		// a�n
		JLabel labelEnemigo = new JLabel("");
		labelEnemigo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!ventana.enemigosDerrotados.contains(Enemigos.PATITO)) {
					try {
						ventana.enemigo = new Adversario("Donaldo", (short) 200, (short) 100, Enemigos.PATITO);
					} catch (NombreVacioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NombreConNumerosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ventana.irAPantallaBatalla();
				} else {
					textoJuego.setText("El patito est� tranquilo durmiendo...");
				}
			}
		});

		labelEnemigo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelEnemigo.setBounds(100, 350, 45, 45);
		panelCentral.add(labelEnemigo);

		// obtenemos la llave para abrir la puerta
		JLabel labelLlave = new JLabel("");
		labelLlave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textoJuego.setText("�Has encontrado la llave! Prueba a salir de la habitaci�n.");
				llave = true;
			}
		});
		labelLlave.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelLlave.setBounds(490, 210, 45, 40);
		panelCentral.add(labelLlave);

		// puerta para avanzar a la siguiente pantalla. Si llave=false, no puede
		// abrirse, y si llave=true avanzamos
		JLabel labelPuerta = new JLabel("");
		labelPuerta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (llave) {
					int opcionSalir = JOptionPane.showConfirmDialog(ventana,
							"No podr�s volver, �est�s seguro que deseas continuar?", "Aviso",
							JOptionPane.YES_NO_OPTION);
					if (opcionSalir == JOptionPane.YES_OPTION) {
						ventana.irAPantallaFinDemo();
					}
				} else {
					textoJuego.setText("Puerta Cerrada");
				}
			}
		});
		labelPuerta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelPuerta.setBounds(679, 225, 111, 309);
		panelCentral.add(labelPuerta);

		// label que genera al enemigo virus cuando comprueba que no lo hemos derrotado
		JLabel labelEnemigo2 = new JLabel("");
		labelEnemigo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!ventana.enemigosDerrotados.contains(Enemigos.VIRUS)) {
					try {
						ventana.enemigo = new Adversario("DSADFS", (short) 300, (short) 100, Enemigos.VIRUS);
					} catch (NombreVacioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NombreConNumerosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ventana.irAPantallaBatalla();
				} else {
					textoJuego.setText("Ya has derrotado al Virus, tu ordenador est� en perfecto estado.");
				}
			}
		});
		labelEnemigo2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelEnemigo2.setBounds(231, 178, 118, 106);
		panelCentral.add(labelEnemigo2);

		// label que nos da la opci�n de usar una poci�n en caso de que no la hayamos
		// usado ya, en este caso para curarnos
		JLabel labelPocion1 = new JLabel("");
		labelPocion1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!ventana.pocionesTomadas.contains(Pociones.CURATIVA)) {
					try {
						ventana.pocion = new Curativa("Cookie", Pociones.CURATIVA, (short) 100);
						int opcionPocion = JOptionPane.showConfirmDialog(ventana,
								"Has encontrado una " + ventana.pocion.getNombre() + ", �quieres tom�rtela?",
								"Poci�n encontrada", JOptionPane.YES_NO_OPTION);
						if (opcionPocion == JOptionPane.YES_OPTION) {
							ventana.protagonista.usoDePociones(ventana.pocion, (short) 100, ventana.enemigo);
							textoJuego.setText(
									"Has recuperado 100 de vida, ahora tienes: " + ventana.protagonista.getVida());
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
					textoJuego.setText("Ya te has tomado la poci�n, ser� mejor que busques otra.");
				}
			}
		});
		labelPocion1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelPocion1.setBounds(375, 409, 88, 68);
		panelCentral.add(labelPocion1);

		// imagen de fondo
		JLabel labelFondo = new JLabel("");
		labelFondo.setBackground(new Color(0, 0, 0));
		labelFondo.setIcon(new ImageIcon(
				"F:\\Mamen\\1DAM\\GitHub\\Programaci\u00F3n\\ProyectoFinalProgramacion-Juego404\\imagenes\\habitacion2.jpg"));
		labelFondo.setHorizontalAlignment(SwingConstants.CENTER);
		labelFondo.setBounds(0, 0, 800, 600);
		panelCentral.add(labelFondo);

	}
}
