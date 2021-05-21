package interfaces;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PantallaDescripcionInicial extends JPanel{

	private Ventana ventana;
	
	public PantallaDescripcionInicial (Ventana v) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 0, 0));
		this.ventana = v;
		setLayout(null);
		
		JLabel labelDescripcion = new JLabel("<html><body style=\"text-align: center\">jvdsfjdsbjgfhdsjhgbfdg<br>\r\nsamdngfdsg bd<br>\r\nsbfgfdsbg s gfdsgh dfhfdhfds hdsahdah dhdah adh<br>\r\ndsgf dfakjhsbdfhndfs<br>\r\nhd hdshah<br>\r\nah ahhhaldjhbkdajbhfds hDHNHKJDSH DHKDSNHSH <br>\r\nDH D HS DSHLDSJHLKDSJKHJ\u00D1LSH<br></body></html>");
		labelDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		labelDescripcion.setFont(new Font("MS UI Gothic", Font.PLAIN, 28));
		labelDescripcion.setForeground(new Color(255, 255, 255));
		labelDescripcion.setBackground(new Color(0, 0, 0));
		labelDescripcion.setBounds(61, 42, 693, 490);
		add(labelDescripcion);
		
	}
}
