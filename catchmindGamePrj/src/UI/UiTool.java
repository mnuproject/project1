package UI;

import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class UiTool {
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
}
