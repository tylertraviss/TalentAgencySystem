package SWE4403_UI_Components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class SWE4403_ConsolePanel extends JPanel {

	private static SWE4403_ConsolePanel instance = null;

	private SWE4403_ConsolePanel() {
		// this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.BLACK);
	}

	public static SWE4403_ConsolePanel getInstance() {
		if (instance == null)
			instance = new SWE4403_ConsolePanel();

		return instance;
	}

	public void log(Component c) {
		this.add(c);
		this.add(Box.createRigidArea(new Dimension(10, 10)));
		this.revalidate();
		this.repaint();
	}
}
