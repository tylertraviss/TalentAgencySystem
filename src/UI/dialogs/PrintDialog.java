package UI.dialogs;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import UI.textarea.ConsoleTA;
import src.src.com.company.Company;
import src.src.com.company.SponsorshipMediator;
import src.src.com.company.TextFileAudit;

public class PrintDialog extends AbstractEditDialog {

	private static final String SEPERATOR = System.lineSeparator() + "---------------------------------------"
			+ System.lineSeparator();

	public PrintDialog(JFrame parentFrame) {
		super("Print Company Stats", null, parentFrame);

		addButton.setText("To TextFile");
		removeButton.setText("To Console");
		setLocationRelativeTo(parentFrame);

		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new TextFileAudit();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				File f = new File("GeneratedAudit.txt");
				Desktop desktop = Desktop.getDesktop();
				if (!f.exists()) {
					// open the error dialog and show that the file does not exist
					return;
				}
				try {
					desktop.open(f);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});

		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				var company = Company.getInstance();
				var console = ConsoleTA.getInstance();
				var sponsorshipMediator = SponsorshipMediator.getInstance();

				console.log(SEPERATOR);

				console.log("\t\tCLIENT LIST");

				if (company.getClients().size() == 0)
					console.log("No Clients Yet");
				else
					for (var client : company.getClients())
						console.log(client.toConsole());

				console.log(SEPERATOR);

				console.log("\t\tEMPLOYEE LIST");

				if (company.getEmployees().size() == 0)
					console.log("No Employees Yet");
				else
					for (var emp : company.getEmployees())
						console.log(emp.toConsole());

				console.log(SEPERATOR);

				console.log("\t\tSPONSOR LIST");

				if (sponsorshipMediator.getSponsorships().size() == 0)
					console.log("No Sponsors Yet");
				else
					for (var sp : sponsorshipMediator.getSponsorships())
						console.log(sp.toConsole());

				console.log(SEPERATOR);
				dispose();
			}

		});
	}

}
