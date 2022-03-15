package UI.fonts;

import java.awt.Font;

public class PlaceholderFont extends Font {

	private static PlaceholderFont instance = null;

	private PlaceholderFont() {
		super("Consolas", Font.ITALIC, 12);
	}

	public static PlaceholderFont getInstance() {
		if (instance == null)
			instance = new PlaceholderFont();
		return instance;
	}

}
