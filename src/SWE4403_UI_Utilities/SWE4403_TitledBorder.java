package SWE4403_UI_Utilities;

import javax.swing.border.TitledBorder;

import SWE4403_Font.SWE4403_StandardFont;

public class SWE4403_TitledBorder extends TitledBorder {

	public SWE4403_TitledBorder(String title) {
		super(title);
		setTitleFont(SWE4403_StandardFont.getInstance());
	}

}
