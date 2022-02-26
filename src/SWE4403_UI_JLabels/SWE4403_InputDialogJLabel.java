package SWE4403_UI_JLabels;

import SWE4403_Font.SWE4403_StandardFont;

public class SWE4403_InputDialogJLabel extends SWE4403_HTMLLabel {

	public SWE4403_InputDialogJLabel() {
		super();
		// ## remove the line below
		this.setString("Placeholder Text. <br>IF you are reading this you messed up your code already.");
		this.setFont(SWE4403_StandardFont.getInstance());
	}

}
