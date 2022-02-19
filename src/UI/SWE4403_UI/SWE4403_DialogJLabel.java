package SWE4403_UI;

import javax.swing.JLabel;

public class SWE4403_DialogJLabel extends JLabel {

	private final static String MESSAGE_HEADER = "<html><center>";
	private final static String MESSAGE_FOOTER = "</center></html>";

	public SWE4403_DialogJLabel() {
		super();
		// ## remove the line below
		this.setString("Placeholder Text. <br>If you are reading this you fcked up somewhere.");
		this.setFocusable(false);
		this.setFont(SWE4403_LargeFont.getInstance());
		this.setOpaque(false);
		this.setBorder(SWE4403_RoundedBorder.getInstance());
		this.setHorizontalAlignment(JLabel.CENTER);
	}

	public void setString(String message) {
		setText(MESSAGE_HEADER + message + MESSAGE_FOOTER);
	}

}
