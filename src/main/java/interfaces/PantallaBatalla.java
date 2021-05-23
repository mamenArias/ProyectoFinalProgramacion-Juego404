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
import excepciones.NombreVacioException;

import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

public class PantallaBatalla extends JPanel {

	private Ventana ventana;
	private Adversario enemigo;

	public PantallaBatalla(Ventana v) {
		
		try {
			enemigo = new Adversario("Donaldo", (short)200, (short)1000, Enemigos.PATITO);
		} catch (NombreVacioException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 0, 0));
		this.ventana = v;

		JLabel labelInformativo = new JLabel("\u00A1Has encontrado un Patito de Goma!");
		labelInformativo.setBounds(0, 0, 799, 71);
		labelInformativo.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		labelInformativo.setHorizontalAlignment(SwingConstants.CENTER);
		labelInformativo.setForeground(new Color(255, 255, 255));
		Border bordeLabel = labelInformativo.getBorder();
		Border margen = new EmptyBorder(50, 0, 10, 0);
		setLayout(null);
		labelInformativo.setBorder(new CompoundBorder(bordeLabel, margen));
		add(labelInformativo);

		
		JLabel labelImagenEnemigo = new JLabel("");
		labelImagenEnemigo.setIcon(new ImageIcon("F:\\Mamen\\1DAM\\GitHub\\Programaci\u00F3n\\ProyectoFinalProgramacion-Juego404\\imagenes\\patito.png"));
		labelImagenEnemigo.setBackground(new Color(0, 0, 0));
		labelImagenEnemigo.setBounds(196, 130, 421, 370);
		add(labelImagenEnemigo);
		
		JTextPane textoBatalla = new JTextPane();
		textoBatalla.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		textoBatalla.setForeground(new Color(255, 255, 255));
		textoBatalla.setBackground(new Color(0, 0, 0));
		textoBatalla.setAlignmentY(CENTER_ALIGNMENT);
		textoBatalla.setBounds(29, 510, 747, 82);
		add(textoBatalla);
		
		JLabel labelVidaProta = new JLabel("Vida: " + v.protagonista.getVida());
		labelVidaProta.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		labelVidaProta.setForeground(new Color(255, 255, 255));
		labelVidaProta.setBackground(new Color(0, 0, 0));
		labelVidaProta.setBounds(605, 81, 171, 43);
		add(labelVidaProta);
		
		JPanel panelMenuBatalla = new JPanel();
		panelMenuBatalla.setAlignmentY(CENTER_ALIGNMENT);
		panelMenuBatalla.setBounds(0, 602, 799, 100);
		panelMenuBatalla.setForeground(new Color(255, 255, 255));
		panelMenuBatalla.setBackground(new Color(0, 0, 0));
		Border bordeMenu = new LineBorder(new Color(255,255,255));
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
				v.protagonista.atacar(enemigo);
				JOptionPane.showMessageDialog(ventana, "¿Cómo te atreves a pegarle al pobre Patito?");
				textoBatalla.setText("  \u00A1Has atacado al Patito!\r\n  Ahora su vida es de: " + enemigo.getVida());
				if(enemigo.getVida() == 0) {
					v.irAPantallaEscenario1();
				}
				enemigo.atacar(v.protagonista);
				labelVidaProta.setText("Vida: " + v.protagonista.getVida());
				if(v.protagonista.getVida() == 0) {
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
				//v.protagonista.huir(enemigo);
				Random r = new Random();
				if (r.nextInt(100) > 80) {
					if (enemigo.getTipoEnemigo() == Enemigos.PATITO) {
						v.irAPantallaEscenario1();
					}
				} else {
					textoBatalla.setText("No has podido huir.");
					//JOptionPane.showMessageDialog(v, "No puedes escapar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					enemigo.atacar(v.protagonista);
					labelVidaProta.setText("Vida: " + v.protagonista.getVida());
					if(v.protagonista.getVida() == 0) {
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
