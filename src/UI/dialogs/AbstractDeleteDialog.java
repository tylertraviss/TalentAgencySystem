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

import UI.borders.WindowBorder;
import UI.buttons.Button_Skeleton;
import UI.panels.ButtonPanel_Skeleton;
import UI.panels.Header;
import UI.textfields.TextField_Skeleton;

public abstract class AbstractDeleteDialog extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPanel, header;
	private JTextField idToDelete;
	private JButton confirm;
	private JDialog self;

	/**
	 * Create the dialog.
	 */
	public AbstractDeleteDialog(String title) {
		setUndecorated(true);
		setResizable(false);
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle(title);
		setBounds(100, 100, 435, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		getRootPane().setBorder(WindowBorder.getInstance());
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		/*
		 * TextField
		 */
		idToDelete = new TextField_Skeleton("Enter ID to delete", "Enter ID here...");
		idToDelete.setBounds(10, 46, 414, 60);
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
		buttonPanel.setLocation(10, 117);
		buttonPanel.setSize(414, 60);
		buttonPanel.add(confirm);
		header = new Header(this, title, null, false);
		contentPanel.add(header);

		contentPanel.add(buttonPanel);

		self = this;

	}

	@Override
	public abstract void actionPerformed(ActionEvent e);
}
