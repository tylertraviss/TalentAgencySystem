package UI.borders;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class RoundedBorder implements Border {

	private int radius;
	private Color color;
	private static RoundedBorder instance = null;

	private RoundedBorder() {
		radius = 10;
	}

	public static RoundedBorder getInstance() {
		if (instance == null)
			instance = new RoundedBorder();

		instance.color = Color.GRAY;

		return instance;
	}

	public static RoundedBorder getInstance(Color color) {
		if (instance == null)
			instance = new RoundedBorder();

		instance.color = color;

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