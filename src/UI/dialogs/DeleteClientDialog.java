package UI.dialogs;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;

import UI.textarea.ConsoleTA;
import src.src.com.company.Client;
import src.src.com.company.Company;
import src.src.com.company.SponsorshipMediator;

public class DeleteClientDialog extends AbstractDeleteDialog {

	private Company company = Company.getInstance();
	private ConsoleTA console = ConsoleTA.getInstance();
	private SponsorshipMediator sponsorshipMediator = SponsorshipMediator.getInstance();

	public DeleteClientDialog(JDialog parentDialog) {
		super("Remove Client");

		setLocationRelativeTo(parentDialog);
		var allClients = new ArrayList<>();

		var i = company.getClients().iterator();

		while (i.hasNext()) {
			Client client = (Client) i.next();
			allClients.add(client);

			for (var subClient : client.getGroup())
				allClients.add(subClient);
		}
		selectionCBBox.setModel(new DefaultComboBoxModel(allClients.toArray()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var c = (Client) selectionCBBox.getSelectedItem();

		if (c == null) {
			new ErrorDialog("Missing Client", "Please select an existing client to delete");
			return;
		}

		// remove from company / from group
		if (company.getClients().contains(c)) {
			company.removeClient(c);

			for (var subClient : c.getGroup()) {
				var sponsorship = sponsorshipMediator.getSponsorshipByClient(subClient);

				if (sponsorship != null) {
					sponsorshipMediator.discontinueSponsorship(sponsorship);
					console.log("The sponsor for this client has been discontinued");
				}
			}

		} else {
			for (var client : company.getClients()) {
				if (client.getGroup().contains(c)) {
					client.removeFromGroup(c);
					var sponsorship = sponsorshipMediator.getSponsorshipByClient(c);
					if (sponsorship != null) {
						sponsorshipMediator.discontinueSponsorship(sponsorship);
						console.log("The sponsor for this client has been discontinued");
					}
				}
			}
		}

		var sponsorship = sponsorshipMediator.getSponsorshipByClient(c);

		if (sponsorship != null) {
			sponsorshipMediator.discontinueSponsorship(sponsorship);
			console.log("The sponsor for this client has been discontinued");
		}
		console.log("A client has been removed: " + c.getName());
		dispose();
	}

}
