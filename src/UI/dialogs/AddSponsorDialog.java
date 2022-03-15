package UI.dialogs;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import UI.buttons.Button_Skeleton;
import UI.panels.ButtonPanel_Skeleton;
import UI.textfields.TextField_Skeleton;
import src.src.com.company.Client;
import src.src.com.company.Company;

public class AddSponsorDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JTextField sponsor, amount;
	private JComboBox<Client> clientCBBox;
	private JPanel buttonPanel;
	private JButton confirm;
	private JLabel titleLabel;

	/**
	 * Create the dialog.
	 */
	public AddSponsorDialog(JDialog parentDialog) {
		super(parentDialog);
		setModal(true);
		setTitle("Add Sponsor");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 345);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		/*
		 * TextField
		 */
		sponsor = new TextField_Skeleton("Sponsor", "Enter sponsor here...");
		sponsor.setBounds(10, 72, 414, 50);

		amount = new TextField_Skeleton("Sponsored Amount", "Enter sponsored amount here...");
		amount.setBounds(10, 185, 414, 50);

		contentPanel.add(sponsor);
		contentPanel.add(amount);

		/*
		 * Combobox
		 */
		clientCBBox = new JComboBox(Company.getInstance().getClients().toArray());
		clientCBBox.setBounds(10, 133, 414, 35);
		contentPanel.add(clientCBBox);

		/*
		 * Panel
		 */
		buttonPanel = new ButtonPanel_Skeleton();
		buttonPanel.setBounds(10, 246, 414, 50);
		contentPanel.add(buttonPanel);

		/*
		 * Buttons
		 */
		confirm = new Button_Skeleton("Confirm");
		buttonPanel.add(confirm);

		/*
		 * Label
		 */
		titleLabel = new JLabel("New Sponsor");
		titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Consolas", Font.BOLD, 12));
		titleLabel.setBounds(10, 11, 414, 50);
		contentPanel.add(titleLabel);
	}
}
