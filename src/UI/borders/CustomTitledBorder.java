package UI.borders;

import javax.swing.border.TitledBorder;

import UI.fonts.StandardFont;

public class CustomTitledBorder extends TitledBorder {

	public CustomTitledBorder(String title) {
		super(title);
		setTitleFont(StandardFont.getInstance());
	}

}
