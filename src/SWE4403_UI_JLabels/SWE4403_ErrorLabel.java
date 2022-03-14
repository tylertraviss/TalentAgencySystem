package SWE4403_UI_JLabels;

import java.awt.Color;

public class SWE4403_ErrorLabel extends SWE4403_ConsoleLabel {

	public SWE4403_ErrorLabel(String msg) {
		super(msg);
		this.setForeground(Color.RED);
	}

	@Override
	public SWE4403_ConsoleLabel genLabel(String message) {
		return new SWE4403_ErrorLabel("<html>" + message + "</html>");
	}

}
