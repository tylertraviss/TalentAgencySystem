package UI.dialogs;

import java.awt.event.ActionEvent;

import javax.swing.JDialog;

public class DeleteSponsorDialog extends AbstractDeleteDialog {

	public DeleteSponsorDialog(JDialog parentDialog) {
		super("Delete Sponsors");
		setLocationRelativeTo(parentDialog);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// remove Sponsor from here
	}

}
