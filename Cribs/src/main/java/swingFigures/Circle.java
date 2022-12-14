package swingFigures;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Circle extends Ellipse2D {

    private Point p;
    private double width;
    private double height;

    public Circle () {
        p = new Point();
    }

    public Circle (double x, double y, double w, double h) {
        p = new Point(x, y);
        width = w;
        height = h;
    }

    @Override
    public Rectangle2D getBounds2D () {
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
        return false;
    }

    @Override
    public void setFrame (double x, double y, double w, double h) {
        p.setLocation(x, y);
        width = w;
        height = h;
    }
}
