package swingFigures;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings ("serial")
public class GraphicsPanel extends JPanel {

    private Line[] line = new Line[4];
    private Rectangle rect;
    private RectangleRound rect2;
    private Circle circ;

    public GraphicsPanel () {
	line[0] = new Line(20, 20, 120, 20);
	line[1] = new Line(20, 20, 20, 120);
	line[2] = new Line(120, 20, 120, 120);
	line[3] = new Line(20, 120, 120, 120);

	rect = new Rectangle(170, 200, 75, 100);
	rect2 = new RectangleRound(150, 280, 75, 100, 20, 20);
	
	circ = new Circle(100, 250, 75, 100);
    }

    @Override
    protected void paintComponent (Graphics g) {
	Graphics2D g2 = (Graphics2D) g;

	for (Line l : line) {
	    g2.draw(l);
	}
	g2.draw(rect);
	g2.draw(rect2);
	g2.draw(circ);
    }
}
