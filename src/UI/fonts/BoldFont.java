package UI.fonts;

import java.awt.Font;

public class BoldFont extends Font {

	private static BoldFont instance = null;

	private BoldFont() {
		super("Consolas", Font.BOLD, 12);
	}

	public static BoldFont getInstance() {
		if (instance == null)
			instance = new BoldFont();
		return instance;
	}
}
