package UI.fonts;

import java.awt.Font;

public class LargeFont extends Font {

	public static LargeFont instance = null;

	private LargeFont() {
		super("Consolas", Font.PLAIN, 25);
	}

	public static LargeFont getInstance() {
		if (instance == null)
			instance = new LargeFont();
		return instance;
	}
}
