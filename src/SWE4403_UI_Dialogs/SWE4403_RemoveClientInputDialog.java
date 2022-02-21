package SWE4403_UI_Dialogs;

import javax.swing.JDialog;
import javax.swing.JTextField;

import SWE4403_UI_TextFields.SWE4403_NormalTextField;

public class SWE4403_RemoveClientInputDialog extends SWE4403_InputDialog {

	private JTextField clientNameTF;

	public SWE4403_RemoveClientInputDialog(JDialog ownerDialog) {
		super(null, ownerDialog, "Remove Client", "removeClient");
		clientNameTF = new SWE4403_NormalTextField("Enter Client Name", null);

		/*
		 * Label Settings
		 */
		questionLabel.setString("Please enter the client's name to remove");

		/*
		 * TextField Settings
		 */
		contentPanel.add(clientNameTF);
		clientNameTF.setBounds(10, 121, 274, 48);

	}

}
