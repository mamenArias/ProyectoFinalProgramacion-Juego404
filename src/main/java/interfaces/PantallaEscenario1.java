package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaEscenario1 extends JPanel{

	private Ventana ventana;
	
	public PantallaEscenario1 (Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		JLabel espacioDescripcion = new JLabel("New label");
		add(espacioDescripcion, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel labelSIlla = new JLabel("");
		labelSIlla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				espacioDescripcion.setText("fadsadsdsa");
			}
		});
		labelSIlla.setOpaque(false);
		labelSIlla.setBounds(56, 49, 45, 13);
		labelSIlla.setSize(50,100);
		panel.add(labelSIlla);
	}
}
