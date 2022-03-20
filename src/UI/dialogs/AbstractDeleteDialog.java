package UI.dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

import UI.borders.CustomTitledBorder;
import UI.borders.WindowBorder;
import UI.buttons.Button_Skeleton;
import UI.panels.ButtonPanel_Skeleton;
import UI.panels.Header;
import UI.textarea.ConsoleTA;
import src.company.Company;

public abstract class AbstractDeleteDialog extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPanel, header;
	private JButton confirm;
	protected JComboBox selectionCBBox;
	protected Company company = Company.getInstance();
	protected ConsoleTA console = ConsoleTA.getInstance();

	/**
	 * Create the dialog.
	 */
	public AbstractDeleteDialog(String title) {
		var contentPane = getContentPane();

		setUndecorated(true);
		setResizable(false);
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle(title);
		setBounds(100, 100, 435, 200);
		contentPane.setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		getRootPane().setBorder(WindowBorder.getInstance());
		contentPane.add(contentPanel, BorderLayout.CENTER);

		/*
		 * Button
		 */
		confirm = new Button_Skeleton("Confirm");
		confirm.addActionListener(this);
		/*
		 * JPanel
		 */
		buttonPanel = new ButtonPanel_Skeleton();
		buttonPanel.setBounds(10, 117, 414, 60);
		buttonPanel.add(confirm);
		header = new Header(this, title, null, false);
		contentPanel.add(header);
		contentPanel.add(buttonPanel);

		selectionCBBox = new JComboBox();
		selectionCBBox.setBounds(10, 46, 414, 50);
		selectionCBBox.setBorder(new CustomTitledBorder(title));
		contentPanel.add(selectionCBBox);
	}

	@Override
	public abstract void actionPerformed(ActionEvent e);

	protected void setSelectionCBBox(List listToUse) {
		var comboBoxItems = new DefaultComboBoxModel(listToUse.toArray());
		selectionCBBox.setModel(comboBoxItems);
	}

}
