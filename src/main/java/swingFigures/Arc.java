package swingFigures;

import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;

public class Arc extends Arc2D {

    private Point p;
    private double width;
    private double height;
    private double angSt;
    private double angExt;

    public Arc () {

    }

    public Arc (int type) {
        super(type);
    }

    @Override
    public double getAngleStart () {
        return angSt;
    }

    @Override
    public double getAngleExtent () {
        return angExt;
    }

    @Override
    public void setArc (double x, double y, double w, double h, double angSt, double angExt, int closure) {
        p = new Point(x, y);
        width = w;
        height = h;
        this.angSt = angSt;
        this.angExt = angExt;
    }

    @Override
    public void setAngleStart (double angSt) {
        this.angSt = angSt;
    }

    @Override
    public void setAngleExtent (double angExt) {
        this.angExt = angExt;
    }

    @Override
    protected Rectangle2D makeBounds (double x, double y, double w, double h) {
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
        if (width * height <= 0) { return false; }
        return true;
    }
}
