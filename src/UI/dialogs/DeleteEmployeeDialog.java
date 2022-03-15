package UI.dialogs;

import java.awt.event.ActionEvent;

import javax.swing.JDialog;

public class DeleteEmployeeDialog extends AbstractDeleteDialog {

	public DeleteEmployeeDialog(JDialog parentDialog) {
		super("Remove Employee");
		setLocationRelativeTo(parentDialog);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// delete the given employee
	}

}
