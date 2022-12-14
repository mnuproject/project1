package server;
import javax.swing.*;

import client.Client;

public class MainFrame extends JFrame{
	public static MainFrame mainframe;
	
	private MainFrame() {
		setTitle("캐치마인드 서버");
		setResizable(false);
		setSize(1100, 750);
		add(Ui9.getUi9());
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static MainFrame getMainFrame() {
		if (mainframe == null) {
			mainframe = new MainFrame();
		}
		return mainframe;
	}
}
