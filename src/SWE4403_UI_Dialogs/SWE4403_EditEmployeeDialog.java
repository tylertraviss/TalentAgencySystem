package SWE4403_UI_Dialogs;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import SWE4403_UI_Buttons.SWE4403_AddEmployeeButton;
import SWE4403_UI_Buttons.SWE4403_RemoveEmployeeButton;

public class SWE4403_EditEmployeeDialog extends SWE4403_EditDialog {

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
		removeEmployeeButton = new SWE4403_RemoveEmployeeButton("Remove Employee");

		/*
		 * BUTTON PANEL BUTTONS
		 */
		JPanel panel = new JPanel();
		panel.setBounds(10, 198, 414, 52);
		contentPanel.add(panel);

		panel.add(addEmployeeButton);
		panel.add(removeEmployeeButton);
	}

}
