public class TestPoint {
	public TestPoint(Point nowPoint,int degree,int size) {
		Point vectorPoint = getVectorPoint(nowPoint,degree,size);
		System.out.println("Vector X:" + vectorPoint.getX());
		System.out.println("Vector Y:" + vectorPoint.getY());
	}

	public Point getVectorPoint(Point nowPoint,int degree,int size) {
		double radians = Math.toRadians(degree);
		double x = Math.cos(radians) * (size) + nowPoint.getX();
		double y = Math.sin(radians) * (size) + nowPoint.getY();
		//System.out.println(Math.cos(Math.toRadians(60)));
		return new Point(new Long(Math.round(x)).intValue(),new Long(Math.round(y)).intValue());
	}

	public static void main(String args[]) {
		Point nowPoint = new Point(0,0);
		new TestPoint(nowPoint,10,5);
	}
}

class Point {
	private int x = 0;
	private int y = 0;
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
