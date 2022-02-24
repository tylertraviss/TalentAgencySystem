package SWE4403_UI_Dialogs;

import java.awt.BorderLayout;
import java.awt.Dialog;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SWE4403_UI_Buttons.SWE4403_CancelButton;
import SWE4403_UI_Buttons.SWE4403_OkButton;

public abstract class SWE4403_AddDialog extends JDialog {

	protected final JPanel contentPanel = new JPanel();

	private JButton okButton, cancelButton;
	private JPanel panel;

	/**
	 * Create the dialog.
	 */
	public SWE4403_AddDialog(JFrame ownerFrame, JDialog ownerDialog, String title, String type) {
		super();
		// to specifiy if this ok button is in the add client or add employee
		setTitle(title);
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 460, 470);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// ensures the dialogbox dont go out of screen
		// ## UNCOMMENT THE CODE BELOW FOR DISPLAY FORMATTING
		// Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// if ((ownerDialog.getX() + ownerDialog.getWidth() >= (screenSize.getWidth() /
		// 2)))
		// setLocation(new Point(ownerDialog.getX() - getWidth(), ownerDialog.getY()));
		// else
		// setLocation(new Point(ownerDialog.getX() + ownerDialog.getWidth(),
		// ownerDialog.getY()));

		/*
		 * BUTTON SETTINGS
		 */
		okButton = new SWE4403_OkButton("Confirm", type);
		cancelButton = new SWE4403_CancelButton("Cancel", type);

		/*
		 * PANEL BUTTON SETTINGS
		 */
		panel = new JPanel();
		panel.setBounds(10, 378, 424, 50);
		contentPanel.add(panel);
		panel.add(okButton);
		panel.add(cancelButton);
	}
}
