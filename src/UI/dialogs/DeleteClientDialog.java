package UI.dialogs;

import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;

import UI.textarea.ConsoleTA;
import src.src.com.company.Client;
import src.src.com.company.Company;

public class DeleteClientDialog extends AbstractDeleteDialog {

	private Company company = Company.getInstance();
	private ConsoleTA console = ConsoleTA.getInstance();

	public DeleteClientDialog(JDialog parentDialog) {
		super("Remove Client");

		setLocationRelativeTo(parentDialog);

		selectionCBBox.setModel(new DefaultComboBoxModel(company.getClients().toArray()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var c = (Client) selectionCBBox.getSelectedItem();

		if (c == null) {
			new ErrorDialog("Missing Client", "Please select an existing client to delete");
			return;
		}

		// remove from company / from group
		company.removeClient(c);
		console.log("A client has been removed: " + c.getName());

		dispose();
	}

}
