package interfaces;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import clases.Protagonista;

/**
 * Clase ventana que va a contener todas las pantallas del juego
 * @author Mamen Arias
 *
 */
public class Ventana extends JFrame{

	private PantallaInicio pantallaInicio; // Pantalla Inicial del juego
	private PantallaNuevoPersonaje pantallaNuevoPersonaje; //Pantalla de registro del nuevo personaje
	private PantallaDescripcionInicial pantallaDescripcion;
	private PantallaEscenario1 pantallaEscenario1;
	protected Protagonista protagonista;
	
	
	/**
	 * Constructor de la clase Ventana con todas las medidas de la misma.
	 */
	public Ventana() {
		this.setSize(800,700);
		
		this.setTitle("404");
		
		this.setResizable(false);
		
		this.setLocation(120,20);
		
		BufferedImage icono;
		try {
			icono = ImageIO.read(new File ("imagenes/icono.png"));
			this.setIconImage(icono);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pantallaInicio = new PantallaInicio(this);
		this.setContentPane(pantallaInicio);
		
		this.setVisible(true);
	}
	
	public void volverAInicio() {
		if(this.pantallaInicio == null) {
			this.pantallaInicio = new PantallaInicio(this);
		}
		
		if(this.pantallaNuevoPersonaje != null) {
			this.pantallaNuevoPersonaje.setVisible(false);
		}
		
		this.setContentPane(pantallaInicio);
		this.pantallaInicio.setVisible(true);
	}
	
	
	public void irAPantallaNuevoPersonaje() {
		if(this.pantallaNuevoPersonaje == null) {
			this.pantallaNuevoPersonaje = new PantallaNuevoPersonaje(this);
		}
		
		if(this.pantallaInicio != null) {
			this.pantallaInicio.setVisible(false);
		}
		
		this.setContentPane(pantallaNuevoPersonaje);
		this.pantallaNuevoPersonaje.setVisible(true);
	}
	
	public void irAPantallaDescripcion() {
		if(this.pantallaDescripcion == null) {
			this.pantallaDescripcion = new PantallaDescripcionInicial(this);
		}
		
		if(this.pantallaNuevoPersonaje != null) {
			this.pantallaNuevoPersonaje.setVisible(false);
		}
		
		this.setContentPane(pantallaDescripcion);
		this.pantallaDescripcion.setVisible(true);
	}
	
	public void irAPantallaEscenario1() {
		if(this.pantallaEscenario1 == null) {
			this.pantallaEscenario1 = new PantallaEscenario1(this);
		}
		
		if(this.pantallaInicio != null) {
			this.pantallaInicio.setVisible(false);
		}
		
		this.setContentPane(pantallaEscenario1);
		this.pantallaEscenario1.setVisible(true);
	}
	
	public void guardarPartida() {
		
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proyectoprogramacion", "root",
					"fire_emblem3.");
			
			Statement smt = c.createStatement();
			
			smt.executeUpdate(
					"insert into protagonista values ('" + this.protagonista.getNombre() + "'," + this.protagonista.isGenero() + "," 
			+ this.protagonista.getVida() + "," + this.protagonista.getAtaque() + "," + this.protagonista.getnPantalla()+");");
			smt.close();
			c.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void cargarPartida(String nombre) {
		
	}
}
