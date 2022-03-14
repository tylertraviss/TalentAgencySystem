package SWE4403_UI_JLabels;

import SWE4403_Font.SWE4403_LargeFont;

public class SWE4403_EditDialogJLabel extends SWE4403_HTMLLabel {

	public SWE4403_EditDialogJLabel() {
		super();
		// ## remove the line below
		this.setString("Placeholder Text. <br>IF you are reading this you messed up your code already.");
		this.setFont(SWE4403_LargeFont.getInstance());
	}

}