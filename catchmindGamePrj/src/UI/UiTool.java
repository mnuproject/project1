package UI;

import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class UiTool {
	//private JPanel[] uiList = {new Ui1(), new Ui2(), new Ui3(), new Ui4(), new Ui5(), new Ui6(), new Ui7()};
	
	public UiTool() {
		
	}
	
	public ImageIcon getImg(String filepath, int width, int height) {
		try {
			ImageIcon icon = new ImageIcon(ImageIO.read(new File(filepath)));
			Image img = icon.getImage().getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
			return new ImageIcon(img);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Font ftSmall() {
		return new Font("맑은고딕", Font.BOLD, 16);
	}

	public Font ftMedium() {
		return new Font("맑은고딕", Font.BOLD, 24);
	}
	
	public Font ftLarge() {
		return new Font("맑은고딕", Font.BOLD, 36);	
	}

	
	/*public void setUI(int removeUi, int UI) {
		if (removeUi > 0) {
			MainFrame.getMainFrame().getContentPane().remove(uiList[removeUi]);
			MainFrame.getMainFrame().add(uiList[UI]);
		}
	}*/
}
