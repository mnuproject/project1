package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends Canvas implements MouseMotionListener, ComponentListener{
	public static LinkedList<Point> mousePointList = new LinkedList<>();
	public static LinkedList<Color> mouseColorList = new LinkedList<>();
	private Color color;
	
	private Graphics bufferGraphics;
	private Image offScreen;
	
	public Screen() {
		addMouseMotionListener(this);
		addComponentListener(this);
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				//repaint();
			}
		}, 0, 1);
	}
	
	private void initBuffer() {
		this.offScreen = UiTool.mainFrame.createImage(getWidth(), getHeight());
		this.bufferGraphics = offScreen.getGraphics();
	}
	
	@Override
	public void paint(Graphics g) {
		for (int i=0; i < mousePointList.size(); i++) {
			Point point = mousePointList.get(i);
			bufferGraphics.setColor(mouseColorList.get(i));
			bufferGraphics.fillOval(point.x, point.y, 10, 10);
		}
		
		g.drawImage(offScreen, getWidth(), getHeight(), null);
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setClear() {
		mousePointList.clear();
		mouseColorList.clear();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) { 
		mousePointList.add(e.getPoint());
		mouseColorList.add(color);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
		initBuffer();
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		
	}
}
