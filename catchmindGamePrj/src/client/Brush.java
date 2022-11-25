package client;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

// 그리기 위한 펜을 만들어 주는 클래스
public class Brush extends JLabel {
	public int xx, yy;
	public Color color = Color.BLACK;
	public boolean drawPen = true;
	public boolean clearC = true;

	@Override
	public void paint(Graphics g) {
		if (drawPen == true) {
			g.setColor(color);
			g.fillOval(xx - 10, yy - 10, 10, 10);
			System.out.println(res.res.drawPPAP);
		} else if (drawPen == false) {
			g.setColor(Color.WHITE);
			g.fillOval(0, 0, 0, 0);
			System.out.println(res.res.drawPPAP);
			System.out.println("브러쉬 사용 못 하게 막음");
		}
		if (clearC == true) {
			g.setColor(color);
			g.fillOval(xx - 10, yy - 10, 10, 10);
		} else if (clearC == false) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 1000, 1000);
			clearC = true;
			System.out.println("캔버스 클리어 실행됨");
		}

	}

	public void setX(int x) {
		this.xx = x;
	}

	public void setY(int y) {
		this.yy = y;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setDrawPen(boolean drawPen) {
		this.drawPen = drawPen;
	}

	public void setClearC(boolean clearC) {
		this.clearC = clearC;
	}
}

