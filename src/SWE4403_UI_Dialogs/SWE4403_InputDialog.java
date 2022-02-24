package SWE4403_UI_Dialogs;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SWE4403_UI_Buttons.SWE4403_CancelButton;
import SWE4403_UI_Buttons.SWE4403_OkButton;
import SWE4403_UI_JLabels.SWE4403_InputDialogJLabel;

public abstract class SWE4403_InputDialog extends JDialog {

	protected final JPanel contentPanel = new JPanel();

	protected SWE4403_InputDialogJLabel questionLabel;
	protected JButton okButton, cancelButton;

	public SWE4403_InputDialog(JFrame ownerFrame, JDialog ownerDialog, String title, String type) {
		setTitle(title);
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 310, 280);
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
		 * Label Settings
		 */

		questionLabel = new SWE4403_InputDialogJLabel();
		questionLabel.setBounds(10, 10, 274, 100);
		questionLabel.setString("Placeholder text. If you are reading this your code is wrong.");

		contentPanel.add(questionLabel);

		/*
		 * Button Panel Settings
		 */
		JPanel panel = new JPanel();
		panel.setBounds(10, 190, 274, 40);
		contentPanel.add(panel);

		okButton = new SWE4403_OkButton("Confirm", type);
		cancelButton = new SWE4403_CancelButton("Cancel", type);

		// overwrite the size of the buttons to make them fit
		okButton.setPreferredSize(new Dimension(90, 30));
		cancelButton.setPreferredSize(new Dimension(90, 30));

		panel.add(okButton);
		panel.add(cancelButton);
	}

}
