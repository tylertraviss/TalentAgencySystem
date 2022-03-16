package UI.dialogs;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

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

		var allEmployees = new ArrayList<>();

		var i = company.getEmployees().iterator();

		while (i.hasNext()) {
			Employee employee = (Employee) i.next();
			allEmployees.add(employee);

			for (var subClient : employee.getSubordinates())
				allEmployees.add(subClient);
		}

		selectionCBBox.setModel(new DefaultComboBoxModel(allEmployees.toArray()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var emp = (Employee) selectionCBBox.getSelectedItem();

		if (emp == null) {
			new ErrorDialog("Missing Employee", "Please select an existing employee to delete");
			return;
		}

		if (company.getEmployees().contains(emp)) {
			company.removeEmployee(emp);
		} else {
			for (var employee : company.getEmployees()) {
				if (employee.getSubordinates().contains(emp)) {
					employee.removeSubordinate(emp);
				}
			}
		}

		console.log("An employee has been removed : " + emp.getName());

	}

}
