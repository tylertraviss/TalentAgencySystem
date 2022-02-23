package SWE4403_UI_JLabels;

import javax.swing.JLabel;

import SWE4403_UI_Utilities.SWE4403_StandardFont;

public abstract class SWE4403_ConsoleLabel extends JLabel {

	public SWE4403_ConsoleLabel(String msg) {
		super(msg);
		this.setFont(SWE4403_StandardFont.getInstance());
	}

	public abstract SWE4403_ConsoleLabel genLabel(String message);

}
