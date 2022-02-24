package SWE4403_UI_Components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import SWE4403_UI_JLabels.SWE4403_AcceptedLabel;
import SWE4403_UI_JLabels.SWE4403_ErrorLabel;
import SWE4403_UI_JLabels.SWE4403_NormalLabel;
import SWE4403_UI_JLabels.SWE4403_WarningLabel;
import SWE4403_UI_Utilities.SWE4403_MessageType;

public class SWE4403_ConsolePanel extends JPanel {

	private static SWE4403_ConsolePanel instance = null;

	private SWE4403_ConsolePanel() {
//		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.BLACK);
	}

	public static SWE4403_ConsolePanel getInstance() {
		if (instance == null)
			instance = new SWE4403_ConsolePanel();

		return instance;
	}

	public void log(String message, SWE4403_MessageType type) {

		switch (type) {
		case NORMAL:
			this.add(new SWE4403_NormalLabel(message));
			break;
		case WARNING:
			this.add(new SWE4403_WarningLabel(message));
			break;
		case ERROR:
			this.add(new SWE4403_ErrorLabel(message));
			break;
		case ACCEPT:
			this.add(new SWE4403_AcceptedLabel(message));
			break;
		default:
			this.add(new SWE4403_ErrorLabel("Unknown message type"));
		}

		this.add(Box.createRigidArea(new Dimension(10, 10)));
		this.revalidate();
		this.repaint();
	}
}
