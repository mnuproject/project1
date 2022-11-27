package UI;
import javax.swing.*;

public class MainFrame extends JFrame{
	private static MainFrame singleton;
	
	private MainFrame() {
		setTitle("캐치마인드");
		setResizable(false);
		setSize(1100, 750);
		add(new Ui6());
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static MainFrame getMainFrame() {
		if (singleton == null) {
			singleton = new MainFrame();
		}
		return singleton;
	}
}
