package ua.itea.lesson16;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameAuthorization extends JFrame {
	private JLabel jLabelLogin;
	private JLabel jLabelPassword;
	private JTextField jTextFieldLogin;
	private JTextField jTextFieldPassword;
	private JButton jButton;
	
	private UsersDB usersDB;
	private DBConnector conn = new DBConnector();
	
	public FrameAuthorization(UsersDB usersDB) {
		super("Authorization");
		
		this.usersDB = usersDB;
		
		jLabelLogin = new JLabel("Login:");
		jLabelPassword = new JLabel("Password:");
		jTextFieldLogin = new JTextField();
		jTextFieldPassword = new JTextField();
		jButton = new JButton("Sign In");
		
		JPanel jp = new JPanel(new GridLayout(3, 2, 5, 5));
		jp.add(jLabelLogin);
		jp.add(jTextFieldLogin);
		jp.add(jLabelPassword);
		jp.add(jTextFieldPassword);
		jp.add(jButton);
		
		add(jp);
		
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setListeners();
	}

	private void setListeners() {
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				insertIntoDatabase(jTextFieldLogin.getText(),
								   jTextFieldPassword.getText());
			}
		});
		
	}
	
	private void insertIntoDatabase(String login, String password) {
		usersDB.addUser(conn.getConnection(), login, password);
	}
}
