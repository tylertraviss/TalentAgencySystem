package UI.dialogs;

import java.awt.event.ActionEvent;

import javax.swing.JDialog;

import src.company.Sponsorship;
import src.company.SponsorshipMediator;

public class DeleteSponsorDialog extends AbstractDeleteDialog {

	private SponsorshipMediator spMediator = SponsorshipMediator.getInstance();

	public DeleteSponsorDialog(JDialog parentDialog) {
		super("Delete Sponsors");
		setLocationRelativeTo(parentDialog);

		var sponsorships = spMediator.getSponsorships();

		setSelectionCBBox(sponsorships);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var s = (Sponsorship) selectionCBBox.getSelectedItem();

		if (s == null) {
			new ErrorDialog("Missing Sponsor", "Please select an existing sponsor to delete");
			return;
		}

		spMediator.discontinueSponsorship(s);

		var sponsor = s.getSponsor();

		console.log("A sponsorship has been discontinued: " + sponsor.getSponsorName());
		dispose();

	}

}
