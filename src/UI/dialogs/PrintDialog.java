package UI.dialogs;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import UI.textarea.ConsoleTA;
import src.company.Company;
import src.company.SponsorshipMediator;
import src.company.TextFileAudit;

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
				var textFileAudit = new TextFileAudit();
				try {
					textFileAudit.writeInformationToTextFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				var f = new File("GeneratedAudit.txt");
				var desktop = Desktop.getDesktop();
				if (!f.exists()) {
					new ErrorDialog("There was an error while generating the audit file.", "Error Opening Audit File");
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
				var sponsorships = sponsorshipMediator.getSponsorships();

				console.log("Client Count :  " + company.getNumberOfClients());
				console.log("Employee Count:  " + company.getNumberOfEmployees());
				console.log("Sponsorship Count:  " + sponsorships.size());

				console.log(SEPERATOR);

				console.log("CLIENT LIST");

				if (company.getAllClients().size() == 0)
					console.log("No Clients Yet");
				else
					for (var client :  company.getClients())
						console.log(client.getStringToPrintToConsole());

				console.log(SEPERATOR);

				console.log("EMPLOYEE LIST");

				if (company.getEmployees().size() == 0)
					console.log("No Employees Yet");
				else
					for (var emp :  company.getEmployees())
						console.log(emp.getStringToPrintToConsole());

				console.log(SEPERATOR);

				console.log("SPONSOR LIST");

				if (sponsorshipMediator.getSponsorships().size() == 0)
					console.log("No Sponsors Yet");
				else
					for (var sp :  sponsorshipMediator.getSponsorships())
						console.log(sp.getStringToPrintToConsole());

				console.log(SEPERATOR);
				dispose();
			}

		});
	}

}
