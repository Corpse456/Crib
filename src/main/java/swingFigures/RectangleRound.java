package swingFigures;

import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class RectangleRound extends RoundRectangle2D {

    private Point p;
    private double width;
    private double height;
    private double arcWidth;
    private double arcHeight;

    public RectangleRound () {
        // TODO Auto-generated constructor stub
    }

    public RectangleRound (double x, double y, double w, double h, double arcWidth, double arcHeight) {
        p = new Point(x, y);

        width = w;
        height = h;

        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
    }

    @Override
    public Rectangle2D getBounds2D () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getArcWidth () {
        return arcWidth;
    }

    @Override
    public double getArcHeight () {
        return arcHeight;
    }

    @Override
    public void setRoundRect (double x, double y, double w, double h, double arcWidth, double arcHeight) {
        p.setLocation(x, y);
        width = w;
        height = h;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
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
