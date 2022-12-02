package UI;
import javax.swing.*;

import client.Client;

public class MainFrame extends JFrame{
	public static MainFrame singleton;
	public static Client clnt;
	
	private MainFrame() {
		clnt = new Client();
		clnt.connectServer();
		
		setTitle("캐치마인드");
		setResizable(false);
		setSize(1100, 750);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static MainFrame getMainFrame() {
		if (singleton == null) {
			singleton = new MainFrame();
		}
		return singleton;
	}
	
	public void setUI(JPanel rmPanel, JPanel panel) {
		getContentPane().remove(rmPanel);
		add(panel);
		setVisible(true);
	}
	
	public void setUI(JPanel panel) {
		add(panel);
		setVisible(true);
	}
}
