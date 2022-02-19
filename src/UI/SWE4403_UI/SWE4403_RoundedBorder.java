package SWE4403_UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class SWE4403_RoundedBorder implements Border {

	private int radius;
	private Color color;
	private static SWE4403_RoundedBorder instance = null;

	private SWE4403_RoundedBorder() {
		radius = 10;
		color = Color.BLACK;
	}

	public static SWE4403_RoundedBorder getInstance() {
		if (instance == null)
			instance = new SWE4403_RoundedBorder();

		return instance;
	}

	public Insets getBorderInsets(Component c) {
		return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
	}

	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		g.setColor(color);
		g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
	}

	@Override
	public boolean isBorderOpaque() {
		return true;
	}
}