package interfaces;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import enumeraciones.Enemigos;
import enumeraciones.Pociones;
import hilos.HiloBatalla;
import hilos.HiloTexto;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 * Interfaz de las batallas del juego
 * 
 * @author Mamen Arias
 *
 */
public class PantallaBatalla extends JPanel {

	private Ventana ventana; // ventana del juego

	/**
	 * Constructor de la clase PantallaBatalla con todas las características de la
	 * interfaz
	 * 
	 * @param v ventana
	 */
	public PantallaBatalla(Ventana v) {

		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 0, 0));
		this.ventana = v;
		
		HiloBatalla musica = new HiloBatalla();
		musica.start();

		// Label con la información del enemigo que has encontrado
		JLabel labelInformativo = new JLabel("");
		labelInformativo.setText("¡Has encontrado a " + ventana.enemigo.getNombre() + "!");
		if (ventana.enemigo.getTipoEnemigo() == Enemigos.BUG) {
			labelInformativo.setText("Has en....trad.. a " + ventana.enemigo.getNombre());
		}
		labelInformativo.setBounds(0, 0, 799, 71);
		labelInformativo.setFont(new Font("MS UI Gothic", Font.BOLD, 24));
		labelInformativo.setHorizontalAlignment(SwingConstants.CENTER);
		labelInformativo.setForeground(new Color(255, 0, 102));
		Border bordeLabel = labelInformativo.getBorder();
		Border margen = new EmptyBorder(50, 0, 10, 0);
		setLayout(null);
		labelInformativo.setBorder(new CompoundBorder(bordeLabel, margen));
		add(labelInformativo);

		// Imagen del enemigo
		JLabel labelImagenEnemigo = new JLabel("");
		labelImagenEnemigo.setHorizontalAlignment(SwingConstants.CENTER);
		if (ventana.enemigo.getTipoEnemigo() == Enemigos.PATITO) {
			labelImagenEnemigo.setIcon(new ImageIcon("imagenes/patito.png"));
		} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.VIRUS) {
			labelImagenEnemigo.setIcon(new ImageIcon("imagenes/virus.png"));
		} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.BUG) {
			labelImagenEnemigo.setIcon(new ImageIcon("imagenes/bug.png"));
		} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.USUARIO) {
			labelImagenEnemigo.setIcon(new ImageIcon("imagenes/jefe.png"));
		}
		Border bordeEnemigo = BorderFactory.createLineBorder(new Color(255, 255, 255));
		labelImagenEnemigo.setBorder(bordeEnemigo);
		labelImagenEnemigo.setBackground(new Color(0, 0, 0));
		labelImagenEnemigo.setBounds(197, 113, 421, 370);
		add(labelImagenEnemigo);

		// Información sobre la vida del protagonista durante la batalla
		JLabel labelVidaProta = new JLabel("<html><body style='text-align:center'>" + v.protagonista.getNombre()
				+ ":<br>Vida: " + ventana.protagonista.getVida() + "</body></html>");
		labelVidaProta.setHorizontalAlignment(SwingConstants.CENTER);
		labelVidaProta.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		labelVidaProta.setForeground(new Color(255, 153, 255));
		labelVidaProta.setBackground(new Color(0, 0, 0));
		labelVidaProta.setBounds(10, 113, 171, 43);
		add(labelVidaProta);

		// Texto durante la batalla con los diferentes eventos que van sucediendo
		JLabel textoBatalla = new JLabel();
		textoBatalla.setHorizontalTextPosition(SwingConstants.CENTER);
		textoBatalla.setHorizontalAlignment(SwingConstants.CENTER);
		textoBatalla.setBounds(10, 245, 177, 238);
		textoBatalla.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		textoBatalla.setForeground(new Color(255, 255, 255));
		textoBatalla.setBackground(new Color(0, 0, 0));
		textoBatalla.setOpaque(false);
		textoBatalla.setAlignmentY(CENTER_ALIGNMENT);
		add(textoBatalla);

		// Panel que contiene las 3 opciones para hablar con el enemigo durante la
		// batalla
		JPanel panelHablar = new JPanel();
		panelHablar.setVisible(false);
		panelHablar.setBackground(new Color(0, 0, 0));
		panelHablar.setBounds(29, 493, 747, 99);
		add(panelHablar);
		panelHablar.setLayout(null);

		JLabel labelOpcion1 = new JLabel("");
		labelOpcion1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labelOpcion1.setForeground(new Color(255, 0, 112));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labelOpcion1.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (ventana.enemigo.getTipoEnemigo() == Enemigos.PATITO) {
					textoBatalla.setVisible(true);
					// cuando el enemigo es patito, la primera opción hace que le ataques y pierda
					// vida
					ventana.protagonista.ataqueHablando(ventana.enemigo, (short) new Random().nextInt(100));
					textoBatalla.setText("<html><body style='text-align:center'>"
							+ ventana.enemigo.getRespuestaAmistosa() + "</body></html>");
					if (ventana.enemigo.getVida() == 0) {
						ventana.enemigosDerrotados.add(ventana.enemigo.getTipoEnemigo());
						musica.parar();
						ventana.irAPantallaEscenario1();
					}
				} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.VIRUS) {
					textoBatalla.setVisible(true);
					// cuando el enemigo es virus, con esta opción te ataca
					textoBatalla.setText("<html><body style='text-align:center'>"
							+ ventana.enemigo.getRespuestaAgresiva() + "</body></html>");
					ventana.enemigo.atacar(ventana.protagonista);
					labelVidaProta.setText("<html><body style='text-align:center'>" + ventana.protagonista.getNombre()
							+ ":<br>Vida: " + ventana.protagonista.getVida() + "</body></html>");
					if (ventana.protagonista.getVida() == 0) {
						musica.parar();
						ventana.irAPantallaGameOver();
					}
				} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.BUG) {
					// cuando el enemigo es el bug, con esta opción no pasa nada
					textoBatalla.setVisible(true);
					textoBatalla.setText("<html><body style='text-align:center'>"
							+ ventana.enemigo.getRespuestaNeutral() + "</body></html>");
				} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.USUARIO) {
					textoBatalla.setVisible(true);
					// el usuario siempre te va a atacar cuando decidas hablar con él
					textoBatalla.setText("<html><body style='text-align:center'> JAJAJAJAJJAA *"
							+ ventana.enemigo.getNombre() + " te ataca* </body></html>");
					ventana.enemigo.atacar(ventana.protagonista);
					labelVidaProta.setText("<html><body style='text-align:center'>" + ventana.protagonista.getNombre()
							+ ":<br>Vida: " + ventana.protagonista.getVida() + "</body></html>");
					if (ventana.protagonista.getVida() == 0) {
						musica.parar();
						ventana.irAPantallaGameOver();
					}

				}
			}
		});
		if (ventana.enemigo.getTipoEnemigo() == Enemigos.PATITO) {
			labelOpcion1.setText("Bueno pues... *le cuentas el código de tu proyecto*");
		} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.VIRUS) {
			labelOpcion1.setText("*Le das dinero para que se vaya...*");
		} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.BUG) {
			labelOpcion1.setText("Qu.. ..tá pa...do?");
		} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.USUARIO) {
			labelOpcion1.setText("No, no puedo modificarlo todo a un día de la entrega...");
		}
		labelOpcion1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelOpcion1.setHorizontalAlignment(SwingConstants.CENTER);
		labelOpcion1.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		labelOpcion1.setForeground(new Color(255, 255, 255));
		labelOpcion1.setBackground(new Color(0, 0, 0));
		labelOpcion1.setOpaque(false);
		labelOpcion1.setBounds(1, 0, 744, 28);
		panelHablar.add(labelOpcion1);

		JLabel labelOpcion2 = new JLabel("");
		labelOpcion2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labelOpcion2.setForeground(new Color(255, 0, 112));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labelOpcion2.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (ventana.enemigo.getTipoEnemigo() == Enemigos.PATITO) {
					// el patito no hace nada
					textoBatalla.setVisible(true);
					textoBatalla.setText("<html><body style='text-align:center'>"
							+ ventana.enemigo.getRespuestaNeutral() + "</body></html>");
				} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.VIRUS) {
					textoBatalla.setVisible(true);
					// el virus no hace nada
					textoBatalla.setText("<html><body style='text-align:center'>"
							+ ventana.enemigo.getRespuestaNeutral() + "</body></html>");
				} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.BUG) {
					textoBatalla.setVisible(true);
					// cuando el enemigo es bug, con esta opción te ataca
					textoBatalla.setText("<html><body style='text-align:center'>"
							+ ventana.enemigo.getRespuestaAgresiva() + "</body></html>");
					ventana.enemigo.atacar(ventana.protagonista);
					labelVidaProta.setText("<html><body style='text-align:center'>" + ventana.protagonista.getNombre()
							+ ":<br>Vida: " + ventana.protagonista.getVida() + "</body></html>");
					if (ventana.protagonista.getVida() == 0) {
						musica.parar();
						ventana.irAPantallaGameOver();
					}
				} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.USUARIO) {
					textoBatalla.setVisible(true);
					// el usuario siempre te va a atacar cuando decidas hablar con él
					textoBatalla.setText("<html><body style='text-align:center'> JAJAJAJAJJAA *"
							+ ventana.enemigo.getNombre() + " te ataca* </body></html>");
					ventana.enemigo.atacar(ventana.protagonista);
					labelVidaProta.setText("<html><body style='text-align:center'>" + ventana.protagonista.getNombre()
							+ ":<br>Vida: " + ventana.protagonista.getVida() + "</body></html>");
					if (ventana.protagonista.getVida() == 0) {
						musica.parar();
						ventana.irAPantallaGameOver();
					}

				}
			}
		});
		if (ventana.enemigo.getTipoEnemigo() == Enemigos.PATITO) {
			labelOpcion2.setText("¡Qué cosa tan mona!");
		} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.VIRUS) {
			labelOpcion2.setText("¡Aaah, atrás, bichooo!");
		} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.BUG) {
			labelOpcion2.setText("Si p...ra ..ini..r...");
		} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.USUARIO) {
			labelOpcion2.setText("Como le meta más colores al diseño, te van a sangrar los ojos..");
		}
		labelOpcion2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelOpcion2.setHorizontalAlignment(SwingConstants.CENTER);
		labelOpcion2.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		labelOpcion2.setForeground(new Color(255, 255, 255));
		labelOpcion2.setBackground(new Color(0, 0, 0));
		labelOpcion2.setOpaque(false);
		labelOpcion2.setBounds(1, 33, 744, 28);
		panelHablar.add(labelOpcion2);

		JLabel labelOpcion3 = new JLabel("");
		labelOpcion3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labelOpcion3.setForeground(new Color(255, 0, 112));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labelOpcion3.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (ventana.enemigo.getTipoEnemigo() == Enemigos.PATITO) {
					textoBatalla.setVisible(true);
					// el patito te ataca
					textoBatalla.setText("<html><body style='text-align:center'>"
							+ ventana.enemigo.getRespuestaAgresiva() + "</body></html>");
					ventana.enemigo.atacar(ventana.protagonista);
					labelVidaProta.setText("<html><body style='text-align:center'>" + ventana.protagonista.getNombre()
							+ ":<br>Vida: " + ventana.protagonista.getVida() + "</body></html>");
					if (ventana.protagonista.getVida() == 0) {
						musica.parar();
						ventana.irAPantallaGameOver();
					}
				} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.VIRUS) {
					textoBatalla.setVisible(true);
					// le atacas al enemigo escogiendo esta opción
					ventana.protagonista.ataqueHablando(ventana.enemigo, (short) new Random().nextInt(100));
					textoBatalla.setText("<html><body style='text-align:center'>"
							+ ventana.enemigo.getRespuestaAmistosa() + "</body></html>");
					if (ventana.enemigo.getVida() == 0) {
						ventana.enemigosDerrotados.add(ventana.enemigo.getTipoEnemigo());
						musica.parar();
						ventana.irAPantallaOrdenador();
					}
				} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.BUG) {
					// cuando el enemigo es un bug, con esta opción le atacas
					ventana.protagonista.ataqueHablando(ventana.enemigo, (short) new Random().nextInt(100));
					textoBatalla.setText("<html><body style='text-align:center'>"
							+ ventana.enemigo.getRespuestaAmistosa() + "</body></html>");
					if (ventana.enemigo.getVida() == 0) {
						ventana.enemigosDerrotados.add(ventana.enemigo.getTipoEnemigo());
						musica.parar();
						ventana.irAPantallaEscenario2();
					}
				} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.USUARIO) {
					textoBatalla.setVisible(true);
					// el usuario siempre te va a atacar cuando decidas hablar con él
					textoBatalla.setText("<html><body style='text-align:center'> JAJAJAJAJJAA *"
							+ ventana.enemigo.getNombre() + " te ataca*</body></html>");
					ventana.enemigo.atacar(ventana.protagonista);
					labelVidaProta.setText("<html><body style='text-align:center'>" + ventana.protagonista.getNombre()
							+ ":<br>Vida: " + ventana.protagonista.getVida() + "</body></html>");
					if (ventana.protagonista.getVida() == 0) {
						musica.parar();
						ventana.irAPantallaGameOver();
					}

				}
			}
		});
		if (ventana.enemigo.getTipoEnemigo() == Enemigos.PATITO) {
			labelOpcion3.setText("¡Oh un patito! Será mejor si lo meto en agua...");
		} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.VIRUS) {
			labelOpcion3.setText("*Le tiras un ladrillo*");
		} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.BUG) {
			labelOpcion3.setText("*M....as.. el c...go..*");
		} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.USUARIO) {
			labelOpcion3.setText("¡NO TE AGUANTO MÁS!");
		}
		labelOpcion3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelOpcion3.setHorizontalAlignment(SwingConstants.CENTER);
		labelOpcion3.setForeground(new Color(255, 255, 255));
		labelOpcion3.setBackground(new Color(0, 0, 0));
		labelOpcion3.setOpaque(false);
		labelOpcion3.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		labelOpcion3.setBounds(1, 71, 744, 28);
		panelHablar.add(labelOpcion3);

		// opciones a escoger durante la batalla
		JPanel panelMenuBatalla = new JPanel();
		panelMenuBatalla.setAlignmentY(CENTER_ALIGNMENT);
		panelMenuBatalla.setBounds(0, 609, 799, 54);
		panelMenuBatalla.setForeground(new Color(255, 255, 255));
		panelMenuBatalla.setBackground(new Color(0, 0, 0));
		panelMenuBatalla.setOpaque(false);
		Border bordeMenu = new LineBorder(new Color(255, 255, 255));
		panelMenuBatalla.setBorder(bordeMenu);
		add(panelMenuBatalla);

		// botón para atacar al enemigo
		JButton botonAtacar = new JButton("Atacar");
		botonAtacar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botonAtacar.setForeground(new Color(255, 0, 112));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonAtacar.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelHablar.setVisible(false);
				//textoBatalla.setVisible(true);
				ventana.protagonista.atacar(ventana.enemigo);
				if (ventana.enemigo.getTipoEnemigo() == Enemigos.PATITO) {
					JOptionPane.showMessageDialog(ventana,
							"¿Cómo te atreves a pegarle al pobre " + ventana.enemigo.getNombre());
					musica.parar();
					ventana.irAPantallaGameOver();
				}
				//Creación de un hilo para que el texto aparezca poco a poco según los ataques tuyos y del enemigo
				HiloTexto hilo = new HiloTexto(textoBatalla, labelVidaProta, panelMenuBatalla, "<html><body style='text-align:center'>Has atacado a "
						+ ventana.enemigo.getNombre() + "!<br>  Ahora su vida es de: " + ventana.enemigo.getVida() + "</body></html>",
						"<html><body style='text-align:center'>" + ventana.enemigo.getNombre() + " te ha atacado...</body></html>");
				hilo.start();
				if (ventana.enemigo.getVida() == 0) {
					ventana.enemigosDerrotados.add(ventana.enemigo.getTipoEnemigo());
					if (ventana.enemigo.getTipoEnemigo() == Enemigos.PATITO) {
						musica.parar();
						ventana.irAPantallaEscenario1();
					} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.VIRUS) {
						musica.parar();
						ventana.irAPantallaOrdenador();
					} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.BUG) {
						musica.parar();
						ventana.irAPantallaEscenario2();
					} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.USUARIO) {
						musica.parar();
						ventana.segundaLlave = true;
						ventana.irAPantallaEscenario2();
					}
				} else {
					if (ventana.pocionesTomadas.contains(Pociones.DEFENSIVA)) {
						ventana.enemigo.atacarConPocion(ventana.protagonista);
						/*labelVidaProta
								.setText("<html><body style='text-align:center'>" + ventana.protagonista.getNombre()
										+ ":<br>Vida: " + ventana.protagonista.getVida() + "</body></html>");*/
					}
					// meter un random para que use de vez en cuando el ataque especial de Usuario
					if (ventana.enemigo.getTipoEnemigo() == Enemigos.USUARIO && new Random().nextInt(100) > 90) {
						ventana.enemigo.ataqueEspecial(ventana.protagonista);
						labelVidaProta
								.setText("<html><body style='text-align:center'>" + ventana.protagonista.getNombre()
										+ ":<br>Vida: " + ventana.protagonista.getVida() + "</body></html>");
						textoBatalla.setText("<html><body style='text-align:center'>" + ventana.enemigo.getNombre()
								+ " ha usado un ataque especial y te ha hecho el doble de daño...</body></html>");
						if (ventana.protagonista.getVida() == 0) {
							ventana.pocionesTomadas = new ArrayList<Pociones>();
							musica.parar();
							ventana.irAPantallaGameOver();
						}
					}

					ventana.enemigo.atacar(ventana.protagonista);
					labelVidaProta.setText("<html><body style='text-align:center'>" + ventana.protagonista.getNombre()
							+ ":<br>Vida: " + ventana.protagonista.getVida() + "</body></html>");
					if (ventana.protagonista.getVida() == 0) {
						ventana.pocionesTomadas = new ArrayList<Pociones>();
						// creamos de nuevo el array list vacío para que al volver a la pantalla que estábamos, podamos volver a tomarnos la poción
						musica.parar();
						ventana.irAPantallaGameOver();
					}
				}

			}
		});
		botonAtacar.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		botonAtacar.setForeground(new Color(255, 255, 255));
		botonAtacar.setBackground(new Color(0, 0, 0));
		botonAtacar.setFocusable(false);
		botonAtacar.setContentAreaFilled(false);
		botonAtacar.setBorderPainted(false);
		botonAtacar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenuBatalla.add(botonAtacar);

		// botón para hablar con el enemigo
		JButton botonHablar = new JButton("Hablar");
		botonHablar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				botonHablar.setForeground(new Color(255, 0, 112));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonHablar.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				textoBatalla.setVisible(false);
				panelHablar.setVisible(true);
				// menuConversacion.setVisible(true);
			}
		});
		botonHablar.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		botonHablar.setForeground(new Color(255, 255, 255));
		botonHablar.setBackground(new Color(0, 0, 0));
		botonHablar.setFocusable(false);
		botonHablar.setContentAreaFilled(false);
		botonHablar.setBorderPainted(false);
		botonHablar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenuBatalla.add(botonHablar);

		// botón para intentar huir del combate
		JButton botonHuir = new JButton("Huir");
		botonHuir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botonHuir.setForeground(new Color(255, 0, 112));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonHuir.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.protagonista.huir(ventana.enemigo, ventana.protagonista, textoBatalla, labelVidaProta, ventana, musica);
			}
		});
		botonHuir.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		botonHuir.setForeground(new Color(255, 255, 255));
		botonHuir.setBackground(new Color(0, 0, 0));
		botonHuir.setFocusable(false);
		botonHuir.setContentAreaFilled(false);
		botonHuir.setBorderPainted(false);
		botonHuir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenuBatalla.add(botonHuir);

	}
}
