package UI.dialogs;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import UI.utilities.ClientType;
import src.src.com.company.Company;

public class AddClientDialog extends JDialog {

	private Company company = Company.getInstance();

	private JTextField name, age, gender, nationality, experiences, commission, awards, avenueGenerated;
	private JLabel titleLabel;
	private JPanel buttonPanel, clientTypePanel;
	private JButton confirm;
	private JComboBox clientTypeCBBox, groupCBBox;

	public AddClientDialog(JDialog parentDialog) {
		setModal(true);
		setLocationRelativeTo(parentDialog);
		setModalityType(ModalityType.APPLICATION_MODAL);
		getContentPane().setLayout(null);
		setBounds(10, 10, 450, 750);
		setTitle("Add Client");

		/*
		 * TextFields
		 */
		name = new TextField_Skeleton("Name", "Enter name here...");
		name.setBounds(10, 59, 414, 50);
		age = new TextField_Skeleton("Age", "Example");
		age.setBounds(10, 120, 120, 50);
		gender = new TextField_Skeleton("Gender", "Example");
		gender.setBounds(150, 120, 120, 50);
		commission = new TextField_Skeleton("Commission", "Example");
		commission.setBounds(304, 120, 120, 50);
		awards = new TextField_Skeleton("Awards (Sepearate each award by [,]", "Award 1, Award 2, Award...");
		awards.setBounds(10, 242, 414, 50);
		avenueGenerated = new TextField_Skeleton("Avenue Generated", "Enter avenue generated here...");
		avenueGenerated.setBounds(10, 181, 414, 50);

		getContentPane().add(name);
		getContentPane().add(age);
		getContentPane().add(gender);
		getContentPane().add(commission);
		getContentPane().add(awards);
		getContentPane().add(avenueGenerated);

		/*
		 * JLabel
		 */
		titleLabel = new JLabel("New Client");
		titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(10, 11, 414, 50);
		titleLabel.setFont(BoldFont.getInstance());
		getContentPane().add(titleLabel);

		/*
		 * JPanel
		 */
		buttonPanel = new ButtonPanel_Skeleton();
		buttonPanel.setBounds(10, 637, 414, 50);
		getContentPane().add(buttonPanel);

		clientTypePanel = new JPanel();
		clientTypePanel.setOpaque(false);
		clientTypePanel.setBounds(10, 456, 414, 170);
		clientTypePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		getContentPane().add(clientTypePanel);

		/*
		 * JButton
		 */
		confirm = new Button_Skeleton("Confirm");
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}

		});

		buttonPanel.add(confirm);

		/*
		 * ComboBox
		 */
		groupCBBox = new JComboBox(Company.getInstance().getClients().toArray());
		groupCBBox.setBounds(10, 364, 414, 35);
		getContentPane().add(groupCBBox);

		clientTypeCBBox = new JComboBox(ClientType.values());
		clientTypeCBBox.setBounds(10, 410, 414, 35);
		clientTypeCBBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				var selection = clientTypeCBBox.getSelectedItem();
				updateClientTypePanel((ClientType) selection);
			}

		});
		getContentPane().add(clientTypeCBBox);

		experiences = new TextField_Skeleton("Experiences (Sepearate each experience by [,]", "Exp 1, Exp 2, Exp...");
		experiences.setBounds(10, 303, 414, 50);
		getContentPane().add(experiences);

		// by default set actor
		updateClientTypePanel(ClientType.ACTOR);

	}

	private void updateClientTypePanel(ClientType type) {
		// each update clears the panel
		clientTypePanel.removeAll();

		Dimension size = new Dimension(400, 50);

		switch (type) {
		case ACTOR:
			var actorType = new TextField_Skeleton("Actor Type", "Stunt person / Main character / Side charac...");
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
}
