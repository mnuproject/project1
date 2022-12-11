package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends Canvas implements MouseMotionListener, ComponentListener{
	private static Screen screen;
	public static LinkedList<Point> mousePointList = new LinkedList<>();
	public static LinkedList<Color> mouseColorList = new LinkedList<>();
	private boolean modeEraser = false;
	private Color color;
	
	private Graphics bufferGraphics;
	private Image offScreen;
	
	private Screen() {
		addMouseMotionListener(this);
		addComponentListener(this);
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				repaint();
			}
		}, 0, 1);
	}
	
	public static Screen getScreen() {
		if (screen == null) {
			screen = new Screen();
		}
		
		return screen;
	}
	
	private void initBuffer() {
		this.offScreen = MainFrame.getMainFrame().createImage(getWidth(), getHeight());
		this.bufferGraphics = offScreen.getGraphics();
	}
	
	@Override
	public synchronized void paint(Graphics g) {
		try {
			bufferGraphics.clearRect(0, 0, 650, 520);
			bufferGraphics.setColor(Color.WHITE);
			bufferGraphics.fillRect(0, 0, 650, 520);
			
			for (int i=0; i<mousePointList.size(); i++){
				Point point = mousePointList.get(i);
				bufferGraphics.setColor(mouseColorList.get(i));
				bufferGraphics.fillOval(point.x, point.y, 10, 10);
			}
			
			g.drawImage(offScreen, 0, 0, null);
		} catch (Exception e) {}
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	public void setColor(Color color) {
		this.modeEraser = false;
		this.color = color;
	}
	
	public void setClear() {
		mousePointList.clear();
		mouseColorList.clear();
	}
	
	public void setEraser() {
		this.modeEraser = true;
	}

	public void addPoint(Point point) {
		this.modeEraser = false;
		mousePointList.add(point);
	}
	
	public void addColor(Color color) {
		mouseColorList.add(color);
	}
	
	public void eraser(Point EarserPoint) {
		for (int i=0; i<mousePointList.size(); i++) {
			Point point = mousePointList.get(i);	
			if ((EarserPoint.x > point.x-20 && EarserPoint.x < point.x+20) && (EarserPoint.y > point.y-20 && EarserPoint.y < point.y+20)) {
				mousePointList.remove(i);
				mouseColorList.remove(i);
			}
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {		
		if (modeEraser == false) {
			MainFrame.clnt.sendDraw(String.format("%d,%d", e.getPoint().x, e.getPoint().y));
			MainFrame.clnt.sendColor(getColor(color));
		}
		else if (modeEraser == true) {
			MainFrame.clnt.sendEraser(String.format("%d,%d", e.getPoint().x, e.getPoint().y));
		}
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
	
	private String getColor(Color color) {
		if (color == Color.BLACK) {
			return "Black";
		}
		else if (color == Color.RED) {
			return "Red";
		}
		else if (color == Color.ORANGE) {
			return "Orange";
		}
		else if (color == Color.YELLOW) {
			return "Yellow";
		}
		else if (color == Color.GREEN) {
			return "Green";
		}
		else if (color == Color.CYAN) {
			return "Cyan";
		}
		else if (color == Color.BLUE) {
			return "Blue";
		}
		else if (color == Color.MAGENTA) {
			return "Purple";
		}
		return null;
	}
}
