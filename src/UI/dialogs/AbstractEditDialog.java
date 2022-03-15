package UI.dialogs;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import UI.buttons.Button_Skeleton;
import UI.fonts.BoldFont;
import UI.panels.ButtonPanel_Skeleton;

public abstract class AbstractEditDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JPanel buttonPanel;
	protected JButton addButton, removeButton;
	private JLabel titleLabel;
	protected JDialog self;

	/**
	 * Create the dialog.
	 */
	public AbstractEditDialog(String title, String type, JFrame parentFrame) {
		super(parentFrame);
		setLocationRelativeTo(parentFrame);
		setResizable(false);
		setTitle(title);
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 185);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		/*
		 * Labels
		 */
		titleLabel = new JLabel(title);
		titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(BoldFont.getInstance());
		titleLabel.setBounds(10, 11, 414, 50);
		contentPanel.add(titleLabel);

		/*
		 * Buttons
		 */
		addButton = new Button_Skeleton("+ " + type);
		removeButton = new Button_Skeleton("- " + type);

		/*
		 * Panel
		 */
		buttonPanel = new ButtonPanel_Skeleton();
		buttonPanel.setBounds(10, 85, 414, 50);
		contentPanel.add(buttonPanel);

		buttonPanel.add(addButton);
		buttonPanel.add(removeButton);

		self = this;
	}

}
