package UI.dialogs;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import UI.buttons.Button_Skeleton;
import UI.panels.ButtonPanel_Skeleton;
import UI.textfields.TextField_Skeleton;

public abstract class AbstractDeleteDialog extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPanel;
	private JTextField idToDelete;
	private JButton confirm;
	private JLabel titleLabel;
	private JDialog self;

	/**
	 * Create the dialog.
	 */
	public AbstractDeleteDialog(String title) {
		setResizable(false);
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle(title);
		setBounds(100, 100, 450, 255);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		/*
		 * TextField
		 */
		idToDelete = new TextField_Skeleton("Enter ID to delete", "Enter ID here...");
		idToDelete.setBounds(10, 72, 414, 60);
		contentPanel.add(idToDelete);

		/*
		 * Button
		 */
		confirm = new Button_Skeleton("Confirm");
		confirm.addActionListener(this);
		/*
		 * JPanel
		 */
		buttonPanel = new ButtonPanel_Skeleton();
		buttonPanel.setLocation(10, 143);
		buttonPanel.setSize(414, 60);
		buttonPanel.add(confirm);

		contentPanel.add(buttonPanel);

		/*
		 * JLabel
		 */
		titleLabel = new JLabel(title);
		titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Consolas", Font.BOLD, 12));
		titleLabel.setBounds(10, 11, 414, 50);
		contentPanel.add(titleLabel);

		self = this;

	}

	@Override
	public abstract void actionPerformed(ActionEvent e);
}
