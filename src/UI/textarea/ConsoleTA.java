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
		setFont(StandardFont.getInstance());
	}

	public static ConsoleTA getInstance() {
		if (instance == null)
			instance = new ConsoleTA();
		return instance;
	}

	public void log(String string) {
		context += string + System.lineSeparator() + System.lineSeparator();
		setText(context);

		revalidate();
		repaint();
	}

}
