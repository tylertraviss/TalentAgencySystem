package UI.dialogs;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import src.src.com.company.Company;

public class AddClientDialog extends JDialog {

	private Company company = Company.getInstance();

	private JTextField name, age, gender, nationality, experiences, commission, awards, avenueGenerated;
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
		avenueGenerated = new TextField_Skeleton("Avenue Generated", "Enter avenue generated here...");
		avenueGenerated.setBounds(10, 214, 414, 50);

		getContentPane().add(name);
		getContentPane().add(age);
		getContentPane().add(gender);
		getContentPane().add(commission);
		getContentPane().add(awards);
		getContentPane().add(avenueGenerated);

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
				System.out.println("Button " + clientTypeFilled());
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
}
