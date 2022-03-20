package UI.dialogs;

import java.awt.BorderLayout;
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
import UI.textarea.ConsoleTA;
import UI.textfields.TextField_Skeleton;
import src.company.Client;
import src.company.Company;
import src.company.MementoCreator;
import src.company.MementoRestorer;
import src.company.Sponsor;
import src.company.SponsoredClient;
import src.company.Sponsorship;
import src.company.SponsorshipMediator;

public class AddSponsorDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JTextField sponsor, amount;
	private JComboBox<Client> clientCBBox;
	private JPanel buttonPanel, header;
	private JButton confirm;
	private JLabel titleLabel;

	/**
	 * Create the dialog.
	 */
	public AddSponsorDialog(JDialog parentDialog) {
		super(parentDialog);

		var console = ConsoleTA.getInstance();
		var sponsorshipMediator = SponsorshipMediator.getInstance();
		var contentPane = getContentPane();
		var borderLayout = new BorderLayout();
		var windowBorder = WindowBorder.getInstance();

		setModal(true);
		setTitle("Add Sponsor");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 435, 385);

		contentPane.setLayout(borderLayout);
		getRootPane().setBorder(windowBorder);
		contentPanel.setLayout(null);
		setUndecorated(true);
		contentPane.add(contentPanel, BorderLayout.CENTER);

		/*
		 * TextField
		 */
		sponsor = new TextField_Skeleton("Sponsor", "Enter sponsor here...");
		sponsor.setBounds(10, 110, 414, 50);

		amount = new TextField_Skeleton("Sponsored Amount", "Enter sponsored amount here...");
		amount.setBounds(10, 232, 414, 50);

		contentPanel.add(sponsor);
		contentPanel.add(amount);

		/*
		 * Combobox
		 */
		var company = Company.getInstance();
		var clientList = company.getAllClients();
		var customTitledBorder = new CustomTitledBorder("Select Client");

		clientCBBox = new JComboBox(clientList.toArray());
		clientCBBox.setBorder(customTitledBorder);
		clientCBBox.setBounds(10, 171, 414, 50);
		contentPanel.add(clientCBBox);

		/*
		 * Panel
		 */
		buttonPanel = new ButtonPanel_Skeleton();
		buttonPanel.setBounds(10, 324, 414, 50);
		contentPanel.add(buttonPanel);

		header = new Header(this, "New Sponsor", null, false);
		contentPanel.add(header);

		/*
		 * Buttons
		 */
		confirm = new Button_Skeleton("Confirm");
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String sponsorIn;
				Client clientIn;
				double sponsoredAmountIn;

				if (validateAllFields()) {
					MementoCreator mCreator = MementoCreator.getInstance();
					MementoRestorer mRestorer = MementoRestorer.getInstance();

					sponsorIn = sponsor.getText();
					clientIn = (Client) clientCBBox.getSelectedItem();
					sponsoredAmountIn = Double.parseDouble(amount.getText());

					var s = new Sponsor(sponsorIn, sponsorshipMediator);
					var sc = new SponsoredClient(clientIn, sponsorshipMediator);
					var sp = new Sponsorship(s, sc, sponsoredAmountIn, sponsorshipMediator);

					sponsorshipMediator.registerSponsorship(sp);

					console.log("Added new Sponsor for client :" + sc);

					sponsorshipMediator.sortSponsors();

					mCreator.setState(null, null, sp);
					mRestorer.addMementoToList(mCreator.createMementoWithSetState());

					dispose();
				} else
					new ErrorDialog("Error", "Please fill in all the fields.");
			}
		});
		buttonPanel.add(confirm);

		/*
		 * Label
		 */
		titleLabel = new JLabel("New Sponsor");
		titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Consolas", Font.BOLD, 12));
		titleLabel.setBounds(10, 49, 414, 50);
		contentPanel.add(titleLabel);

		setLocationRelativeTo(parentDialog);
	}

	private boolean validateAllFields() {
		boolean toReturn = true;

		toReturn &= isFilled(sponsor);
		toReturn &= validateDouble(amount.getText());
		toReturn &= validateClient();

		return toReturn;
	}

	private boolean isFilled(JTextField tf) {
		return !(tf.getText().isBlank() | tf.getFont() instanceof PlaceholderFont);
	}

	private boolean validateDouble(String num) {
		try {
			Double.parseDouble(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean validateClient() {
		try {
			// checks if there a client exist
			clientCBBox.getSelectedItem().toString();
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}
}
