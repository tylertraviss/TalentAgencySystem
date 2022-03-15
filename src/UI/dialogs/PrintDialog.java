package UI.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import UI.textarea.ConsoleTA;
import src.src.com.company.Company;

public class PrintDialog extends AbstractEditDialog {

	public PrintDialog(JFrame parentFrame) {
		super("Print Company Stats", null, parentFrame);

		addButton.setText("To TextFile");
		removeButton.setText("To Console");
		setLocationRelativeTo(parentFrame);

		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				var company = Company.getInstance();

				if (company.getClients().size() == 0)
					ConsoleTA.getInstance().log("No Clients Yet");
				else
					for (var client : company.getClients())
						ConsoleTA.getInstance().log(client.toConsole());

				dispose();
			}

		});
	}

}
