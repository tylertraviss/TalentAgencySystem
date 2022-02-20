package SWE4403_UI_Components;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JScrollPane;

import SWE4403_UI_Utilities.SWE4403_RoundedBorder;

public class SWE4403_ConsoleScrollPane extends JScrollPane {

	public SWE4403_ConsoleScrollPane(Component c) {
		super(c);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		this.setBorder(SWE4403_RoundedBorder.getInstance());
	}

}
