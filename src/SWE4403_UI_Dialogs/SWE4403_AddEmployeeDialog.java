package SWE4403_UI_Dialogs;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import SWE4403_UI_TextFields.SWE4403_DateTextField;
import SWE4403_UI_TextFields.SWE4403_NormalTextField;
import SWE4403_UI_TextFields.SWE4403_WageTextField;
import SWE4403_UI_Utilities.SWE4403_ButtonHandler;

public class SWE4403_AddEmployeeDialog extends SWE4403_AddDialog {

	private JTextField jobTitleTF, wageTF, startDateTF, endDateTF;
	private JTextArea textArea;

	public SWE4403_AddEmployeeDialog(JDialog ownerDialog) {
		super(null, ownerDialog, "Add New Employee", "addEmployee");

		/*
		 * TEXTFIELD SETTINGS
		 */
		jobTitleTF = new SWE4403_NormalTextField("Job Title", null);
		jobTitleTF.setBounds(10, 11, 424, 48);
		wageTF = new SWE4403_WageTextField("Wage");
		wageTF.setBounds(10, 127, 424, 48);
		startDateTF = new SWE4403_DateTextField("Start Date", "dd/mm/yyyy");
		startDateTF.setBounds(10, 70, 200, 48);
		endDateTF = new SWE4403_DateTextField("End Date", "dd/mm/yyyy");
		endDateTF.setBounds(234, 70, 200, 48);

		contentPanel.add(jobTitleTF);
		contentPanel.add(wageTF);
		contentPanel.add(startDateTF);
		contentPanel.add(endDateTF);

		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setText(
				"JComboBox containing all the existing employees will be in here to specify the superior of this current employee");
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(10, 186, 424, 159);
		contentPanel.add(textArea);

		SWE4403_ButtonHandler.getInstance().setDialog(this);
	}

}
