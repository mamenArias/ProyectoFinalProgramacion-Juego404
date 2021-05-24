package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import clases.Personaje;
import clases.Protagonista;
import excepciones.NombreConNumerosException;
import excepciones.NombreVacioException;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaNuevoPersonaje extends JPanel {

	private Ventana ventana;
	private JTextField campoNombrePersonaje;

	public PantallaNuevoPersonaje (Ventana v) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 0, 0));
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		JLabel tituloNuevoPersonaje = new JLabel("Introduce los datos de tu personaje");
		tituloNuevoPersonaje.setHorizontalAlignment(SwingConstants.CENTER);
		tituloNuevoPersonaje.setFont(new Font("MS UI Gothic", Font.PLAIN, 24));
		tituloNuevoPersonaje.setForeground(new Color(255, 255, 255));
		tituloNuevoPersonaje.setBackground(new Color(0, 0, 0));
		Border border = tituloNuevoPersonaje.getBorder();
		Border margin = new EmptyBorder(60,0,60,0);
		tituloNuevoPersonaje.setBorder(new CompoundBorder(border, margin));
		add(tituloNuevoPersonaje, BorderLayout.NORTH);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setForeground(new Color(255, 255, 255));
		panelCentral.setBackground(new Color(0, 0, 0));
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setFont(new Font("MS UI Gothic", Font.PLAIN, 24));
		labelNombre.setBounds(325, 10, 132, 61);
		labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombre.setForeground(new Color(255, 255, 255));
		labelNombre.setBackground(new Color(0, 0, 0));
		panelCentral.add(labelNombre);
		
		campoNombrePersonaje = new JTextField();
		campoNombrePersonaje.setFont(new Font("MS UI Gothic", Font.PLAIN, 22));
		campoNombrePersonaje.setForeground(new Color(255, 0, 112));
		campoNombrePersonaje.setHorizontalAlignment(SwingConstants.CENTER);
		campoNombrePersonaje.setBackground(new Color(0, 0, 0));
		campoNombrePersonaje.setBounds(264, 81, 268, 34);
		panelCentral.add(campoNombrePersonaje);
		campoNombrePersonaje.setColumns(10);
		
		JLabel labelGenero = new JLabel("G\u00E9nero:");
		labelGenero.setFont(new Font("MS UI Gothic", Font.PLAIN, 24));
		labelGenero.setHorizontalAlignment(SwingConstants.CENTER);
		labelGenero.setForeground(new Color(255, 255, 255));
		labelGenero.setBackground(new Color(0, 0, 0));
		labelGenero.setBounds(325, 147, 132, 61);
		panelCentral.add(labelGenero);
		
		ButtonGroup grupoGenero = new ButtonGroup();
		
		final JRadioButton radioHombre = new JRadioButton("Hombre");
		radioHombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				radioHombre.setForeground(new Color(255,0,112));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				radioHombre.setForeground(new Color(255,255,255));
			}
		});
		radioHombre.setFont(new Font("MS UI Gothic", Font.PLAIN, 22));
		radioHombre.setFocusable(false);
		radioHombre.setForeground(new Color(255, 255, 255));
		radioHombre.setBackground(new Color(0, 0, 0));
		radioHombre.setHorizontalAlignment(SwingConstants.CENTER);
		radioHombre.setBounds(325, 214, 132, 28);
		panelCentral.add(radioHombre);
		
		final JRadioButton radioMujer = new JRadioButton("Mujer");
		radioMujer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				radioMujer.setForeground(new Color(255,0,112));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				radioMujer.setForeground(new Color(255,255,255));
			}
		});
		radioMujer.setHorizontalAlignment(SwingConstants.CENTER);
		radioMujer.setFont(new Font("MS UI Gothic", Font.PLAIN, 22));
		radioMujer.setFocusable(false);
		radioMujer.setForeground(new Color(255, 255, 255));
		radioMujer.setBackground(new Color(0, 0, 0));
		radioMujer.setBounds(325, 262, 132, 28);
		panelCentral.add(radioMujer);

		grupoGenero.add(radioHombre);
		grupoGenero.add(radioMujer);
		
		JButton botonIniciarPartida = new JButton("Iniciar Juego");
		botonIniciarPartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(radioHombre.isSelected()||radioMujer.isSelected()) {
					String nombrePersonaje = campoNombrePersonaje.getText();
					boolean generoPersonaje = radioHombre.isSelected(); //Hombre es true y Mujer es false
					short vidaPersonaje = (short) 500;
					short ataquePersonaje = (short) 50;
					
					try {
	
						ventana.protagonista = new Protagonista(nombrePersonaje, generoPersonaje, vidaPersonaje, ataquePersonaje);
						
						Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proyectoprogramacion", "root",
								"fire_emblem3.");
						Statement smt = c.createStatement();
						
						smt.executeUpdate(
								"insert into protagonista values ('" + ventana.protagonista.getNombre() + "'," + ventana.protagonista.isGenero() + "," 
						+ ventana.protagonista.getVida() + "," + ventana.protagonista.getAtaque() + "," + ventana.protagonista.getnPantalla()+");");
						smt.close();
						c.close();
						
						ventana.irAPantallaDescripcion();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NombreVacioException e1) {
						JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						campoNombrePersonaje.setBackground(new Color(255, 220, 220));
					} catch (NombreConNumerosException e1) {
						JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						campoNombrePersonaje.setBackground(new Color(255, 220, 220));
					}
				}else {
					JOptionPane.showMessageDialog(ventana, "No has seleccionado ningún género", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				botonIniciarPartida.setForeground(new Color(0,0,0));
				botonIniciarPartida.setBackground(new Color(255,102,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botonIniciarPartida.setForeground(new Color(255, 255, 255));
				botonIniciarPartida.setBackground(new Color(255, 0, 112));
			}
		});
		botonIniciarPartida.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonIniciarPartida.setFont(new Font("MS UI Gothic", Font.BOLD, 24));
		botonIniciarPartida.setForeground(new Color(255, 255, 255));
		botonIniciarPartida.setBackground(new Color(255, 0, 112));
		botonIniciarPartida.setBounds(291, 332, 205, 48);
		botonIniciarPartida.setBorderPainted(false);
		botonIniciarPartida.setFocusable(false);
		panelCentral.add(botonIniciarPartida);
		
		JPanel panelInferior = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelInferior.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelInferior.setForeground(new Color(255, 255, 255));
		panelInferior.setBackground(new Color(0, 0, 0));
		add(panelInferior, BorderLayout.SOUTH);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setContentAreaFilled(false);
		botonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
		botonVolver.setFont(new Font("MS UI Gothic", Font.PLAIN, 22));
		botonVolver.setFocusable(false);
		botonVolver.setBorderPainted(false);
		botonVolver.setForeground(new Color(255, 255, 255));
		botonVolver.setBackground(new Color(0, 0, 0));
		panelInferior.add(botonVolver);
		
		
	}
}
