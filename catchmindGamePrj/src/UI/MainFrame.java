package UI;

import java.awt.*;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
	private static MainFrame singleton;
	
	public MainFrame() {
		setTitle("캐치마인드");
		setResizable(false);
		setSize(800, 640);
		
		add(new Ui1());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static MainFrame getMainFrame() {
		if (singleton == null) {
			singleton = new MainFrame();
		}
		return singleton;
	}
}
