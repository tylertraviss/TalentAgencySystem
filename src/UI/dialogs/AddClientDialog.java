package UI.dialogs;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import UI.fonts.PlaceholderFont;
import UI.panels.ButtonPanel_Skeleton;
import UI.panels.Header;
import UI.textfields.TextField_Skeleton;
import UI.utilities.ClientType;
import src.src.com.company.Actor;
import src.src.com.company.Athlete;
import src.src.com.company.Award;
import src.src.com.company.Client;
import src.src.com.company.Company;
import src.src.com.company.Experience;
import src.src.com.company.Instrument;
import src.src.com.company.Musician;

public class AddClientDialog extends JDialog {

	private Company company = Company.getInstance();

	private JTextField name, age, gender, nationality, experiences, commission, awards, revenueGenerated;
	private JPanel buttonPanel, clientTypePanel, header;
	private JButton confirm;
	private JComboBox clientTypeCBBox, groupCBBox;
	private JLabel titleLabel;

	public AddClientDialog(JDialog parentDialog) {
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		getContentPane().setLayout(null);
		getRootPane().setBorder(WindowBorder.getInstance());
		setBounds(10, 10, 435, 800);
		setUndecorated(true);
		setTitle("Add Client");

		/*
		 * TextFields
		 */
		name = new TextField_Skeleton("Name", "Enter name here...");
		name.setBounds(10, 92, 414, 50);
		age = new TextField_Skeleton("Age", "Example...");
		age.setBounds(10, 153, 120, 50);
		gender = new TextField_Skeleton("Gender", "Example...");
		gender.setBounds(150, 153, 120, 50);
		commission = new TextField_Skeleton("Commission", "Example..");
		commission.setBounds(304, 153, 120, 50);
		awards = new TextField_Skeleton("Awards (Sepearate each award by [,]", "Award 1, Award 2, Award...");
		awards.setBounds(10, 275, 414, 50);
		revenueGenerated = new TextField_Skeleton("Revenue Generated", "Example...");
		revenueGenerated.setBounds(10, 214, 200, 50);
		nationality = new TextField_Skeleton("Nationality", "Example...");
		nationality.setBounds(223, 214, 200, 50);

		getContentPane().add(name);
		getContentPane().add(age);
		getContentPane().add(gender);
		getContentPane().add(commission);
		getContentPane().add(awards);
		getContentPane().add(revenueGenerated);
		getContentPane().add(nationality);

		/*
		 * JPanel
		 */
		buttonPanel = new ButtonPanel_Skeleton();
		buttonPanel.setBounds(10, 704, 414, 50);
		getContentPane().add(buttonPanel);

		clientTypePanel = new JPanel();
		clientTypePanel.setOpaque(false);
		clientTypePanel.setBounds(10, 523, 414, 170);
		clientTypePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		getContentPane().add(clientTypePanel);

		header = new Header(this, "New Client", null, false);
		getContentPane().add(header);

		/*
		 * JButton
		 */
		confirm = new Button_Skeleton("Confirm");
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nameIn, genderIn, nationalityIn, experiencesIn, awardsIn;
				Client group, toAdd = null;
				List<Experience> experienceList = null;
				List<Award> awardList = null;
				List<String> clientTypeInList = null;
				int ageIn;
				double commissionIn, revenueGeneratedIn;
				Instrument instrumentIn;

				System.out.println(validateAllFields());
				if (validateAllFields()) {
					nameIn = name.getText();
					genderIn = gender.getText();
					nationalityIn = nationality.getText();
					if (!(experiences.getFont() instanceof PlaceholderFont)) {
						experiencesIn = experiences.getText();
						experienceList = strExpToList(experiencesIn);
					}
					if (!(awards.getFont() instanceof PlaceholderFont)) {
						awardsIn = awards.getText();
						awardList = strAwardToList(awardsIn);
					}
					group = (Client) groupCBBox.getSelectedItem();
					ageIn = Integer.parseInt(age.getText());
					commissionIn = Double.parseDouble(commission.getText());
					revenueGeneratedIn = Double.parseDouble(revenueGenerated.getText());
					group = (Client) groupCBBox.getSelectedItem();
					clientTypeInList = getClientTypeInfo();

					switch ((ClientType) clientTypeCBBox.getSelectedItem()) {
						case ACTOR:
							toAdd = new Actor(nameIn, ageIn, genderIn, nationalityIn, experienceList, commissionIn,
									awardList,
									revenueGeneratedIn, clientTypeInList.get(0));
							break;
						case MUSICIAN:
							instrumentIn = new Instrument(clientTypeInList.get(2));
							toAdd = new Musician(nameIn, ageIn, genderIn, nationalityIn, experienceList, commissionIn,
									awardList, clientTypeInList.get(0), clientTypeInList.get(1), instrumentIn,
									revenueGeneratedIn);
							break;
						case ATHLETE:
							if (!validateDoubles(clientTypeInList.get(0))) {
								// SHOW ERROR MSG
							}
							if (!validateDoubles(clientTypeInList.get(1))) {
								// SHOW ERROR MSG
							}

							toAdd = new Athlete(nameIn, ageIn, genderIn, nationalityIn, experienceList, commissionIn,
									awardList,
									Double.parseDouble(clientTypeInList.get(0)),
									Double.parseDouble(clientTypeInList.get(1)), clientTypeInList.get(2),
									revenueGeneratedIn);
							break;
					}

					company.addClient(toAdd);
					dispose();
				}

			}

		});

		buttonPanel.add(confirm);

		/*
		 * ComboBox
		 */
		groupCBBox = new JComboBox(Company.getInstance().getClients().toArray());
		groupCBBox.setBounds(10, 397, 414, 50);
		groupCBBox.setBorder(new CustomTitledBorder("Existing Groups"));
		getContentPane().add(groupCBBox);

		clientTypeCBBox = new JComboBox(ClientType.values());
		clientTypeCBBox.setBounds(10, 462, 414, 50);
		clientTypeCBBox.setBorder(new CustomTitledBorder("Client Type"));
		clientTypeCBBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				var selection = clientTypeCBBox.getSelectedItem();
				updateClientTypePanel((ClientType) selection);
			}

		});
		getContentPane().add(clientTypeCBBox);

		experiences = new TextField_Skeleton("Experiences (Sepearate each experience by [,]", "Exp 1, Exp 2, Exp...");
		experiences.setBounds(10, 336, 414, 50);
		getContentPane().add(experiences);

		titleLabel = new JLabel("New Client");
		titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Consolas", Font.BOLD, 12));
		titleLabel.setBounds(10, 46, 414, 35);
		getContentPane().add(titleLabel);

		// by default set actor
		updateClientTypePanel(ClientType.ACTOR);

		setLocationRelativeTo(parentDialog);

	}

	private void updateClientTypePanel(ClientType type) {
		// each update clears the panel
		clientTypePanel.removeAll();

		Dimension size = new Dimension(400, 50);

		switch (type) {
			case ACTOR:
				var actorType = new TextField_Skeleton("Actor Type", "Enter actor type here...");
				actorType.setPreferredSize(size);
				clientTypePanel.add(actorType);
				break;
			case MUSICIAN:
				var stageName = new TextField_Skeleton("Stage name", "Enter stage name here...");
				stageName.setPreferredSize(size);
				var genre = new TextField_Skeleton("Genre", "Enter genre here...");
				genre.setPreferredSize(size);
				var instrument = new TextField_Skeleton("Instrument", "Enter instrument here...");
				instrument.setPreferredSize(size);
				clientTypePanel.add(stageName);
				clientTypePanel.add(genre);
				clientTypePanel.add(instrument);
				break;
			case ATHLETE:
				var height = new TextField_Skeleton("Height", "Enter height here...");
				height.setPreferredSize(size);
				var weight = new TextField_Skeleton("Weight", "Enter weight here...");
				weight.setPreferredSize(size);
				var sportType = new TextField_Skeleton("Sport Type", "Enter type here...");
				sportType.setPreferredSize(size);
				clientTypePanel.add(height);
				clientTypePanel.add(weight);
				clientTypePanel.add(sportType);
				break;
		}

		clientTypePanel.revalidate();
		clientTypePanel.repaint();

	}

	private boolean clientTypeFilled() {
		boolean toReturn = true;

		if (clientTypePanel.getComponents().length == 1)
			toReturn &= !(((JTextField) clientTypePanel.getComponent(0)).getText().isBlank())
					& !(clientTypePanel.getComponent(0).getFont() instanceof PlaceholderFont);

		else
			for (var component : clientTypePanel.getComponents()) {
				if (((JTextField) component).getText().isBlank())
					toReturn &= false;
				if (component.getFont() instanceof PlaceholderFont)
					toReturn &= false;
			}
		return toReturn;
	}

	private List<String> getClientTypeInfo() {
		List<String> toReturn = new ArrayList<>();

		for (var component : clientTypePanel.getComponents()) {
			toReturn.add(((JTextField) component).getText());
		}

		return toReturn;
	}

	private boolean validateDoubles(String text) {
		try {
			Double.parseDouble(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean validateIntegers(String text) {
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean isFilled(JTextField field) {
		return !((field.getFont() instanceof PlaceholderFont) | field.getText().isBlank());
	}

	private boolean validateAllFields() {
		// does not check if awards / experience / groups are filled
		boolean toReturn = true;

		toReturn &= isFilled(name);
		toReturn &= isFilled(age);
		toReturn &= validateIntegers(age.getText());
		toReturn &= isFilled(gender);
		toReturn &= isFilled(nationality);
		toReturn &= isFilled(commission);
		toReturn &= validateDoubles(commission.getText());
		toReturn &= isFilled(revenueGenerated);
		toReturn &= validateDoubles(revenueGenerated.getText());
		toReturn &= clientTypeFilled();

		return toReturn;
	}

	// private Date strToDate(String date) {
	// String temp[] = date.split("/");
	// Date toReturn = null;

	// if (temp.length != 3)
	// return null;

	// for (var i : temp)
	// if (!validateIntegers(i))
	// return null;

	// toReturn = new Date(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]),
	// Integer.parseInt(temp[2]));
	// return toReturn;
	// }

	private List<Experience> strExpToList(String list) {
		List<Experience> toReturn = new ArrayList<>();
		String temp[] = list.split(",");
		for (var exp : temp)
			toReturn.add(new Experience(exp.strip()));

		return toReturn;
	}

	private List<Award> strAwardToList(String list) {
		List<Award> toReturn = new ArrayList<>();
		String temp[] = list.split(",");
		for (var award : temp)
			toReturn.add(new Award(award.strip()));

		return toReturn;
	}

}
