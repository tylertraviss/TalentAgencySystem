package SWE4403_UI_Dialogs;

import javax.swing.JDialog;
import javax.swing.JTextField;

import SWE4403_UI_TextFields.SWE4403_NormalTextField;

public class SWE4403_RemoveEmployeeInputDialog extends SWE4403_InputDialog {

	private JTextField employeeNameTF;

	public SWE4403_RemoveEmployeeInputDialog(JDialog ownerDialog) {
		super(null, ownerDialog, "Remove Employee", "removeEmployee");
		employeeNameTF = new SWE4403_NormalTextField("Enter Employee Name", null);

		/*
		 * Label Settings
		 */
		questionLabel.setString("Please enter the employee's name to remove");

		/*
		 * TextField Settings
		 */
		contentPanel.add(employeeNameTF);
		employeeNameTF.setBounds(10, 121, 274, 48);

	}

}
