package SWE4403_UI_Dialogs;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import SWE4403_UI_TextFields.SWE4403_DateTextField;
import SWE4403_UI_TextFields.SWE4403_NormalTextField;

public class SWE4403_AddClientDialog extends SWE4403_ConfirmationDialog {

	private JTextField experiencesTF, endDateTF, startDateTF, awardsTF;

	public SWE4403_AddClientDialog(JDialog ownerDialog) {
		super(null, ownerDialog, "Add New Client", "Client");

		experiencesTF = new SWE4403_NormalTextField("Experiences (Seperate them by [,])");
		experiencesTF.setBounds(10, 5, 424, 48);
		endDateTF = new SWE4403_DateTextField("End Date (dd/mm/yyyy)");
		endDateTF.setBounds(234, 64, 200, 48);
		startDateTF = new SWE4403_DateTextField("Start Date (dd/mm/yyyy)");
		startDateTF.setBounds(10, 64, 200, 48);
		awardsTF = new SWE4403_NormalTextField("Awards (Seperate them by [,])");
		awardsTF.setBounds(10, 123, 424, 48);

		/*
		 * TEXTFIELD SETTINGS
		 */
		contentPanel.add(experiencesTF);
		contentPanel.add(endDateTF);
		contentPanel.add(startDateTF);
		contentPanel.add(awardsTF);

		/*
		 * ## Remove this text area later on
		 */
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 182, 424, 159);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setText(
				"A ScrollPane and check boxes of all the existing clients will be listed here so that they can be added"
						+ "later on to the clientList of this current client (in the groups)");
		contentPanel.add(textArea);

	}
}
