package UI;

import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class UiTool {
	public static MainFrame mainFrame;
	
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

	public void setUI(JPanel rmPanel, JPanel panel) {
		UiTool.mainFrame.setUI(rmPanel, panel);
	}
	
	/*
	public void setUI1(JPanel rmPanel, JPanel panel) {
		mainFrame.getContentPane().remove(rmPanel);
		mainFrame.add(panel);
		mainFrame.setVisible(true);
	}
	
	public void setUI1(JPanel panel) {
		mainFrame.add(panel);
		mainFrame.setVisible(true);
	}
	*/
}
