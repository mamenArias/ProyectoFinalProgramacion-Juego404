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

import clases.Adversario;
import clases.Protagonista;

/**
 * Clase ventana que va a contener todas las pantallas del juego
 * @author Mamen Arias
 *
 */
public class Ventana extends JFrame{

	private PantallaInicio pantallaInicio; // Pantalla Inicial del juego
	private PantallaNuevoPersonaje pantallaNuevoPersonaje; // Pantalla de registro del nuevo personaje
	private PantallaCargarPersonaje pantallaCargarPersonaje; // Pantalla de carga de personajes guardados.
	private PantallaDescripcionInicial pantallaDescripcion; // Pantalla inicial con la descripción de la historia del juego
	private PantallaEscenario1 pantallaEscenario1; // primer escenario del juego
	private PantallaEscenario2 pantallaEscenario2; // segundo escenario del juego
	private PantallaBatalla pantallaBatalla; // pantalla de batalla
	private PantallaGameOver pantallaGameOver; // pantalla de Game Over cuando matan al personaje
	private PantallaFinDemo pantallaFinDemo; // pantalla de final de juego temporal
	protected Protagonista protagonista; // personaje principal del juego
	protected Adversario enemigo; // enemigos del juego
	
	
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
	
	/**
	 * Función para hacer visible la pantalla inicial e invisible todas aquellas desde las que accedemos a esta.
	 */
	public void volverAInicio() {
		if(this.pantallaInicio == null) {
			this.pantallaInicio = new PantallaInicio(this);
		}
		
		if(this.pantallaNuevoPersonaje != null) {
			this.pantallaNuevoPersonaje.setVisible(false);
		}
		
		if(this.pantallaCargarPersonaje != null) {
			this.pantallaCargarPersonaje.setVisible(false);
		}
		
		if(this.pantallaGameOver != null) {
			this.pantallaGameOver.setVisible(false);
		}
		
		this.setContentPane(pantallaInicio);
		this.pantallaInicio.setVisible(true);
	}
	
	/**
	 * Función para hacer visible la pantalla del creación de nuevo personaje e invisible todas aquellas desde las que accedemos a esta.
	 */
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
	
	/**
	 * Función para hacer visible la pantalla de carga de personajes guardados e invisible todas aquellas desde las que accedemos a esta.
	 */
	public void irAPantallaCargaPersonaje() {
		if (this.pantallaCargarPersonaje == null) {
			this.pantallaCargarPersonaje = new PantallaCargarPersonaje(this);
		}
		
		if(this.pantallaInicio != null) {
			this.pantallaInicio.setVisible(false);
		}
		
		this.setContentPane(pantallaCargarPersonaje);
		this.pantallaCargarPersonaje.setVisible(true);
	}
	
	/**
	 * Función para hacer visible la pantalla de descripción de la historia e invisible todas aquellas desde las que accedemos a esta.
	 */
	public void irAPantallaDescripcion() {
		if(this.pantallaDescripcion == null) {
			this.pantallaDescripcion = new PantallaDescripcionInicial(this);
		}
		
		if(this.pantallaNuevoPersonaje != null) {
			this.pantallaNuevoPersonaje.setVisible(false);
		}
		
		/*if(this.pantallaInicio != null) {
			this.pantallaInicio.setVisible(false);
		}*/
		
		this.setContentPane(pantallaDescripcion);
		this.pantallaDescripcion.setVisible(true);
	}
	
	/**
	 * Función para hacer visible el primer escenario del juego e invisible todas aquellas desde las que accedemos a esta.
	 */
	public void irAPantallaEscenario1() {
		if(this.pantallaEscenario1 == null) {
			this.pantallaEscenario1 = new PantallaEscenario1(this);
		}
		
		/*if(this.pantallaInicio != null) {
			this.pantallaInicio.setVisible(false);
		}*/
		
		if(this.pantallaCargarPersonaje != null) {
			this.pantallaCargarPersonaje.setVisible(false);
		}
		
		if(this.pantallaDescripcion != null) {
			this.pantallaDescripcion.setVisible(false);
		}
		
		if(this.pantallaBatalla != null){
			this.pantallaBatalla.setVisible(false);
		}
		
		this.setContentPane(pantallaEscenario1);
		this.pantallaEscenario1.setVisible(true);
	}
	
	/**
	 * Función para hacer visible la pantalla de batalla e invisible todas aquellas desde las que accedemos a esta.
	 */
	public void irAPantallaBatalla() {
		if(this.pantallaBatalla != null) {
			this.pantallaBatalla.setVisible(false);
		}
		//Vamos a crear siempre una pantalla de batalla nueva para que nos aparezcan los diferentes enemigos que hay ocultos por el escenario
		this.pantallaBatalla = new PantallaBatalla(this);
		
		if(this.pantallaEscenario1 != null) {
			this.pantallaEscenario1.setVisible(false);
		}
		
		this.setContentPane(pantallaBatalla);
		this.pantallaBatalla.setVisible(true);
		
	}
	
	/**
	 * Función para hacer visible el segundo escenario del juego e invisible todas aquellas desde las que accedemos a esta.
	 */
	public void irAPantallaEscenario2() {
		if(this.pantallaEscenario2 == null) {
			this.pantallaEscenario2 = new PantallaEscenario2(this);
		}

		if(this.pantallaCargarPersonaje != null) {
			this.pantallaCargarPersonaje.setVisible(false);
		}
		
		if(this.pantallaEscenario1 != null) {
			this.pantallaEscenario1.setVisible(false);
		}
		
		this.setContentPane(pantallaEscenario2);
		this.pantallaEscenario2.setVisible(true);
	}
	
	/**
	 * Función para hacer visible la pantalla de Game Over e invisible todas aquellas desde las que accedemos a esta.
	 */
	public void irAPantallaGameOver() {
		if(this.pantallaGameOver == null) {
			this.pantallaGameOver = new PantallaGameOver(this);
		}
		
		if(this.pantallaBatalla != null) {
			this.pantallaBatalla.setVisible(false);
		}
		
		/*if(this.pantallaInicio != null) {
			this.pantallaInicio.setVisible(false);
		}*/
		
		this.setContentPane(pantallaGameOver);
		this.pantallaGameOver.setVisible(true);
	}

	/**
	 * Función para hacer visible la última pantalla del juego
	 */
	public void irAPantallaFinDemo() {
		if (this.pantallaFinDemo == null) {
			this.pantallaFinDemo = new PantallaFinDemo(this);
		}
		
		if (this.pantallaEscenario1 != null) {
			this.pantallaEscenario1.setVisible(false);
		}
		
		this.setContentPane(pantallaFinDemo);
		this.pantallaFinDemo.setVisible(true);
	}
	
	/*public void guardarPartida() {
		
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
		
	}*/
}
