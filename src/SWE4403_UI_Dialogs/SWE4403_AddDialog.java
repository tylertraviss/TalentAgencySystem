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
import SWE4403_UI_Utilities.SWE4403_ButtonHandler;

public class SWE4403_AddDialog extends JDialog {

	protected final JPanel contentPanel = new JPanel();

	private JButton okButton, cancelButton;

	/**
	 * Create the dialog.
	 */
	public SWE4403_AddDialog(JFrame ownerFrame, JDialog ownerDialog, String title, String type) {
		super();
		// to specifiy if this ok button is in the add client or add employee
		setTitle(title);
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 380, 470);
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
		okButton = new SWE4403_OkButton("OK", type);
		okButton.setBounds(10, 382, 85, 38);
		cancelButton = new SWE4403_CancelButton("Cancel", type);
		cancelButton.setBounds(269, 382, 85, 38);

		contentPanel.add(okButton);
		contentPanel.add(cancelButton);

		SWE4403_ButtonHandler.getInstance().setDialog(this);

	}
}
