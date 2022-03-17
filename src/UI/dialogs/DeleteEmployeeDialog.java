package UI.dialogs;

import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;

import UI.textarea.ConsoleTA;
import src.src.com.company.Company;
import src.src.com.company.Employee;

public class DeleteEmployeeDialog extends AbstractDeleteDialog {

	private Company company = Company.getInstance();
	private ConsoleTA console = ConsoleTA.getInstance();

	public DeleteEmployeeDialog(JDialog parentDialog) {
		super("Remove Employee");
		setLocationRelativeTo(parentDialog);

		selectionCBBox
				.setModel(new DefaultComboBoxModel((company.getEmployees().toArray())));
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
