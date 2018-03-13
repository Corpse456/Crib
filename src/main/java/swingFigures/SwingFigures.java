package swingFigures;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;

public class SwingFigures {

    public static void main (String[] args) {
	JFrame frame = new JFrame();

	frame.setTitle("Store");
	frame.setSize(new Dimension(600, 400));
	frame.setLocationRelativeTo(null);
	frame.setLayout(new GridBagLayout());
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	GraphicsPanel graphicsPanel = new GraphicsPanel();

	frame.add(graphicsPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
		GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));

	frame.setVisible(true);
    }
}