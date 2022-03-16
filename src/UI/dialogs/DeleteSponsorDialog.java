package UI.dialogs;

import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;

import UI.textarea.ConsoleTA;
import src.src.com.company.Sponsorship;
import src.src.com.company.SponsorshipMediator;

public class DeleteSponsorDialog extends AbstractDeleteDialog {

	private SponsorshipMediator sponsorshipMediator = SponsorshipMediator.getInstance();
	private ConsoleTA console = ConsoleTA.getInstance();

	public DeleteSponsorDialog(JDialog parentDialog) {
		super("Delete Sponsors");

		setLocationRelativeTo(parentDialog);

		selectionCBBox.setModel(new DefaultComboBoxModel(sponsorshipMediator.getSponsorships().toArray()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var s = (Sponsorship) selectionCBBox.getSelectedItem();

		if (s == null) {
			new ErrorDialog("Missing Sponsor", "Please select an existing sponsor to delete");
			return;
		}

		sponsorshipMediator.discontinueSponsorship(s);

		console.log("A sponsorship has been discontinued: " + s.getSponsor().getSponsorName());
		dispose();

	}

}
