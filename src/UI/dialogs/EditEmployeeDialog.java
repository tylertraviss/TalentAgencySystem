package UI.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class EditEmployeeDialog extends AbstractEditDialog {

	public EditEmployeeDialog(JFrame parentFrame) {
		super("Add / Remove Employee", "Employee", parentFrame);
		setLocationRelativeTo(parentFrame);

		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog addEmployeeDialog = new AddEmployeeDialog(self);
				addEmployeeDialog.setVisible(true);
			}

		});

		removeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog deleteEmployeeDialog = new DeleteEmployeeDialog(self);
				deleteEmployeeDialog.setVisible(true);
			}

		});
	}

}
