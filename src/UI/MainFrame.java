package UI;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import UI.buttons.Button_Skeleton;
import UI.dialogs.EditClientDialog;
import UI.dialogs.EditEmployeeDialog;
import UI.dialogs.EditSponsorDialog;
import UI.dialogs.PrintDialog;
import UI.textarea.ConsoleTA;

public class MainFrame {

	private JFrame frame;

	private JPanel buttonPanel;

	private JTextArea consoleTA;

	private JButton editClient, editEmployee, editSponsor, print, undo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 730, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		/*
		 * JTextArea
		 */
		consoleTA = ConsoleTA.getInstance();
		consoleTA.setBounds(10, 11, 694, 304);
		frame.getContentPane().add(consoleTA);

		/*
		 * JPanel
		 */
		buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setBorder(null);
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setBounds(10, 335, 694, 50);
		frame.getContentPane().add(buttonPanel);

		/*
		 * JButton
		 */
		editClient = new Button_Skeleton("Edit Client");
		editClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EditClientDialog(frame).setVisible(true);
			}
		});
		editEmployee = new Button_Skeleton("Edit Employee");
		editEmployee.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EditEmployeeDialog(frame).setVisible(true);
			}
		});
		editSponsor = new Button_Skeleton("Edit Sponsor");
		editSponsor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EditSponsorDialog(frame).setVisible(true);
			}
		});
		print = new Button_Skeleton("Print");
		print.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PrintDialog(frame).setVisible(true);
			}
		});
		undo = new Button_Skeleton("Undo");
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Edward add your undo function here
			}
		});
		/*
		 * Add the buttons to the button Panel
		 */
		buttonPanel.add(editClient);
		buttonPanel.add(editEmployee);
		buttonPanel.add(editSponsor);
		buttonPanel.add(print);
		buttonPanel.add(undo);
	}
}
