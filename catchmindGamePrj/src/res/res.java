package res;

import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;

import client.Brush;

public class res {
	
	
	// 턴이 변화할 때 마다 제시어를 순차적으로 선택하는 변수.
	public static int selectProblem = 0;
	
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
