import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;

public class CranixGraphics {
	private Graphics frontGraphics = null;

	private Graphics buffGraphics = null;
	private BufferedImage buffImage = null;

	private int width = 0;
	private int height = 0;

	private Vector imageVector = null;

	public CranixGraphics(int width,int height,Graphics g) {
		this.width = width;
		this.height = height;
		frontGraphics = g;
		buffImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		imageVector = new Vector();
	}
	public void addCranixImage(String id,CranixImage ci) { // 처음 추가될때 자동으로 이미지는 한번 그려진다.
		Object obj[] = new Object[2];
		obj[0] = id;
		obj[1] = ci;
		imageVector.addElement(obj);
		drawImage(ci);
	}
	public void removeCranixImage(String id) {
		int i = 0;
		Object obj[] = null;
		for (i=0;i<imageVector.size();i++) {
			obj = (Object[])imageVector.elementAt(i);
			if (id.equals((String)obj[0])) {
				imageVector.removeElementAt(i);
				break;
			}
		}
	}
	public CranixImage getCranixImage(String id) {
		int i = 0;
		Object obj[] = null;
		for (i=0;i<imageVector.size();i++) {
			obj = (Object[])imageVector.elementAt(i);
			if (id.equals((String)obj[0])) {
				return (CranixImage)obj[1];
			}
		}
		return null;
	}


	public boolean drawImage(CranixImage ci) {
		return drawImage(ci.getImage(),ci.getLeft(),ci.getTop());
	}
	public boolean drawImage(Image img,int left,int top) {
		if (img == null)
			return false;
		buffGraphics = buffImage.getGraphics();
		return buffGraphics.drawImage(img,left,top,null);
	}
	public Graphics getBackGraphics() {
		return buffImage.getGraphics();
	}
	public void update(ImageObserver observer) {
		Object obj[] = null;
		CranixImage ci = null;
		int i = 0;
		String id = null;

		frontGraphics.drawImage(buffImage,0,0,observer); 


		for (i=0;i<imageVector.size();i++) {
			obj = (Object[])imageVector.elementAt(i);
			id = (String)obj[0];
			ci = (CranixImage)obj[1];
			drawImage(ci);
			if (!ci.isLive()) 
				removeCranixImage(id);
		}
		buffGraphics.dispose();
	}
}
