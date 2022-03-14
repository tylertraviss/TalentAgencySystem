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

public class SWE4403_ButtonHandler {

	private static SWE4403_ButtonHandler instance = null;
	private static JFrame frame;
	private static JDialog dialog;
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
			console.log("Opened edit employee dialog", SWE4403_MessageType.NORMAL);
		} else if (b instanceof SWE4403_EditClientButton) {
			dialogToOpen = new SWE4403_EditClientDialog(frame);
			console.log("Opened edit client dialog", SWE4403_MessageType.NORMAL);
		} else if (b instanceof SWE4403_AddEmployeeButton) {
			dialogToOpen = new SWE4403_AddEmployeeDialog(dialog);
			console.log("Opened add new Employee dialog", SWE4403_MessageType.NORMAL);
		} else if (b instanceof SWE4403_RemoveEmployeeButton) {
			dialogToOpen = new SWE4403_RemoveEmployeeInputDialog(dialog);
			console.log("Opened employee name to remove input dialogbox", SWE4403_MessageType.NORMAL);
		} else if (b instanceof SWE4403_AddClientButton) {
			dialogToOpen = new SWE4403_AddClientDialog(dialog);
			console.log("Opened add new client dialog", SWE4403_MessageType.NORMAL);
		} else if (b instanceof SWE4403_RemoveClientButton) {
			dialogToOpen = new SWE4403_RemoveClientInputDialog(dialog);
			console.log("Opened client name to remove input dialogbox", SWE4403_MessageType.NORMAL);
		} else if (b instanceof SWE4403_UndoButton) {
			console.log("Previous action has been undone.", SWE4403_MessageType.NORMAL);
		} else if (b instanceof SWE4403_OkButton) {
			switch (((SWE4403_OkButton) b).getType()) {
			case "addClient":
			case "addEmployee":
			case "removeClient":
			case "removeEmployee":
				console.log("This ok button came from  " + dialog.getClass().getCanonicalName(),
						SWE4403_MessageType.WARNING);
				break;
			default:
				console.log("unknown source of ok button from  " + dialog.getClass().getCanonicalName(),
						SWE4403_MessageType.ERROR);
				break;
			}
		} else if (b instanceof SWE4403_CancelButton) {
			switch (((SWE4403_CancelButton) b).getType()) {
			case "addClient":
			case "addEmployee":
			case "removeClient":
			case "removeEmployee":
				console.log("This cancel button came from  " + dialog.getClass().getCanonicalName(),
						SWE4403_MessageType.WARNING);
				break;
			default:
				console.log("unknown source of cancel button", SWE4403_MessageType.ERROR);
				break;
			}
			dialog.dispose();
		} else {
			console.log("Unknown source of button " + b.getClass().getCanonicalName(), SWE4403_MessageType.ERROR);
		}

		if (dialogToOpen != null)
			dialogToOpen.setVisible(true);

	}

}
