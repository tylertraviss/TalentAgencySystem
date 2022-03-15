package UI.dialogs;

import java.awt.event.ActionEvent;

import javax.swing.JDialog;

public class DeleteClientDialog extends AbstractDeleteDialog {

	public DeleteClientDialog(JDialog parentDialog) {
		super("Remove Client");
		setLocationRelativeTo(parentDialog);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// delete the client
	}

}
