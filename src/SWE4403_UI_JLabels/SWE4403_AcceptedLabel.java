package SWE4403_UI_JLabels;

import java.awt.Color;

public class SWE4403_AcceptedLabel extends SWE4403_ConsoleLabel {

	public SWE4403_AcceptedLabel(String msg) {
		super(msg);
		this.setForeground(Color.GREEN);
	}

	@Override
	public SWE4403_ConsoleLabel genLabel(String message) {
		return new SWE4403_AcceptedLabel(message);
	}

}
