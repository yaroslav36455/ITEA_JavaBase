package ua.itea.lesson16.tasks;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends JFrame {
	private Engine engine;
	private ImageIcon grass;
	private ImageIcon dog;
	private ImageIcon bomb;
	private ImageIcon firstAidKit;
	private JLabel[][] jLabel;
	
	public Window() {
		engine = new Engine();
		grass = new ImageIcon("img/grass_50x50.jpg");
		dog = new ImageIcon("img/dog_on_grass_50x50.png");
		bomb = new ImageIcon("img/bomb_on_grass_50x50.png");
		firstAidKit = new ImageIcon("img/first_aid_kit_on_grass_50x50.png");
	
		int width = engine.getFieldWidth();
		int height = engine.getFieldHeight();
		
		JPanel jPanel = new JPanel(new GridLayout(width, height, 1, 1));
		
		jLabel = new JLabel[height][width];
		for (int y = 0; y < jLabel.length; y++) {
			for (int x = 0; x < jLabel[y].length; x++) {
				jLabel[y][x] = new JLabel();
				jPanel.add(jLabel[y][x]);
			}
		}
		add(jPanel);
		
		setSize(((grass.getIconWidth() + 1) * width) + 1,
			    ((grass.getIconHeight() + 1) * height) + 1 + 24);
		
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setKeyListener();
		redraw();
	}
	
	private void redraw() {
		int width = engine.getFieldWidth();
		int height = engine.getFieldHeight();
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {				
				switch (engine.getItemId(x + 1, y + 1)) {
				case GRASS:
					jLabel[y][x].setIcon(grass);
					break;
					
				case DOG:
					jLabel[y][x].setIcon(dog);
					break;
					
				case BOMB:
					jLabel[y][x].setIcon(bomb);
					break;
					
				case FIRST_AID_KIT:
					jLabel[y][x].setIcon(firstAidKit);
					break;

				default:
					break;
				}
			}
		}
		
		updateTitle();
	}
	
	private void setKeyListener() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				/* empty */
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				/* empty */	
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					engine.move(Direction.LEFT);
					break;

				case KeyEvent.VK_RIGHT:
					engine.move(Direction.RIGHT);
					break;
					
				case KeyEvent.VK_UP:
					engine.move(Direction.UP);
					break;
					
				case KeyEvent.VK_DOWN:
					engine.move(Direction.DOWN);
					break;
					
				case KeyEvent.VK_R:
					engine.reset();
					break;
					
				default:
					break;
				}
				
				redraw();
			}
		});
	}
	
	private void updateTitle() {
		String title = "Health: " + engine.getDogHealth();
		if (engine.isGameOver()) {
			title += ", [Game Over]";
		}
		setTitle(title);
	}
}
