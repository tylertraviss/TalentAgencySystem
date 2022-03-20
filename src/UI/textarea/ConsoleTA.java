package UI.textarea;

import javax.swing.JTextArea;

import UI.fonts.StandardFont;

public class ConsoleTA extends JTextArea {

	private static ConsoleTA instance = null;
	private String context;

	/*
	 * Private Constructor : Singleton
	 */
	private ConsoleTA() {
		context = "";
		setEditable(false);
		setLineWrap(true);
		setWrapStyleWord(true);

		var standardFont = StandardFont.getInstance();

		setFont(standardFont);
	}

	public static ConsoleTA getInstance() {
		if (instance == null)
			instance = new ConsoleTA();

		return instance;
	}

	public void log(String string) {
		// get position before writing
		var start = getCaretPosition();

		context += string + System.lineSeparator() + System.lineSeparator();
		setText(context);

		// get position after writing
		var end = getCaretPosition();

		setCaretPosition(end);
		moveCaretPosition(start + 10);

		requestFocus();
		revalidate();
		repaint();

	}

}
