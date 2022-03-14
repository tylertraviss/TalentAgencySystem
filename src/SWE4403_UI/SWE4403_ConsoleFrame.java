package SWE4403_UI;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import SWE4403_UI_Buttons.SWE4403_EditClientButton;
import SWE4403_UI_Buttons.SWE4403_EditEmployeeButton;
import SWE4403_UI_Buttons.SWE4403_UndoButton;
import SWE4403_UI_Components.SWE4403_ConsoleScrollPane;
import SWE4403_UI_Utilities.SWE4403_ButtonHandler;

/**
 * Note : ## = comments to remove something
 */

public class SWE4403_ConsoleFrame extends JFrame {

	private JPanel contentPane;
	private JScrollPane consoleScrollPane;
	private JButton editEmployeeButton, editClientButton, undoButton;

	private static final String FRAME_TITLE = "SWE4403 Project";
	private JPanel buttonPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SWE4403_ConsoleFrame frame = new SWE4403_ConsoleFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SWE4403_ConsoleFrame() {

		/*
		 * DEFAULT FRAME SETTINGS
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 420);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle(FRAME_TITLE);
		SWE4403_ButtonHandler.getInstance().setFrame(this);

		/*
		 * SCROLLPANE AND TEXTAREA SETTINGS
		 */
		// console text area is where everything gets displayed
		consoleScrollPane = new SWE4403_ConsoleScrollPane();
		consoleScrollPane.setBounds(10, 11, 600, 300);
		contentPane.add(consoleScrollPane);

		/*
		 * BUTTONS SETTINGS
		 */
		editClientButton = new SWE4403_EditClientButton("Edit Clients");
		editEmployeeButton = new SWE4403_EditEmployeeButton("Edit Employees");
		undoButton = new SWE4403_UndoButton("Undo");

		/*
		 * BUTTON PANEL SETTINGS
		 */
		buttonPanel = new JPanel();
		buttonPanel.setBorder(null);
		buttonPanel.setBounds(10, 322, 600, 58);
		buttonPanel.add(editClientButton);
		buttonPanel.add(editEmployeeButton);
		buttonPanel.add(undoButton);

		contentPane.add(buttonPanel);
	}
}
