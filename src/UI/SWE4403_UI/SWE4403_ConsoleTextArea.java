package SWE4403_UI;

import javax.swing.JTextArea;

public class SWE4403_ConsoleTextArea extends JTextArea {

	private static SWE4403_ConsoleTextArea instance = null;

	private SWE4403_ConsoleTextArea() {
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

	public static SWE4403_ConsoleTextArea getInstance() {
		if (instance == null)
			instance = new SWE4403_ConsoleTextArea();
		return instance;
	}

	public void log(String message) {
		String currentText = getText();

		currentText += "\n\n============================================================\n\n" + message
				+ "\n\n============================================================";

		setText(currentText);
	}
}
