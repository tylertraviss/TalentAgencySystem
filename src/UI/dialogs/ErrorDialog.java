package UI.dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import UI.borders.WindowBorder;
import UI.buttons.Button_Skeleton;
import UI.fonts.StandardFont;
import UI.panels.ButtonPanel_Skeleton;
import UI.panels.Header;

public class ErrorDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private final String CONTEXT_HEADER = "<html><center>";
	private final String CONTEXT_FOOTER = "</center></html>";

	private JPanel header, buttonPanel;
	private JLabel context;
	private JButton confirm;

	/**
	 * Create the dialog.
	 */
	public ErrorDialog(String title, String errorMsg) {
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setUndecorated(true);
		setBounds(100, 100, 450, 210);

		var contentPane = getContentPane();
		var borderLayout = new BorderLayout();
		var windowBorder = WindowBorder.getInstance();
		var standardFont = StandardFont.getInstance();

		contentPane.setLayout(borderLayout);
		contentPanel.setLayout(null);
		getRootPane().setBorder(windowBorder);
		contentPane.add(contentPanel, BorderLayout.CENTER);
		/*
		 * JPanels
		 */
		header = new Header(this, title, null, false);
		contentPanel.add(header);
		buttonPanel = new ButtonPanel_Skeleton();
		buttonPanel.setBounds(10, 146, 430, 50);
		contentPanel.add(buttonPanel);

		/*
		 * Jlabel
		 */
		context = new JLabel(CONTEXT_HEADER + errorMsg + CONTEXT_FOOTER);
		context.setHorizontalTextPosition(SwingConstants.CENTER);
		context.setHorizontalAlignment(SwingConstants.CENTER);
		context.setFont(standardFont);
		context.setBounds(10, 46, 430, 89);
		contentPanel.add(context);

		/*
		 * Buttons
		 */
		confirm = new Button_Skeleton("Confirm");
		buttonPanel.add(confirm);
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});

		setLocationRelativeTo(null);

		// display it
		setVisible(true);
	}

}
