package UI.dialogs;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

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
				.setModel(new DefaultComboBoxModel(getListOfSubordinates(company.getEmployees().get(0)).toArray()));
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
			removeSubordinate(company.getEmployees().get(0), emp);
		}

		console.log("An employee has been removed : " + emp.getName());

		dispose();

	}

	private boolean removeSubordinate(Employee emp, Employee toRemove) {
		if (emp.getSubordinates().contains(toRemove)) {
			emp.removeSubordinate(toRemove);
			return true;
		}

		for (var sub : emp.getSubordinates()) {
			var removed = removeSubordinate(sub, toRemove);

			if (removed) {
				return true;
			}
		}

		return false;

	}

	private List<Employee> getListOfSubordinates(Employee emp) {
		if (emp == null)
			return null;

		List<Employee> subList = new ArrayList<>();

		subList.add(emp);

		for (var sub : emp.getSubordinates()) {
			var newSubList = getListOfSubordinates(sub);
			subList.addAll(newSubList);
		}

		return subList;
	}

}
