package interfaces;

import javax.swing.JPanel;

import clases.Adversario;

import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OpcionesHablar extends JPanel{
	public OpcionesHablar(String opcion1 , String opcion2, String opcion3, Adversario enemigo) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
	
		
		JLabel labelInformacion = new JLabel("Probando");
		labelInformacion.setVisible(false);
		labelInformacion.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		labelInformacion.setForeground(Color.WHITE);
		labelInformacion.setBackground(Color.BLACK);
		GridBagConstraints gbc_labelInformacion = new GridBagConstraints();
		gbc_labelInformacion.insets = new Insets(0, 0, 5, 5);
		gbc_labelInformacion.gridx = 40;
		gbc_labelInformacion.gridy = 1;
		add(labelInformacion, gbc_labelInformacion);
		
		JLabel labelOpcion1 = new JLabel(opcion1);
		labelOpcion1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelInformacion.setVisible(true);
			}
		});
		labelOpcion1.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		labelOpcion1.setForeground(Color.WHITE);
		labelOpcion1.setBackground(Color.BLACK);
		GridBagConstraints gbc_labelOpcion1 = new GridBagConstraints();
		gbc_labelOpcion1.insets = new Insets(0, 0, 5, 5);
		gbc_labelOpcion1.gridx = 1;
		gbc_labelOpcion1.gridy = 20;
		add(labelOpcion1, gbc_labelOpcion1);
		
		JLabel labelOpcion2 = new JLabel(opcion2);
		labelOpcion2.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		labelOpcion2.setBackground(Color.BLACK);
		labelOpcion2.setForeground(Color.WHITE);
		GridBagConstraints gbc_labelOpcion2 = new GridBagConstraints();
		gbc_labelOpcion2.insets = new Insets(0, 0, 5, 5);
		gbc_labelOpcion2.gridx = 1;
		gbc_labelOpcion2.gridy = 21;
		add(labelOpcion2, gbc_labelOpcion2);
		
		JLabel labelOpcion3 = new JLabel(opcion3);
		labelOpcion3.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		labelOpcion3.setBackground(Color.BLACK);
		labelOpcion3.setForeground(Color.WHITE);
		GridBagConstraints gbc_labelOpcion3 = new GridBagConstraints();
		gbc_labelOpcion3.insets = new Insets(0, 0, 5, 5);
		gbc_labelOpcion3.gridx = 1;
		gbc_labelOpcion3.gridy = 22;
		add(labelOpcion3, gbc_labelOpcion3);
	}

}
