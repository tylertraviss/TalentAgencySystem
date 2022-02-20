package SWE4403_UI_Utilities;

import java.awt.Font;

public class SWE4403_StandardFont extends Font {

	public static SWE4403_StandardFont instance = null;

	private SWE4403_StandardFont() {
		super("Consolas", Font.PLAIN, 12);
	}

	public static SWE4403_StandardFont getInstance() {
		if (instance == null)
			instance = new SWE4403_StandardFont();
		return instance;
	}
}
