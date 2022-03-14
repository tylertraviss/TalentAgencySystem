package SWE4403_UI_Components;

import javax.swing.JTextArea;

import SWE4403_Font.SWE4403_StandardFont;

public class SWE4403_ConsoleTextArea extends JTextArea {

	/**
	 * UNUSED CLASS. CAN BE DELELETED
	 */

	private static SWE4403_ConsoleTextArea instance = null;

	private SWE4403_ConsoleTextArea() {
		super();
		// ## remove the line below
		this.setText("Placeholder text. Replace this with something else when the system is completed.");
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

		// formatting console display text
		currentText += "\n\n=========================================================\n\n" + message
				+ "\n\n=========================================================";

		setText(currentText);
	}
}
