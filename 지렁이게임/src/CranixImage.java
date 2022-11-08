import java.awt.*;
import java.awt.image.*;

public class CranixImage {
	private int left = 0;
	private int top = 0;
	private Image img = null;
	private boolean live = true;
	public CranixImage() {
		this(0,0,null);
	}
	public CranixImage(int left,int top) {
		this(left,top,null);
	}
	public CranixImage(int left,int top,Image img) {
		this.left = left;
		this.top = top;
		this.img = img;
	}
	public int getLeft() {
		return left;
	}
	public int getTop() {
		return top;
	}
	public Image getImage() {
		return img;
	}
	public boolean isLive() {
		return live;
	}

	public void setLeft(int left) { 
		this.left = left;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public void setImage(Image img) {
		this.img = img;
	}
	public void setLive(boolean flag) {
		this.live = flag;
	}
}
