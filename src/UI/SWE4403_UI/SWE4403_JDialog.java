package SWE4403_UI;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;

public abstract class SWE4403_JDialog extends JDialog {

	protected final JPanel contentPanel = new JPanel();
	protected SWE4403_DialogJLabel dialogLabel;

	/**
	 * Create the dialog.
	 */
	public SWE4403_JDialog(String title) {
		super();
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
	}

}
