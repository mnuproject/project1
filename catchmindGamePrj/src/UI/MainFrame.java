package UI;
import javax.swing.*;

public class MainFrame extends JFrame{
	private static MainFrame singleton;
	
	private MainFrame() {
		setTitle("캐치마인드");
		setResizable(false);
		setSize(1100, 750);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static MainFrame getMainFrame() {
		if (singleton == null) {
			UiTool.mainFrame = new MainFrame();
		}
		return UiTool.mainFrame;
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
