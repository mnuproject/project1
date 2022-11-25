package res;

import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;

import client.Brush;

public class res {
	// Brush 좌표값
	public static int x, y;
	// Brush 색깔
	// Color color;
	
	// Draw에 필요한 선언
	public static BufferedImage imgBuff;
	public static JLabel drawLabel;
	public static JPanel drawPanel;
	public static Brush brush;
	public static String sendDraw = null;
	public static String sendColor = null;
	public static boolean drawPPAP = true;
}
