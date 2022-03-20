package UI.dialogs;

import java.awt.Dimension;
import java.awt.FlowLayout;
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
import UI.utilities.ClientType;
import src.company.Actor;
import src.company.Athlete;
import src.company.Award;
import src.company.Client;
import src.company.Company;
import src.company.Experience;
import src.company.Instrument;
import src.company.MementoCreator;
import src.company.MementoRestorer;
import src.company.Musician;

public class AddClientDialog extends JDialog {

	private JTextField name, age, gender, nationality, experiences, commission, awards, revenueGenerated;
	private JPanel buttonPanel, clientTypePanel, header;
	private JButton confirm;
	private JComboBox clientTypeCBBox, groupCBBox;
	private JLabel titleLabel;

	public AddClientDialog(JDialog parentDialog) {
		var console = ConsoleTA.getInstance();
		var company = Company.getInstance();
		var windowBorder = WindowBorder.getInstance();
		var contentPane = getContentPane();
		var boldFont = BoldFont.getInstance();

		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		contentPane.setLayout(null);
		getRootPane().setBorder(windowBorder);
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

		contentPane.add(name);
		contentPane.add(age);
		contentPane.add(gender);
		contentPane.add(commission);
		contentPane.add(awards);
		contentPane.add(revenueGenerated);
		contentPane.add(nationality);

		/*
		 * JPanel
		 */
		buttonPanel = new ButtonPanel_Skeleton();
		buttonPanel.setBounds(10, 704, 414, 50);
		contentPane.add(buttonPanel);

		clientTypePanel = new JPanel();
		clientTypePanel.setOpaque(false);
		clientTypePanel.setBounds(10, 523, 414, 170);

		var flowLayout = new FlowLayout(FlowLayout.CENTER, 5, 5);
		clientTypePanel.setLayout(flowLayout);
		contentPane.add(clientTypePanel);

		header = new Header(this, "New Client", null, false);
		contentPane.add(header);

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

				if (validateAllFields()) {

					var mCreator = MementoCreator.getInstance();
					var mRestorer = MementoRestorer.getInstance();

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
					var selectedItem = groupCBBox.getSelectedItem().toString();

					// if there is no group selected then set it to null
					group = selectedItem.equalsIgnoreCase("No Groups") ? null : (Client) groupCBBox.getSelectedItem();

					ageIn = Integer.parseInt(age.getText());
					commissionIn = Double.parseDouble(commission.getText());
					revenueGeneratedIn = Double.parseDouble(revenueGenerated.getText());
					clientTypeInList = getClientTypeInfo();

					switch ((ClientType) clientTypeCBBox.getSelectedItem()) {
						case ACTOR:
							toAdd = new Actor(nameIn, ageIn, genderIn, nationalityIn, experienceList, commissionIn,
									awardList, revenueGeneratedIn, clientTypeInList.get(0));
							break;
						case MUSICIAN:
							instrumentIn = new Instrument(clientTypeInList.get(2));
							toAdd = new Musician(nameIn, ageIn, genderIn, nationalityIn, experienceList, commissionIn,
									awardList, revenueGeneratedIn, clientTypeInList.get(0), clientTypeInList.get(1),
									instrumentIn);
							break;
						case ATHLETE:
							toAdd = new Athlete(nameIn, ageIn, genderIn, nationalityIn, experienceList, commissionIn,
									awardList, revenueGeneratedIn, Double.parseDouble(clientTypeInList.get(0)),
									Double.parseDouble(clientTypeInList.get(1)), clientTypeInList.get(2));
							break;
					}
					if (group != null)
						group.addToGroup(toAdd);
					else
						company.addClient(toAdd);

					mCreator.setState(null, toAdd, null);
					mRestorer.addMementoToList(mCreator.createMementoWithSetState());

					company.sortPeople();

					console.log("Added new client: " + toAdd.getName());
					dispose();
				} else
					new ErrorDialog("Error", "Please fill in all the fields <br>(Awards and Experiences can be empty)");
			}
		});

		buttonPanel.add(confirm);

		/*
		 * ComboBox
		 */
		groupCBBox = new JComboBox(company.getClients().toArray());
		groupCBBox.setBounds(10, 397, 414, 50);
		groupCBBox.addItem("No Groups");

		if (company.getNumberOfClients() != 0)
			groupCBBox.setSelectedIndex(company.getNumberOfClients());

		groupCBBox.setBorder(new CustomTitledBorder("Existing Groups"));
		contentPane.add(groupCBBox);

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
		contentPane.add(clientTypeCBBox);

		experiences = new TextField_Skeleton("Experiences (Sepearate each experience by [,]", "Exp 1, Exp 2, Exp...");
		experiences.setBounds(10, 336, 414, 50);
		contentPane.add(experiences);

		titleLabel = new JLabel("New Client");
		titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(boldFont);
		titleLabel.setBounds(10, 46, 414, 35);
		contentPane.add(titleLabel);

		// by default set actor
		updateClientTypePanel(ClientType.ACTOR);

		setLocationRelativeTo(parentDialog);

	}

	private void updateClientTypePanel(ClientType type) {
		// each update clears the panel
		clientTypePanel.removeAll();

		var size = new Dimension(400, 50);

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

		// for each component within the clientTypePanel, check if its empty
		for (var component : clientTypePanel.getComponents()) {
			if (((JTextField) component).getText().isBlank() | component.getFont() instanceof PlaceholderFont)
				toReturn &= false;
		}
		return toReturn;
	}

	private List<String> getClientTypeInfo() {
		List<String> toReturn = new ArrayList<>();

		var clientTypePanelComponents = clientTypePanel.getComponents();

		for (var component : clientTypePanelComponents) {
			// takes each entry and save it in the list (toReturn)
			toReturn.add(((JTextField) component).getText());
		}
		return toReturn;
	}

	private boolean validateDoubles(String text) {
		try {
			// if unable to parse, its not a valid double
			Double.parseDouble(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean validateIntegers(String text) {
		try {
			// if unable to parse, its not a valid int
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean isFilled(JTextField field) {
		// check if the given field is blank or if the font type is the placeholder font
		return !((field.getFont() instanceof PlaceholderFont) | field.getText().isBlank());
	}

	private boolean validateAllFields() {
		// does not check if awards / experience / groups are filled
		boolean toReturn = true;

		toReturn &= isFilled(name);
		toReturn &= validateIntegers(age.getText());
		toReturn &= isFilled(gender);
		toReturn &= isFilled(nationality);
		toReturn &= validateDoubles(commission.getText());
		toReturn &= validateDoubles(revenueGenerated.getText());
		toReturn &= clientTypeFilled();

		return toReturn;
	}

	private List<Experience> strExpToList(String list) {
		List<Experience> toReturn = new ArrayList<>();
		var temp = list.split(",");
		for (var exp : temp) {
			var e = new Experience(exp.strip());
			toReturn.add(e);
		}

		return toReturn;
	}

	private List<Award> strAwardToList(String list) {
		List<Award> toReturn = new ArrayList<>();
		var temp = list.split(",");
		for (var award : temp) {
			var a = new Award(award.strip());
			toReturn.add(a);
		}

		return toReturn;
	}

}
