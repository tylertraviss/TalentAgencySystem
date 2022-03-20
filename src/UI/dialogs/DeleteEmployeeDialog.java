package UI.dialogs;

import java.awt.event.ActionEvent;

import javax.swing.JDialog;

import src.company.Employee;

public class DeleteEmployeeDialog extends AbstractDeleteDialog {

	public DeleteEmployeeDialog(JDialog parentDialog) {
		super("Remove Employee");
		setLocationRelativeTo(parentDialog);

		var employeeList = company.getEmployees();

		setSelectionCBBox(employeeList);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var emp = (Employee) selectionCBBox.getSelectedItem();

		if (emp == null) {
			new ErrorDialog("Missing Employee", "Please select an existing employee to delete");
			return;
		}

		company.removeEmployee(emp);
		console.log("An employee has been removed : " + emp.getName());
		dispose();

	}

}
