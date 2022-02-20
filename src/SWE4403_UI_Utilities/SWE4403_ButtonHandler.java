package SWE4403_UI_Utilities;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import SWE4403_UI_Buttons.SWE4403_AddClientButton;
import SWE4403_UI_Buttons.SWE4403_AddEmployeeButton;
import SWE4403_UI_Buttons.SWE4403_CancelButton;
import SWE4403_UI_Buttons.SWE4403_EditClientButton;
import SWE4403_UI_Buttons.SWE4403_EditEmployeeButton;
import SWE4403_UI_Buttons.SWE4403_OkButton;
import SWE4403_UI_Buttons.SWE4403_RemoveClientButton;
import SWE4403_UI_Buttons.SWE4403_RemoveEmployeeButton;
import SWE4403_UI_Components.SWE4403_ConsoleTextArea;
import SWE4403_UI_Dialogs.SWE4403_AddClientDialog;
import SWE4403_UI_Dialogs.SWE4403_AddEmployeeDialog;
import SWE4403_UI_Dialogs.SWE4403_EditClientDialog;
import SWE4403_UI_Dialogs.SWE4403_EditEmployeeDialog;

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
			console.log("Opened edit employee dialog");
		} else if (b instanceof SWE4403_EditClientButton) {
			dialogToOpen = new SWE4403_EditClientDialog(frame);
			console.log("Opened edit client dialog");
		} else if (b instanceof SWE4403_AddEmployeeButton) {
			dialogToOpen = new SWE4403_AddEmployeeDialog(dialog);
			console.log("Opened add new Employee dialog");
		} else if (b instanceof SWE4403_RemoveEmployeeButton) {
			// ##
			log = "To Implement: Add a dialog box to take employee name, then a confirmation to remove that employee\nError opening RemoveEmployeeDialog";
		} else if (b instanceof SWE4403_AddClientButton) {
			dialogToOpen = new SWE4403_AddClientDialog(dialog);
			console.log("Opened add new client dialog");
		} else if (b instanceof SWE4403_RemoveClientButton) {
			// ##
			log = "To Implement: Add a dialog box to take in client name, then a confirmation to remove that employee\nError opening RemoveClientDialog";
		} else if (b instanceof SWE4403_OkButton) {
			switch (((SWE4403_OkButton) b).getType()) {
				case "Client":
					// ##
					console.log("This ok button came from the new client dialog");
					break;
				case "Employee":
					// ##
					console.log("This ok button came from the new employee dialog");
					break;
				default:
					console.log("unknown source of ok button");
			}
		} else if (b instanceof SWE4403_CancelButton) {
			switch (((SWE4403_CancelButton) b).getType()) {
				case "Client":
					// ##
					console.log("This cancel button came from the new client dialog");
					break;
				case "Employee":
					// ##
					console.log("This cancel button came from the new employee dialog");
					break;
				default:
					console.log("unknown source of cancel button");
			}
		} else {
			log = "Unknown button from: " + b.getClass().getCanonicalName();
		}

		if (dialogToOpen != null)
			dialogToOpen.setVisible(true);
		else {
			log += "\nThe dialog box is curerntly not implemented yet";
			console.log(log);
		}
	}

}
