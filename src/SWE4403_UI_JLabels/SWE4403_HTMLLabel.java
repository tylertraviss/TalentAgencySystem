package SWE4403_UI_JLabels;

import javax.swing.JLabel;

import SWE4403_UI_Utilities.SWE4403_RoundedBorder;

public abstract class SWE4403_HTMLLabel extends JLabel {

	private final static String MESSAGE_HEADER = "<html><center>";
	private final static String MESSAGE_FOOTER = "</center></html>";

	public SWE4403_HTMLLabel() {
		super();
		this.setOpaque(false);
		this.setBorder(SWE4403_RoundedBorder.getInstance());
		this.setFocusable(false);
		this.setHorizontalAlignment(JLabel.CENTER);
	}

	public void setString(String message) {
		setText(MESSAGE_HEADER + message + MESSAGE_FOOTER);
	}

}
