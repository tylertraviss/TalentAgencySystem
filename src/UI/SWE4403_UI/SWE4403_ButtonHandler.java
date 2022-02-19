package SWE4403_UI;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class SWE4403_ButtonHandler {

	private static SWE4403_ButtonHandler instance = null;
	private static JFrame frame;
	private static JDialog dialog;
	private SWE4403_ConsoleTextArea console;

	private SWE4403_ButtonHandler() {
		console = SWE4403_ConsoleTextArea.getInstance();
	}

	public static SWE4403_ButtonHandler getInstance() {
		if (instance == null)
			instance = new SWE4403_ButtonHandler();

		return instance;
	}

	public void setFrame(JFrame newFrame) {
		frame = newFrame;
	}

	public void setDialog(JDialog newDialog) {
		dialog = newDialog;
	}

	public void handleButton(JButton b) {
		JDialog dialogToOpen = null;
		String log = null;

		if (frame == null && dialog == null) {
			throw new NullPointerException();
		}

		if (b instanceof SWE4403_EditEmployeeButton) {
			dialogToOpen = new SWE4403_EditEmployeeDialog(frame);
			// ##
			console.log("Opened edit employee dialog");
		} else if (b instanceof SWE4403_EditClientButton) {
			dialogToOpen = new SWE4403_EditClientDialog(frame);
			// ##
			console.log("Opened edit client dialog");
		} else if (b instanceof SWE4403_AddEmployeeButton) {
			// ##
			log = "To Implement : Add a dialog box to fill in employee details\nError opening AddEmployeeDialog";
		} else if (b instanceof SWE4403_RemoveEmployeeButton) {
			// ##
			log = "To Implement: Add a dialog box to take employee name, then a confirmation to remove that employee\nError opening RemoveEmployeeDialog";
		} else if (b instanceof SWE4403_AddClientButton) {
			// ##
			log = "To Implement: Add a dialog box to fill in client details\nError opening AddClientDialog";
		} else if (b instanceof SWE4403_RemoveClientButton) {
			// ##
			log = "To Implement: Add a dialog box to take in client name, then a confirmation to remove that employee\nError opening RemoveClientDialog";
		}

		if (dialogToOpen != null)
			dialogToOpen.setVisible(true);
		else {
			log += "\nThe dialog box is curerntly not implemented yet";
			console.log(log);
		}
	}

}
