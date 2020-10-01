package ua.itea.lesson16;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyWindow extends JFrame {
	private JButton jb2;
	private JTextField jtf;
	private JLabel jLabel;
	
	public MyWindow() {
		super("MyWindow");

		JButton jb1 = new JButton("b1");
		jb2 = new JButton("b2");
		JButton jb3 = new JButton("b3");
		JButton jb4 = new JButton("b4");
		jLabel = new JLabel("JLabel Text");
		jtf = new JTextField("JTextField Text");
		
		JPanel jp = new JPanel();
		
		jp.setLayout(new GridLayout(2, 2, 10, 5));
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		jp.add(jb4);
		jp.add(jLabel);
		jp.add(jtf);
		
		add(jp);
		
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initListeners();
	}

	private void initListeners() {
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String textField = jtf.getText();
				jLabel.setText(textField);
				
			}
			
		};
		
		jb2.addActionListener(al);
		
	}
}
