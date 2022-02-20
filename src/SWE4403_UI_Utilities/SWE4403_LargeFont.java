package SWE4403_UI_Utilities;

import java.awt.Font;

public class SWE4403_LargeFont extends Font {

	public static SWE4403_LargeFont instance = null;

	private SWE4403_LargeFont() {
		super("Consolas", Font.PLAIN, 25);
	}

	public static SWE4403_LargeFont getInstance() {
		if (instance == null)
			instance = new SWE4403_LargeFont();
		return instance;
	}
}
