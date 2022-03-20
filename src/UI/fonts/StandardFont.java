package UI.fonts;

import java.awt.Font;

public class StandardFont extends Font {

	private static StandardFont instance = null;

	private StandardFont() {
		super("Consolas", Font.PLAIN, 12);
	}

	public static StandardFont getInstance() {
		if (instance == null)
			instance = new StandardFont();
		return instance;
	}
}
