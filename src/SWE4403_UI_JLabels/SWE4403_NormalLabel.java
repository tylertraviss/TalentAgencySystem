package SWE4403_UI_JLabels;

import java.awt.Color;

public class SWE4403_NormalLabel extends SWE4403_ConsoleLabel {

	public SWE4403_NormalLabel(String msg) {
		super(msg);
		this.setForeground(Color.WHITE);
	}

	@Override
	public SWE4403_ConsoleLabel genLabel(String message) {
		return new SWE4403_NormalLabel("<html>" + message + "</html>");
	}

}
