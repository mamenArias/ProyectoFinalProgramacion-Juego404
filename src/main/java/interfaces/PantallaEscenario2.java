package interfaces;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PantallaEscenario2 extends JPanel {

	private Ventana ventana;
	
	public PantallaEscenario2(Ventana v) {
		this.ventana = v;
		
		Connection c;
		try {
			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proyectoprogramacion", "root",
					"fire_emblem3.");
			
			Statement smt = c.createStatement();
			
			smt.executeUpdate("update protagonista set pantalla=2 where nombre='" + ventana.protagonista.getNombre() + "';");
			
			smt.close();
			c.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JButton botonOpcion1 = new JButton("1");
		add(botonOpcion1);
		
		JButton botonOpcion2 = new JButton("2");
		botonOpcion2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		add(botonOpcion2);
	}
}
