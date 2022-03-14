package SWE4403_UI_Components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;

import SWE4403_UI_Utilities.SWE4403_RoundedBorder;

public class SWE4403_ConsoleScrollPane extends JScrollPane {

	private static SWE4403_ConsoleScrollPane instance = null;

	public SWE4403_ConsoleScrollPane() {
		super(SWE4403_ConsolePanel.getInstance());
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// hide the vertical scroll bar
		this.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		this.setBorder(SWE4403_RoundedBorder.getInstance());
		this.setBackground(Color.BLACK);
	}

	public static SWE4403_ConsoleScrollPane getInstance() {
		if (instance == null)
			instance = new SWE4403_ConsoleScrollPane();
		return instance;
	}

	// public void scrollToBottom() {
	// System.out.println(getVerticalScrollBar().getMaximum());
	// getVerticalScrollBar().setValue(getVerticalScrollBar().getMaximum());
	// }

}
