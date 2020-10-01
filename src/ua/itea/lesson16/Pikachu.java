package ua.itea.lesson16;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pikachu extends JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel[] jLabels;
	private JButton jButton1;
	private JButton jButton2;
	
	private ImageIcon grass;
	private ImageIcon pikachu;
	
	private int position = 0;
	
	public Pikachu() {
		super("Pikachu");
		
		grass = new ImageIcon("img/image1.jpeg");
		pikachu = new ImageIcon("img/image2.png");
				
		jLabel1 = new JLabel(pikachu);
		jLabel2 = new JLabel(grass);
		jLabel3 = new JLabel(grass);
		jButton1 = new JButton("Prev");
		jButton2 = new JButton("Next");
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(2, 3, 0, 0));
		jPanel.add(jLabel1);
		jPanel.add(jLabel2);
		jPanel.add(jLabel3);
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		 jLabels = new JLabel[]{ jLabel1, jLabel2, jLabel3 };
		
		add(jPanel);
		
		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setListeners();
	}

	private void setListeners() {
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if ((position + 1) < jLabels.length) {
					jLabels[position++].setIcon(grass);
					jLabels[position].setIcon(pikachu);	
				}
			}
		});
		
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (position > 0) {
					jLabels[position--].setIcon(grass);
					jLabels[position].setIcon(pikachu);	
				}
			}
		});
	}
}
