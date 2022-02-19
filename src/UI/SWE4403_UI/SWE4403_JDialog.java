package SWE4403_UI;

import java.awt.BorderLayout;
import java.awt.Dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class SWE4403_JDialog extends JDialog {

	protected final JPanel contentPanel = new JPanel();
	protected SWE4403_DialogJLabel dialogLabel;

	/**
	 * Create the dialog.
	 */
	public SWE4403_JDialog(JDialog ownerDialogBox, JFrame ownerFrame, String title) {
		super();
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		setTitle(title);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);

		dialogLabel = new SWE4403_DialogJLabel();
		dialogLabel.setBounds(10, 11, 414, 174);
		contentPanel.add(dialogLabel);

		SWE4403_ButtonHandler.getInstance().setDialog(this);
	}

}
