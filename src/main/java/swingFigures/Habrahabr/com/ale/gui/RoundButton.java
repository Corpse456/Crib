package swingFigures.Habrahabr.com.ale.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

@SuppressWarnings ("serial")
public class RoundButton extends JButton {

    public static void main (String[] args) {
	JButton button = new RoundButton("Jopa");

	JFrame frame = new JFrame();
	frameCreator(button, frame);
    }

    public RoundButton (String label) {
	setText(label);
	setBackground(Color.green);
	Dimension size = getPreferredSize();
	size.width = size.height = 200;
	setPreferredSize(size);
	setContentAreaFilled(false);
    }

    protected void paintComponent (Graphics g) {
	if (getModel().isArmed()) {
	    g.setColor(Color.lightGray);
	} else {
	    g.setColor(getBackground());
	}
	g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

	super.paintComponent(g);
    }

    protected void paintBorder (Graphics g) {
	g.setColor(getForeground());
	g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }

    public boolean contains (int x, int y) {
	Shape shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
	return shape.contains(x, y);
    }

    /**
     * @param button
     * @param frame
     */
    private static void frameCreator (JButton button, JFrame frame) {
	frame.getContentPane().setBackground(Color.yellow);
	frame.getContentPane().add(button);
	frame.getContentPane().setLayout(new FlowLayout());
	frame.setSize(150, 150);
	frame.setVisible(true);
    }
}