package SWE4403_UI;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SWE4403_EditEmployeeDialog extends SWE4403_JDialog {

	private JButton addEmployeeButton, removeEmployeeButton;

	/**
	 * Create the dialog.
	 */
	public SWE4403_EditEmployeeDialog(JFrame owner) {
		super(null, owner, "Edit Employee");

		/*
		 * DIALOG LABEL SETTINGS
		 */
		dialogLabel.setString("[EDIT EMPLOYEES] <br>Please make a selection");

		/*
		 * DIALOG BUTTONS SETTINGS
		 */
		addEmployeeButton = new SWE4403_AddEmployeeButton("Add Employee");
		addEmployeeButton.setBounds(10, 198, 130, 40);
		removeEmployeeButton = new SWE4403_RemoveClientButton("Remove Employee");
		removeEmployeeButton.setBounds(294, 198, 130, 40);

		contentPanel.add(addEmployeeButton);
		contentPanel.add(removeEmployeeButton);
	}

}
