package UI.dialogs;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import UI.buttons.Button_Skeleton;
import UI.fonts.BoldFont;
import UI.panels.ButtonPanel_Skeleton;
import UI.textfields.TextField_Skeleton;
import src.src.com.company.Company;

public class AddEmployeeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JTextField name, age, gender, nationality, jobTitle, wage, startDate, endDate;
	private JButton confirm;
	private JPanel buttonPanel;
	private JLabel titleLabel;
	private JComboBox superiorCBBox;

	/**
	 * Create the dialog.
	 */
	public AddEmployeeDialog(JDialog parentDialog) {
		setModal(true);
		setLocationRelativeTo(parentDialog);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 465);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setTitle("Add Employee");

		/*
		 * JLabel
		 */
		titleLabel = new JLabel("New Employee");
		titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(BoldFont.getInstance());
		titleLabel.setBounds(10, 11, 414, 50);
		contentPanel.add(titleLabel);

		/*
		 * Panel
		 */
		buttonPanel = new ButtonPanel_Skeleton();
		buttonPanel.setBounds(10, 362, 414, 50);
		contentPanel.add(buttonPanel);

		/*
		 * Buttons
		 */
		confirm = new Button_Skeleton("Confirm");
		buttonPanel.add(confirm);

		/*
		 * TextField
		 */
		name = new TextField_Skeleton("Name", "Example");
		name.setBounds(10, 72, 414, 50);
		age = new TextField_Skeleton("Age", "Example");
		age.setBounds(10, 133, 120, 50);
		gender = new TextField_Skeleton("Gender", "Example");
		gender.setBounds(155, 133, 120, 50);
		nationality = new TextField_Skeleton("Nationality", "Example");
		nationality.setBounds(10, 194, 200, 50);
		jobTitle = new TextField_Skeleton("Job Title", "Example");
		jobTitle.setBounds(224, 194, 200, 50);
		wage = new TextField_Skeleton("Wage", "Example");
		wage.setBounds(304, 133, 120, 50);
		startDate = new TextField_Skeleton("Start Date", "dd/mm/yyyy");
		startDate.setBounds(10, 255, 200, 50);
		endDate = new TextField_Skeleton("End Date", "dd/mm/yyyy");
		endDate.setBounds(224, 255, 200, 50);

		contentPanel.add(name);
		contentPanel.add(age);
		contentPanel.add(gender);
		contentPanel.add(nationality);
		contentPanel.add(jobTitle);
		contentPanel.add(wage);
		contentPanel.add(startDate);
		contentPanel.add(endDate);

		/*
		 * ComboBox
		 */
		superiorCBBox = new JComboBox(Company.getInstance().getEmployees().toArray());
		superiorCBBox.setBounds(10, 316, 414, 35);
		contentPanel.add(superiorCBBox);

	}
}
