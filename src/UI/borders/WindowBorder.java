package UI.borders;

import java.awt.Color;

import javax.swing.border.LineBorder;

public class WindowBorder extends LineBorder {

	private static WindowBorder instance = null;

	private WindowBorder() {
		super(Color.ORANGE);
	}

	public static WindowBorder getInstance() {
		if (instance == null)
			instance = new WindowBorder();

		return instance;
	}

}
