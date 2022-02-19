package SWE4403_UI;

import javax.swing.JButton;

public class SWE4403_EditClientDialog extends SWE4403_JDialog {

	private JButton addClientButton, removeClientButton;

	/**
	 * Create the dialog.
	 */
	public SWE4403_EditClientDialog() {
		super("Edit Clients");

		/*
		 * DIALOG LABEL SETTINGS
		 */
		dialogLabel.setString("[EDIT CLIENTS] <br>Please make a selection");

		/*
		 * DIALOG BUTTONS SETTINGS
		 */
		addClientButton = new SWE4403_AddClientButton("Add Client");
		addClientButton.setBounds(10, 198, 130, 40);
		removeClientButton = new SWE4403_RemoveClientButton("Remove Client");
		removeClientButton.setBounds(294, 198, 130, 40);

		/*
		 * Adding components to the dialog box
		 */
		contentPanel.add(addClientButton);
		contentPanel.add(removeClientButton);
	}

}
