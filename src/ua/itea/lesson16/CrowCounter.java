package ua.itea.lesson16;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CrowCounter extends JFrame {
	private JButton jCrowDeparture;
	private JButton jCrowArrive;
	private JLabel jCounter;
	private int counter = 0;
	
	public CrowCounter() {
		super("Crow Counter");
		
		jCrowDeparture = new JButton("Crow Departure");
		jCrowArrive = new JButton("Crow Arrive");
		jCounter = new JLabel("" + counter);
		
		JPanel jp = new JPanel(new GridLayout(1, 3, 5, 5));
		jp.add(jCrowDeparture);
		jp.add(jCounter);
		jp.add(jCrowArrive);
		add(jp);
		
		setSize(400, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setActionListener();
	}
	
	private void setActionListener() {
		jCrowDeparture.addActionListener(getDepartureListener());
		jCrowArrive.addActionListener(getArriveListener());
	}

	private ActionListener getArriveListener() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jCounter.setText("" + (++counter));
			}
		};
	}
	
	private ActionListener getDepartureListener() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (counter > 0) {
					jCounter.setText("" + (--counter));	
				}
			}
		};
	}
}
