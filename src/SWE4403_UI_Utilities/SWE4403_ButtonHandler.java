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
import SWE4403_UI_Buttons.SWE4403_UndoButton;
import SWE4403_UI_Components.SWE4403_ConsolePanel;
import SWE4403_UI_Dialogs.SWE4403_AddClientDialog;
import SWE4403_UI_Dialogs.SWE4403_AddEmployeeDialog;
import SWE4403_UI_Dialogs.SWE4403_EditClientDialog;
import SWE4403_UI_Dialogs.SWE4403_EditEmployeeDialog;
import SWE4403_UI_Dialogs.SWE4403_RemoveClientInputDialog;
import SWE4403_UI_Dialogs.SWE4403_RemoveEmployeeInputDialog;
import SWE4403_UI_JLabels.SWE4403_AcceptedLabel;
import SWE4403_UI_JLabels.SWE4403_ErrorLabel;
import SWE4403_UI_JLabels.SWE4403_NormalLabel;
import SWE4403_UI_JLabels.SWE4403_WarningLabel;

public class SWE4403_ButtonHandler {

	private static SWE4403_ButtonHandler instance = null;
	private static JFrame frame;
	private static JDialog dialog;
//	private SWE4403_ConsoleTextArea console;
	private SWE4403_ConsolePanel console;

	private SWE4403_ButtonHandler() {
		console = SWE4403_ConsolePanel.getInstance();
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

		if (frame == null && dialog == null) {
			throw new NullPointerException();
		}

		if (b instanceof SWE4403_EditEmployeeButton) {
			dialogToOpen = new SWE4403_EditEmployeeDialog(frame);
			console.log(new SWE4403_NormalLabel("Opened edit employee dialog"));
//			console.log("Opened edit employee dialog");
		} else if (b instanceof SWE4403_EditClientButton) {
			dialogToOpen = new SWE4403_EditClientDialog(frame);
			console.log(new SWE4403_NormalLabel("Opened edit client dialog"));
//			console.log("Opened edit client dialog");
		} else if (b instanceof SWE4403_AddEmployeeButton) {
			dialogToOpen = new SWE4403_AddEmployeeDialog(dialog);
			console.log(new SWE4403_NormalLabel("Opened add new Employee dialog"));
//			console.log("Opened add new Employee dialog");
		} else if (b instanceof SWE4403_RemoveEmployeeButton) {
			dialogToOpen = new SWE4403_RemoveEmployeeInputDialog(dialog);
			console.log(new SWE4403_NormalLabel("Opened employee name to remove input dialogbox"));
//			console.log("Opened employee name to remove input dialogbox");
		} else if (b instanceof SWE4403_AddClientButton) {
			dialogToOpen = new SWE4403_AddClientDialog(dialog);
			console.log(new SWE4403_NormalLabel("Opened add new client dialog"));
//			console.log("Opened add new client dialog");
		} else if (b instanceof SWE4403_RemoveClientButton) {
			dialogToOpen = new SWE4403_RemoveClientInputDialog(dialog);
			console.log(new SWE4403_NormalLabel("Opened client name to remove input dialogbox"));
//			console.log("Opened client name to remove input dialogbox");
		} else if (b instanceof SWE4403_OkButton) {
			switch (((SWE4403_OkButton) b).getType()) {
			case "addClient":
				console.log(
						new SWE4403_AcceptedLabel("This Ok Button came from " + dialog.getClass().getCanonicalName()));
//				console.log("This ok button came from the new client dialog");
				break;
			case "addEmployee":
				console.log(
						new SWE4403_AcceptedLabel("This ok button came from " + dialog.getClass().getCanonicalName()));
//				console.log("This ok button came from the new employee dialog");
				break;
			case "removeClient":
				console.log(
						new SWE4403_AcceptedLabel("This ok button came from  " + dialog.getClass().getCanonicalName()));
//				console.log("This ok button came from removing client dialog");
				break;
			case "removeEmployee":
				console.log(
						new SWE4403_AcceptedLabel("This ok button came from  " + dialog.getClass().getCanonicalName()));
//				console.log("This ok button came from removing client dialog");
				break;
			default:
				console.log(new SWE4403_ErrorLabel(
						"unknown source of ok button from  " + dialog.getClass().getCanonicalName()));
//				console.log("unknown source of ok button");
				break;
			}
		} else if (b instanceof SWE4403_CancelButton) {
			switch (((SWE4403_CancelButton) b).getType()) {
			case "addClient":
				console.log(new SWE4403_WarningLabel(
						"This cancel button came from  " + dialog.getClass().getCanonicalName()));
//				console.log("This cancel button came from the new client dialog");
				break;
			case "addEmployee":
				console.log(new SWE4403_WarningLabel(
						"This cancel button came from  " + dialog.getClass().getCanonicalName()));
//				console.log("This cancel button came from the new employee dialog");
				break;
			case "removeClient":
				console.log(new SWE4403_WarningLabel(
						"This cancel button came from  " + dialog.getClass().getCanonicalName()));
//				console.log("This cancel button came from the removing client dialog");
				break;
			case "removeEmployee":
				console.log(new SWE4403_WarningLabel(
						"This cancel button came from  " + dialog.getClass().getCanonicalName()));
//				console.log("This cancel button came from the removing employee dialog");
				break;
			default:
				console.log(new SWE4403_ErrorLabel("unknown source of cancel button"));
//				console.log("unknown source of cancel button");
				break;
			}
			// close the dialog if the cancel button is pressed
			dialog.dispose();
		} else if (b instanceof SWE4403_UndoButton) {
			console.log(new SWE4403_NormalLabel("Previous action has been undone."));
		} else {
			console.log(new SWE4403_ErrorLabel("Unknown source of button " + b.getClass().getCanonicalName()));
		}

		if (dialogToOpen != null)
			dialogToOpen.setVisible(true);

	}

}
