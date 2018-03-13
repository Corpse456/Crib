package swingFigures;

import java.awt.geom.Rectangle2D;

public class Rectangle extends Rectangle2D {

    private Point p;
    private double width;
    private double height;
    
    public Rectangle () {
	p = new Point();
    }
    
    public Rectangle (double x, double y, double w, double h) {
	p = new Point(x, y);
	width = w;
	height = h;
    }

    @Override
    public void setRect (double x, double y, double w, double h) {
	p.setLocation(x, y);
	width = w;
	height = h;
    }

    @Override
    public int outcode (double x, double y) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public Rectangle2D createIntersection (Rectangle2D r) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Rectangle2D createUnion (Rectangle2D r) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public double getX () {
	return p.getX();
    }

    @Override
    public double getY () {
	return p.getY();
    }

    @Override
    public double getWidth () {
	return width;
    }

    @Override
    public double getHeight () {
	return height;
    }

    @Override
    public boolean isEmpty () {
	if (width * height <= 0) {
	    return false;
	}
	return true;
    }

}
