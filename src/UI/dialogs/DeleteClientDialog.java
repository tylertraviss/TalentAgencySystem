package UI.dialogs;

import java.awt.event.ActionEvent;

import javax.swing.JDialog;

import src.company.Client;
import src.company.Company;

public class DeleteClientDialog extends AbstractDeleteDialog {

	public DeleteClientDialog(JDialog parentDialog) {
		super("Remove Client");

		var company = Company.getInstance();
		var clientList = company.getAllClients();

		setLocationRelativeTo(parentDialog);

		setSelectionCBBox(clientList);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var c = (Client) selectionCBBox.getSelectedItem();

		if (c == null) {
			// if there is no clienty selected display an error msg
			new ErrorDialog("Missing Client", "Please select an existing client to delete");
			return;
		}

		// remove from company / from group
		company.removeClient(c);
		console.log("A client has been removed: " + c.getName());

		dispose();
	}

}
