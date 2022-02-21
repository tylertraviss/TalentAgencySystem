package SWE4403_UI_Utilities;

import java.awt.Font;

public class SWE4403_PlaceholderFont extends Font {

	private static SWE4403_PlaceholderFont instance = null;

	private SWE4403_PlaceholderFont() {
		super("Consolas", Font.ITALIC, 12);
	}

	public static SWE4403_PlaceholderFont getInstance() {
		if (instance == null)
			instance = new SWE4403_PlaceholderFont();
		return instance;
	}

}
