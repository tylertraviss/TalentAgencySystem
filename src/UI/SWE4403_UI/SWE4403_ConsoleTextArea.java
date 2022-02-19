package SWE4403_UI;

import javax.swing.JTextArea;

public class SWE4403_ConsoleTextArea extends JTextArea {

	public SWE4403_ConsoleTextArea() {
		super();
		// ## remove the line below
		this.setText("Placeholder text. If you are reading this you fcked up somewhere.");
		this.setEditable(false);
		this.setFocusable(false);
		this.setFont(SWE4403_StandardFont.getInstance());
		this.setWrapStyleWord(true);
		this.setLineWrap(true);
		this.setOpaque(false);
		this.setBorder(null);
	}
}
