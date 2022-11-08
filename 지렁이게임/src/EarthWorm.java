import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class EarthWorm extends JFrame implements Runnable {
	public static final int KEY_LEFT = 37;
	public static final int KEY_RIGHT = 39;
	public static final int KEY_SPACE = 32;
	
	
	private CranixGraphics cg = null;
	private Thread frameThread = null;
	private boolean threadFlag = false;

	private Image bgImage = null;
	private Image logoImage = null;
	private Image gameOverImage = null;
	private Image spaceImage[] = null;

	private CranixSplit spaceSplit = null;

	private int sizeX = 0;
	private int sizeY = 0;

	private int wormPosX = 0;
	private int wormPosY = 0;
	private int wormSize = 15;

	private int foodPosX = 0;
	private int foodPosY = 0;
	private int foodSize = 20;


	private int dir = 0;
	private int gap = 3;
	private int maxWormSize=20;

	private Vector wormPosVector = new Vector();
	private Random random = new Random();

	private int mode = 0; 
		
	
	public EarthWorm() {
		loadImage();
		sizeX = bgImage.getWidth(null);
		sizeY = bgImage.getHeight(null);

		addWindowListener(new EWindowAdapter());
		setResizable(false);
		setTitle("EarthWorm");
		setSize(sizeX,sizeY);
		setVisible(true);
		addKeyListener(new EKeyListener(this));

		cg = new CranixGraphics(sizeX,sizeY,getGraphics());
		cg.addCranixImage("background",new CranixImage(0,0,bgImage));

		initFrame();
		//startGame();
	}

	public void loadImage() {
		// 이미지 로딩
		try {
			spaceImage =new Image[2];
			bgImage = Toolkit.getDefaultToolkit().getImage("resource/background.jpg");
			logoImage = Toolkit.getDefaultToolkit().getImage("resource/earthworm.gif");
			gameOverImage = Toolkit.getDefaultToolkit().getImage("resource/gameover.gif");
			spaceImage[0] = Toolkit.getDefaultToolkit().getImage("resource/spaceani1.gif");
			spaceImage[1] = Toolkit.getDefaultToolkit().getImage("resource/spaceani2.gif");
			MediaTracker mt = new MediaTracker(this);
			mt.addImage(bgImage,0);
			mt.addImage(logoImage,1);
			mt.addImage(gameOverImage,2);
			mt.addImage(spaceImage[0],3);
			mt.addImage(spaceImage[1],4);
		
			mt.waitForAll();

			spaceSplit = new CranixSplit(spaceImage,500);
			spaceSplit.setLeft(430);
			spaceSplit.setTop(380);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void initFrame() {
		spaceSplit.start();
		threadFlag = true;
		frameThread = new Thread(this);
		frameThread.start();
		cg.addCranixImage("logo",new CranixImage(300,300,logoImage));
		cg.addCranixImage("space",spaceSplit);
		mode = 1;

	}

	public void startGame() {
		wormPosX = (int)(sizeX / 2);
		wormPosY = (int)(sizeY / 2);
		wormPosVector.clear();
		maxWormSize = 20;
		gap = 5;
		dir = 1;
		makeFood();
		spaceSplit.stop();
		cg.removeCranixImage("logo");
		cg.removeCranixImage("space");
		mode = 2;
	}
	public void gameOver() {
		spaceSplit.start();
		cg.addCranixImage("logo",new CranixImage(300,300,gameOverImage));
		cg.addCranixImage("space",spaceSplit);
		mode = 3;
		dir = 0;
	}

	public void playGame() {
		int i = 0;
		int posXY[] = new int[2];
		posXY[0] = wormPosX;
		posXY[1] = wormPosY;
		wormPosVector.addElement(posXY);

		if (mode == 2) {
			if (wormPosVector.size() == maxWormSize) {
				wormPosVector.removeElementAt(0);
			}
		}
		Graphics g = cg.getBackGraphics();
		g.setColor(Color.RED);
		switch(dir) {
			case 1:
				wormPosX+=gap;
				break;
			case 2:
				wormPosX+=gap;
				wormPosY+=gap;
				break;
			case 3:
				wormPosY+=gap;
				break;
			case 4:
				wormPosX-=gap;
				wormPosY+=gap;
				break;
			case 5:
				wormPosX-=gap;
				break;
			case 6:
				wormPosX-=gap;
				wormPosY-=gap;
				break;
			case 7:
				wormPosY-=gap;
				break;
			case 8:
				wormPosX+=gap;
				wormPosY-=gap;
				break;
		}
		crashTest(wormPosX,wormPosY);
		g.fillArc(wormPosX,wormPosY,wormSize,wormSize,0,360);
		for (i=0;i<wormPosVector.size();i++) {
			posXY = (int[])wormPosVector.elementAt(i);
			g.fillArc(posXY[0],posXY[1],wormSize,wormSize,0,360);
		}
		g.setColor(Color.BLUE);
		g.fillArc(foodPosX,foodPosY,foodSize,foodSize,0,360);
		g.setColor(Color.BLACK);
		g.drawString("WormSize : " + maxWormSize,10,50);
	}
	public void crashTest(int x,int y) {
		if (mode != 2)
			return;
		int posXY[] = null;
		int i = 0;
		int halfFoodSize = (int)(foodSize /2);
		for (i=0;i<wormPosVector.size();i++) {
			posXY = (int[])wormPosVector.elementAt(i);
			if (posXY[0] == x && posXY[1] == y) {
				gameOver();
				break;
			}
			if (posXY[0] <= 0 || posXY[1] <= 0 || posXY[0] >= sizeX || posXY[1] >= sizeY) {
				gameOver();
				break;
			}
			if ((posXY[0] <= foodPosX+halfFoodSize && posXY[0] >= foodPosX-halfFoodSize) && (posXY[1] <= foodPosY+halfFoodSize && posXY[1] >= foodPosY-halfFoodSize)) {
				eat();
				break;
			}
		}
	}
	public void makeFood() {
		foodPosX = random.nextInt(sizeX-foodSize*2) +foodSize;
		foodPosY = random.nextInt(sizeY-foodSize*2) +foodSize;
	}

	public void eat() {
		maxWormSize +=20;
		makeFood();
	}

	public void moveRight() {
		if (mode != 2)
			return;
		if (dir+1 == 9)
			dir = 1;
		else
			dir++;
	}
	public void moveLeft() {
		if (mode != 2)
			return;
		if (dir-1 == 0)
			dir = 8;
		else
			dir--;
	}
	public void pushSpace() {
		if (mode == 1 || mode == 3) { // 초기화 완료거나 게임오버일때 스페이스를 누르면 게임시작이다.
			startGame();
		}
	}

	public void run() {
		try {
			while(threadFlag) {
				playGame();
				cg.update(this);
				Thread.sleep(40);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		new EarthWorm();
	}
}



class EWindowAdapter extends WindowAdapter {
	public void windowClosing(WindowEvent we) {
		System.exit(0);
	}
}
class EKeyListener extends KeyAdapter {
	private EarthWorm eworm = null;
	public EKeyListener(EarthWorm eworm) {
		this.eworm = eworm;
	}
	public void keyPressed(KeyEvent ke) {
		switch(ke.getKeyCode()) {
		case EarthWorm.KEY_RIGHT:
			eworm.moveRight();
			break;
		case EarthWorm.KEY_LEFT:
			eworm.moveLeft();
			break;
		case EarthWorm.KEY_SPACE:
			eworm.pushSpace();
			break;
		}
	}
}

