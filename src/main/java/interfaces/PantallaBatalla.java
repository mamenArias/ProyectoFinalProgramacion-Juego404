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

import clases.Adversario;
import clases.Personaje;
import clases.Protagonista;
import enumeraciones.Enemigos;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JTextPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.GridLayout;

public class PantallaBatalla extends JPanel {

	private Ventana ventana;
	// private Adversario enemigo;

	public PantallaBatalla(Ventana v) {

		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 0, 0));
		this.ventana = v;

		JLabel labelInformativo = new JLabel("");
		labelInformativo.setText("¡Has encontrado a " + ventana.enemigo.getNombre() + "!");
		labelInformativo.setBounds(0, 0, 799, 71);
		labelInformativo.setFont(new Font("MS UI Gothic", Font.BOLD, 24));
		labelInformativo.setHorizontalAlignment(SwingConstants.CENTER);
		labelInformativo.setForeground(new Color(255, 0, 102));
		Border bordeLabel = labelInformativo.getBorder();
		Border margen = new EmptyBorder(50, 0, 10, 0);
		setLayout(null);
		labelInformativo.setBorder(new CompoundBorder(bordeLabel, margen));
		add(labelInformativo);

		JLabel labelImagenEnemigo = new JLabel("");
		if (v.enemigo.getTipoEnemigo() == Enemigos.PATITO) {
			labelImagenEnemigo.setIcon(new ImageIcon(
					"F:\\Mamen\\1DAM\\GitHub\\Programaci\u00F3n\\ProyectoFinalProgramacion-Juego404\\imagenes\\patito.png"));
		} else if (v.enemigo.getTipoEnemigo() == Enemigos.VIRUS) {
			labelImagenEnemigo.setIcon(new ImageIcon(
					"F:\\Mamen\\1DAM\\GitHub\\Programaci\u00F3n\\ProyectoFinalProgramacion-Juego404\\imagenes\\virus.png"));
		}
		Border bordeEnemigo = BorderFactory.createLineBorder(new Color(255, 255, 255));
		labelImagenEnemigo.setBorder(bordeEnemigo);
		labelImagenEnemigo.setBackground(new Color(0, 0, 0));
		labelImagenEnemigo.setBounds(197, 113, 421, 370);
		add(labelImagenEnemigo);

		JLabel labelVidaProta = new JLabel("<html><body style='text-align:center'>" + v.protagonista.getNombre()
				+ ":<br>Vida: " + v.protagonista.getVida() + "</body></html>");
		labelVidaProta.setHorizontalAlignment(SwingConstants.CENTER);
		labelVidaProta.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		labelVidaProta.setForeground(new Color(255, 153, 255));
		labelVidaProta.setBackground(new Color(0, 0, 0));
		labelVidaProta.setBounds(10, 113, 171, 43);
		add(labelVidaProta);

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
					ventana.protagonista.ataqueHablando(ventana.enemigo, (short) 100);
					textoBatalla.setText("<html><body style='text-align:center'>Parece que a " + ventana.enemigo.getNombre()
									+ " le interesa lo que le estás contando. Sigue así...</body></html>");
					if (ventana.enemigo.getVida() == 0) {
						ventana.irAPantallaEscenario1();
					}
				} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.VIRUS) {
					textoBatalla.setVisible(true);
					textoBatalla.setText("<html><body style='text-align:center'>A " + ventana.enemigo.getNombre()
							+ "no le ha sentado bien tu idea y te ataca, ¡ten cuidado!</body></html>");
					v.enemigo.atacar(v.protagonista);
					labelVidaProta.setText(
							"<html><body>" + v.protagonista.getNombre() + ":<br>Vida: " + v.protagonista.getVida());
					if (v.protagonista.getVida() == 0) {
						v.irAPantallaGameOver();
					}
				}

			}
		});
		if (ventana.enemigo.getTipoEnemigo() == Enemigos.PATITO) {
			labelOpcion1.setText("Bueno pues... *le cuentas el código de tu proyecto*");
		} else if (ventana.enemigo.getTipoEnemigo() == Enemigos.VIRUS) {
			labelOpcion1.setText("Pues tampoco eres para tanto...");
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
				if (v.enemigo.getTipoEnemigo() == Enemigos.PATITO) {
					textoBatalla.setVisible(true);
					textoBatalla.setText(
							"<html><body style='text-align:center'>Pues.. se le ve bastante indiferente, la verdad.</body></html>");
				} else if (v.enemigo.getTipoEnemigo() == Enemigos.VIRUS) {
					textoBatalla.setVisible(true);
					textoBatalla.setText(
							"<html><body style='text-align:center'>"+ventana.enemigo.getNombre() + " se ríe en tu cara...</body></html>");
				}
				
			}
		});
		if (v.enemigo.getTipoEnemigo() == Enemigos.PATITO) {
			labelOpcion2.setText("¡¡Qué cosa tan mona!");
		} else if (v.enemigo.getTipoEnemigo() == Enemigos.VIRUS) {
			labelOpcion2.setText("¡Aaah, atrás, bichooo!");
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
				if (v.enemigo.getTipoEnemigo() == Enemigos.PATITO) {
					textoBatalla.setVisible(true);
					textoBatalla.setText("<html><body style='text-align:center'>A " + ventana.enemigo.getNombre()
							+ "no le ha sentado bien tu idea y te ataca, ¡ten cuidado!</body></html>");
					v.enemigo.atacar(v.protagonista);
					labelVidaProta.setText(
							"<html><body>" + v.protagonista.getNombre() + ":<br>Vida: " + v.protagonista.getVida());
					if (v.protagonista.getVida() == 0) {
						v.irAPantallaGameOver();
					}
				} else if (v.enemigo.getTipoEnemigo() == Enemigos.VIRUS) {
					textoBatalla.setVisible(true);
					ventana.protagonista.ataqueHablando(ventana.enemigo, (short) 150);
					textoBatalla.setText("<html><body style='text-align:center'>¡ES MUY EFECTIVO!</body></html>");
					if (ventana.enemigo.getVida() == 0) {
						ventana.irAPantallaEscenario1();
					}
				}
				
			}
		});
		if (v.enemigo.getTipoEnemigo() == Enemigos.PATITO) {
			labelOpcion3.setText("¡Oh un patito! Será mejor si lo meto en agua...");
		} else if (v.enemigo.getTipoEnemigo() == Enemigos.VIRUS) {
			labelOpcion3.setText("*Le tiras un ladrillo*");
		}
		labelOpcion3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelOpcion3.setHorizontalAlignment(SwingConstants.CENTER);
		labelOpcion3.setForeground(new Color(255, 255, 255));
		labelOpcion3.setBackground(new Color(0, 0, 0));
		labelOpcion3.setOpaque(false);
		labelOpcion3.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		labelOpcion3.setBounds(1, 71, 744, 28);
		panelHablar.add(labelOpcion3);
		JPanel panelMenuBatalla = new JPanel();
		panelMenuBatalla.setAlignmentY(CENTER_ALIGNMENT);
		panelMenuBatalla.setBounds(0, 609, 799, 54);
		panelMenuBatalla.setForeground(new Color(255, 255, 255));
		panelMenuBatalla.setBackground(new Color(0, 0, 0));
		panelMenuBatalla.setOpaque(false);
		Border bordeMenu = new LineBorder(new Color(255, 255, 255));
		panelMenuBatalla.setBorder(bordeMenu);
		add(panelMenuBatalla);

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
				textoBatalla.setVisible(true);
				v.protagonista.atacar(v.enemigo);
				// JOptionPane.showMessageDialog(ventana, "¿Cómo te atreves a pegarle al pobre
				// Patito?");
				textoBatalla.setText("<html><body style='text-align:center'>  \u00A1Has atacado a "
						+ ventana.enemigo.getNombre() + "!<br>  Ahora su vida es de: " + v.enemigo.getVida()
						+ "<br><br>" + ventana.enemigo.getNombre() + " te ha atacado...</body></html>");
				if (ventana.enemigo.getVida() == 0) {
					ventana.irAPantallaEscenario1();
				}
				v.enemigo.atacar(v.protagonista);
				labelVidaProta.setText(
						"<html><body>" + v.protagonista.getNombre() + ":<br>Vida: " + v.protagonista.getVida());
				if (v.protagonista.getVida() == 0) {
					v.irAPantallaGameOver();
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
				// v.protagonista.huir(enemigo);
				Random r = new Random();
				if (r.nextInt(100) > 80) {
					if (v.enemigo.getTipoEnemigo() == Enemigos.PATITO) {
						v.irAPantallaEscenario1();
					}
				} else {
					textoBatalla.setText("No has podido huir.");
					// JOptionPane.showMessageDialog(v, "No puedes escapar", "Aviso",
					// JOptionPane.INFORMATION_MESSAGE);
					v.enemigo.atacar(v.protagonista);
					labelVidaProta.setText("Vida: " + v.protagonista.getVida());
					if (v.protagonista.getVida() == 0) {
						v.irAPantallaGameOver();
					}
				}
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
