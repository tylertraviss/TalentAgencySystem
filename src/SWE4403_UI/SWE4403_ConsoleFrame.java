package SWE4403_UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import SWE4403_UI_Buttons.SWE4403_Button;
import SWE4403_UI_Buttons.SWE4403_EditClientButton;
import SWE4403_UI_Buttons.SWE4403_EditEmployeeButton;
import SWE4403_UI_Components.SWE4403_ConsoleScrollPane;
import SWE4403_UI_Components.SWE4403_ConsoleTextArea;
import SWE4403_UI_Utilities.SWE4403_ButtonHandler;

/**
 * Note : ## = comments to remove something
 */

public class SWE4403_ConsoleFrame extends JFrame {

	private JPanel contentPane;
	private JScrollPane consoleScrollPane;
	private SWE4403_Button editEmployeeButton, editClientButton;

	private static final String FRAME_TITLE = "SWE4403 Project";

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
		setBounds(100, 100, 460, 300);
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
		consoleScrollPane = new SWE4403_ConsoleScrollPane(SWE4403_ConsoleTextArea.getInstance());
		consoleScrollPane.setBounds(10, 11, 424, 170);
		contentPane.add(consoleScrollPane);

		/*
		 * BUTTONS SETTINGS
		 */
		editEmployeeButton = new SWE4403_EditEmployeeButton("Edit Employees");
		editClientButton = new SWE4403_EditClientButton("Edit Clients");
		editClientButton.setBounds(10, 198, 130, 40);
		editEmployeeButton.setBounds(305, 198, 130, 40);
		contentPane.add(editClientButton);
		contentPane.add(editEmployeeButton);
	}
}
