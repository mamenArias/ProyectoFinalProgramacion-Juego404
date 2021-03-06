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
import clases.Defensiva;
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

	/**
	 * Constructor de la clase PantallaEscenario1 con todas las caracter?sticas de
	 * la interfaz
	 * 
	 * @param v ventana
	 */
	public PantallaEscenario1(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		ventana.primeraLlave = false;

		JPanel panelCentral = new JPanel();

		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		// texto del juego que ir? cambiando seg?n las interacciones que vayan pasando.
		JTextPane textoJuego = new JTextPane();
		textoJuego.setEditable(false);
		textoJuego.setText("\r\nInvestiga por la habitaci?n para encontrar la llave que abre la puerta.");
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
				textoJuego.setText("\r\nNo es momento de ponerse a trabajar, busca la forma de salir de aqu?.");
			}
		});
		// labelSIlla.setOpaque(false);
		labelSilla.setBounds(150, 225, 80, 100);
		labelSilla.setSize(80, 150);
		panelCentral.add(labelSilla);

		// label que genera al enemigo patito cuando comprueba que no lo hemos derrotado
		// a?n
		JLabel labelEnemigo = new JLabel("");
		labelEnemigo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!ventana.enemigosDerrotados.contains(Enemigos.PATITO)) {
					try {
						ventana.enemigo = new Adversario("Donaldo", (short) 200, (short) 100, Enemigos.PATITO,
								"Parece que a Donaldo le interesa lo que le est?s contando. Sigue as?...",
								"Pues.. se le ve bastante indiferente, la verdad.",
								"A Donaldo no le ha sentado bien tu idea y te ataca, ?ten cuidado!");
					} catch (NombreVacioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NombreConNumerosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ventana.irAPantallaBatalla();
				} else {
					textoJuego.setText("\r\nDonaldo est? tranquilo durmiendo...");
				}
			}
		});

		labelEnemigo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelEnemigo.setBounds(100, 350, 45, 45);
		panelCentral.add(labelEnemigo);

		// obtenemos una prueba para conseguir la clave para abrir la puerta
		JLabel labelPrueba = new JLabel("");
		labelPrueba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textoJuego.setText("\r\n Se ha ca?do un papel. Pone 7..35, el segundo n?mero no se ve bien.");
			}
		});
		labelPrueba.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelPrueba.setBounds(490, 210, 45, 40);
		panelCentral.add(labelPrueba);

		// puerta para avanzar a la siguiente pantalla. Si llave=false, no puede
		// abrirse, y si llave=true avanzamos
		JLabel labelPuerta = new JLabel("");
		labelPuerta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ventana.primeraLlave) {
					int opcionSalir = JOptionPane.showConfirmDialog(ventana,
							"No podr?s volver, ?est?s seguro que deseas continuar?", "Aviso",
							JOptionPane.YES_NO_OPTION);
					if (opcionSalir == JOptionPane.YES_OPTION) {
						ventana.irAPantallaEscenario2();
					}
				} else {
					textoJuego.setText("\r\nPuerta Cerrada");
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
						ventana.enemigo = new Adversario("WannaCry", (short) 300, (short) 100, Enemigos.VIRUS,
								"?ES MUY EFECTIVO!", "WannaCry se r?e en tu cara...",
								"WannaCry parece contento... pero quiere m?s y te ataca para conseguirlo.");
					} catch (NombreVacioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NombreConNumerosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ventana.irAPantallaBatalla();
				} else {
					if (ventana.primeraLlave) {
						textoJuego.setText(
								"\r\nParece que no hay nada m?s que hacer por aqu?, prueba a mirar la puerta.");
					} else {
						ventana.irAPantallaOrdenador();
						// textoJuego.setText("\r\nYa has derrotado a WannaCry, tu ordenador est? en
						// perfecto estado.");
					}
				}
			}
		});
		labelEnemigo2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelEnemigo2.setBounds(231, 178, 118, 106);
		panelCentral.add(labelEnemigo2);

		// label que nos da la opci?n de usar una poci?n en caso de que no la hayamos
		// usado ya, en este caso para curarnos
		JLabel labelPocion1 = new JLabel("");
		labelPocion1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!ventana.pocionesTomadas.contains(Pociones.DEFENSIVA)) {
					try {
						ventana.pocion = new Defensiva("Pl?tano", Pociones.DEFENSIVA, (short) 60);
						int opcionPocion = JOptionPane.showConfirmDialog(ventana,
								"Has encontrado un " + ventana.pocion.getNombre() + " en el suelo, ?quieres tom?rtelo?",
								"Poci?n encontrada", JOptionPane.YES_NO_OPTION);
						if (opcionPocion == JOptionPane.YES_OPTION) {
							ventana.protagonista.setReductorDa?o((byte) 60);
							ventana.protagonista.usoDePociones(ventana.pocion, (short) 60, ventana.enemigo);
							textoJuego.setText(
									"\r\n Parece que tu defensa ha mejorado, ahora ser? m?s f?cil derrotar a los enemigos.");
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
					textoJuego.setText("\r\n Ya te has tomado la poci?n, ser? mejor que busques otra.");
				}
			}
		});
		labelPocion1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelPocion1.setBounds(375, 409, 88, 68);
		panelCentral.add(labelPocion1);

		// imagen de fondo
		JLabel labelFondo = new JLabel("");
		labelFondo.setBackground(new Color(0, 0, 0));
		labelFondo.setIcon(new ImageIcon("imagenes/habitacion2.jpg"));
		labelFondo.setHorizontalAlignment(SwingConstants.CENTER);
		labelFondo.setBounds(0, 0, 800, 600);
		panelCentral.add(labelFondo);

	}
}
