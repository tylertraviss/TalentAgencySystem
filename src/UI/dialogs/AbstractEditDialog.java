package UI.dialogs;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import UI.borders.WindowBorder;
import UI.buttons.Button_Skeleton;
import UI.fonts.BoldFont;
import UI.panels.ButtonPanel_Skeleton;
import UI.panels.Header;

public abstract class AbstractEditDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JPanel buttonPanel, header;
	protected JButton addButton, removeButton;
	private JLabel titleLabel;
	protected JDialog self;

	protected ImageIcon icon;

	/**
	 * Create the dialog.
	 */
	public AbstractEditDialog(String title, String type, JFrame parentFrame) {
		super(parentFrame);
		setUndecorated(true);
		setLocationRelativeTo(parentFrame);
		setResizable(false);
		setTitle(title);
		setModal(true);
		getRootPane().setBorder(WindowBorder.getInstance());
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
		titleLabel.setBounds(10, 46, 414, 50);
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
		buttonPanel.setBounds(10, 124, 414, 50);
		contentPanel.add(buttonPanel);

		buttonPanel.add(addButton);
		buttonPanel.add(removeButton);
		header = new Header(this, title, icon, false);
		contentPanel.add(header);

		self = this;
	}

}
