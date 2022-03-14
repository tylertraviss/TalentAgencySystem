package SWE4403_UI_Dialogs;

import java.awt.BorderLayout;
import java.awt.Dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import SWE4403_UI_JLabels.SWE4403_EditDialogJLabel;

public abstract class SWE4403_EditDialog extends JDialog {

	protected final JPanel contentPanel = new JPanel();
	protected SWE4403_EditDialogJLabel dialogLabel;

	/**
	 * Create the dialog.
	 */
	public SWE4403_EditDialog(JDialog ownerDialogBox, JFrame ownerFrame, String title) {
		super();
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		setTitle(title);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// ensures the dialogbox dont go out of screen
		// ## uncomment this btm code to allow the dialog boxes to fit within screen
		// Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// if ((ownerFrame.getX() + ownerFrame.getWidth() >= (screenSize.getWidth() /
		// 2)))
		// setLocation(new Point(ownerFrame.getX() - getWidth(), ownerFrame.getY()));
		// else
		// setLocation(new Point(ownerFrame.getX() + ownerFrame.getWidth(),
		// ownerFrame.getY()));

		dialogLabel = new SWE4403_EditDialogJLabel();
		dialogLabel.setBounds(10, 11, 414, 174);
		contentPanel.add(dialogLabel);
	}

}
