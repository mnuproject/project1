package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends Canvas implements MouseMotionListener, ComponentListener{
	public static Screen screen;
	public static LinkedList<Point> mousePointList = new LinkedList<>();
	public static LinkedList<Color> mouseColorList = new LinkedList<>();
	public static boolean isDrawing = false;
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
		this.offScreen = MainFrame.singleton.createImage(getWidth(), getHeight());
		this.bufferGraphics = offScreen.getGraphics();
	}
	
	@Override
	public void paint(Graphics g) {
		try {
			bufferGraphics.clearRect(0, 0, 650, 520);
			bufferGraphics.setColor(Color.WHITE);
			bufferGraphics.fillRect(0, 0, 650, 520);
			
			int siz = mousePointList.size();
			for (int i=0; i<siz-1; i++){
				//System.out.println(String.format("%d/%d | ori : %d", i, mousePointList.size(), siz));
				//Thread.sleep(300);
				
				Point point = mousePointList.get(i);
				bufferGraphics.setColor(mouseColorList.get(i));
				bufferGraphics.fillOval(point.x, point.y, 10, 10);
			}
			
			g.drawImage(offScreen, 0, 0, null);
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				System.out.println("인덱스 오류");
				Thread.sleep(100000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//System.out.println("out index error ");
		}
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
	
	@Override
	public void mouseDragged(MouseEvent e) {
		String xy = String.format("%d,%d", e.getPoint().x, e.getPoint().y);
		//MainFrame.clnt.sendDraw(String.format("%d,%d", e.getPoint().x, e.getPoint().y));
		
		if (modeEraser == false) {
			mousePointList.add(e.getPoint());
			mouseColorList.add(color);
		}
		else if (modeEraser == true) {
			for (int i=0; i<mousePointList.size(); i++) {
				Point point = mousePointList.get(i);
				Point gPoint = e.getPoint();
				
				if ((gPoint.x > point.x-20 && gPoint.x < point.x+20) && (gPoint.y > point.y-20 && gPoint.y < point.y+20)) {
					mousePointList.remove(i);
					mouseColorList.remove(i);
				}
			}
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
}
