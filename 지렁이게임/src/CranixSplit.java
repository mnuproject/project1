import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

public class CranixSplit extends CranixImage implements Runnable {
	private Image tiles[] = null;
	private Thread aniThread = null;
	private int nowTile = 0;
	private int interval = 0;
	private boolean loop = true;

	public CranixSplit(Image tiles[],int interval) {
		this(tiles,interval,true);
	}
	public CranixSplit(Image tiles[],int interval,boolean loop) {
		super();
		this.tiles = tiles;
		this.interval = interval;
		this.loop = loop;
	}
	public void start() {
		nowTile = 0;
		setLive(true);
		aniThread = new Thread(this);
		aniThread.start();
	}
	public void stop() {
		nowTile = 0;
		setLive(false);
		aniThread.interrupt();
	}

	public void run() {
		try {
			while(isLive()) {
				setImage(tiles[nowTile]);
				Thread.sleep(interval);
				if (nowTile+1 >= tiles.length) {
					if (loop)
						nowTile = 0;
					else
						stop();
				}
				else
					nowTile++;
			}
		}
		catch(Exception e) {
		}
	}
}
