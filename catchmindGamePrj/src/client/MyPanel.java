package client;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

// 이미지 삽입용 클래스
public class MyPanel extends JPanel {
	private ImageIcon icon = new ImageIcon("img/catchMindBG.png");
	private Image imgMain = icon.getImage();

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imgMain, 0, 0, getWidth(), getHeight(), null);
	}
};