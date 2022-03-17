package UI.dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import UI.borders.CustomTitledBorder;
import UI.borders.WindowBorder;
import UI.buttons.Button_Skeleton;
import UI.fonts.BoldFont;
import UI.fonts.PlaceholderFont;
import UI.panels.ButtonPanel_Skeleton;
import UI.panels.Header;
import UI.textarea.ConsoleTA;
import UI.textfields.TextField_Skeleton;
import src.src.com.company.Company;
import src.src.com.company.Date;
import src.src.com.company.Employee;
import src.src.com.company.MementoCreator;
import src.src.com.company.MementoRestorer;

public class AddEmployeeDialog extends JDialog {

	private Company company = Company.getInstance();

	private final JPanel contentPanel = new JPanel();

	private JTextField name, age, gender, nationality, jobTitle, wage, startDate, endDate;
	private JButton confirm;
	private JPanel buttonPanel, header;
	private JLabel titleLabel;
	private JComboBox superiorCBBox;

	/**
	 * Create the dialog.
	 */
	public AddEmployeeDialog(JDialog parentDialog) {
		var console = ConsoleTA.getInstance();
		setModal(true);
		setUndecorated(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 440, 500);
		getContentPane().setLayout(new BorderLayout());
		getRootPane().setBorder(WindowBorder.getInstance());
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
		titleLabel.setBounds(10, 53, 414, 50);
		contentPanel.add(titleLabel);

		/*
		 * Panel
		 */
		buttonPanel = new ButtonPanel_Skeleton();
		buttonPanel.setBounds(10, 439, 414, 50);
		contentPanel.add(buttonPanel);

		header = new Header(this, "New Employee", null, false);
		contentPanel.add(header);

		/*
		 * Buttons
		 */
		confirm = new Button_Skeleton("Confirm");
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nameIn, genderIn, nationalityIn, jobTitleIn;
				Date startIn, endIn;
				Employee superiorIn;
				double wageIn;
				int ageIn;

				if (validateAllFields()) {
					MementoCreator mCreator = MementoCreator.getInstance();
					MementoRestorer mRestorer = MementoRestorer.getInstance();

					nameIn = name.getText();
					genderIn = gender.getText();
					nationalityIn = nationality.getText();
					jobTitleIn = jobTitle.getText();
					wageIn = Double.parseDouble(wage.getText());
					startIn = strToDate(startDate.getText());
					endIn = strToDate(endDate.getText());
					ageIn = Integer.parseInt(age.getText());

					var selectedItem = superiorCBBox.getSelectedItem().toString();
					if (selectedItem.equalsIgnoreCase("No Superior"))
						superiorIn = null;
					else
						superiorIn = (Employee) superiorCBBox.getSelectedItem();

					Employee employee = new Employee(nameIn, ageIn, genderIn, nationalityIn, jobTitleIn, wageIn,
							startIn,
							endIn, superiorIn);

					if (superiorIn != null)
						superiorIn.addSubordinate(employee);
					else
						company.addEmployee(employee);

					company.sortPeople();
					console.log("Added new employee: " + employee.getName());

					mCreator.setState(employee, null, null);
					mRestorer.addMementoToList(mCreator.createMementoWithSetState());

					dispose();
				} else
					new ErrorDialog("Error", "Please fill in all the fields.");
			}

		});
		buttonPanel.add(confirm);

		/*
		 * TextField
		 */
		name = new TextField_Skeleton("Name", "Example...");
		name.setBounds(10, 114, 414, 50);
		age = new TextField_Skeleton("Age", "Example...");
		age.setBounds(10, 175, 120, 50);
		gender = new TextField_Skeleton("Gender", "Example...");
		gender.setBounds(155, 175, 120, 50);
		nationality = new TextField_Skeleton("Nationality", "Example...");
		nationality.setBounds(10, 236, 200, 50);
		jobTitle = new TextField_Skeleton("Job Title", "Example...");
		jobTitle.setBounds(224, 236, 200, 50);
		wage = new TextField_Skeleton("Wage", "Example...");
		wage.setBounds(304, 175, 120, 50);
		startDate = new TextField_Skeleton("Start Date", "dd/mm/yyyy");
		startDate.setBounds(10, 297, 200, 50);
		endDate = new TextField_Skeleton("End Date", "dd/mm/yyyy");
		endDate.setBounds(224, 297, 200, 50);

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
		var allEmp = new ArrayList<>();

		for (var emp : company.getEmployees())
			allEmp.addAll(getListOfSubordinates(emp));

		superiorCBBox = new JComboBox(allEmp.toArray());
		superiorCBBox.addItem("No superior");
		superiorCBBox.setSelectedIndex(allEmp.size());
		superiorCBBox.setBorder(new CustomTitledBorder("Select Superior"));
		superiorCBBox.setBounds(10, 358, 414, 50);
		contentPanel.add(superiorCBBox);

		setLocationRelativeTo(parentDialog);

	}

	private List<Employee> getListOfSubordinates(Employee emp) {
		if (emp == null)
			return null;

		List<Employee> subList = new ArrayList<>();

		subList.add(emp);

		for (var sub : emp.getSubordinates()) {
			var newSubList = getListOfSubordinates(sub);
			subList.addAll(newSubList);
		}

		return subList;
	}

	private boolean validateInteger(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean validateDate(JTextField field) {

		String[] temp = field.getText().split("/");

		if (temp.length != 3)
			return false;

		for (var num : temp)
			if (!validateInteger(num))
				return false;

		return true;
	}

	private boolean validateDoubles(String num) {
		try {
			Double.parseDouble(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean isFilled(JTextField field) {
		return !((field.getFont() instanceof PlaceholderFont) | field.getText().isBlank());
	}

	private boolean validateAllFields() {
		boolean toReturn = true;

		toReturn &= isFilled(name);
		toReturn &= validateInteger(age.getText());
		toReturn &= isFilled(gender);
		toReturn &= validateDoubles(wage.getText());
		toReturn &= isFilled(nationality);
		toReturn &= isFilled(jobTitle);
		toReturn &= isFilled(startDate);
		toReturn &= validateDate(startDate);
		toReturn &= isFilled(endDate);
		toReturn &= validateDate(endDate);

		return toReturn;
	}

	private Date strToDate(String strDate) {
		String temp[] = strDate.split("/");
		var day = Integer.parseInt(temp[0]);
		var month = Integer.parseInt(temp[1]);
		var year = Integer.parseInt(temp[2]);

		return new Date(day, month, year);
	}
}
