package SWE4403_UI_Dialogs;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import SWE4403_UI_Buttons.SWE4403_AddClientButton;
import SWE4403_UI_Buttons.SWE4403_RemoveClientButton;

public class SWE4403_EditClientDialog extends SWE4403_EditDialog {

	private JButton addClientButton, removeClientButton;

	/**
	 * Create the dialog.
	 */
	public SWE4403_EditClientDialog(JFrame owner) {
		super(null, owner, "Edit Clients");

		/*
		 * DIALOG LABEL SETTINGS
		 */
		dialogLabel.setString("[EDIT CLIENTS] <br>Please make a selection");

		/*
		 * DIALOG BUTTONS SETTINGS
		 */
		addClientButton = new SWE4403_AddClientButton("Add Client");
		removeClientButton = new SWE4403_RemoveClientButton("Remove Client");

		/*
		 * Button panel settings
		 */
		JPanel panel = new JPanel();
		panel.setBounds(10, 198, 414, 52);
		contentPanel.add(panel);

		panel.add(addClientButton);
		panel.add(removeClientButton);
	}

}
