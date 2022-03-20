package UI;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import UI.borders.WindowBorder;
import UI.buttons.Button_Skeleton;
import UI.dialogs.EditClientDialog;
import UI.dialogs.EditEmployeeDialog;
import UI.dialogs.EditSponsorDialog;
import UI.dialogs.PrintDialog;
import UI.panels.Header;
import UI.textarea.ConsoleTA;
import src.company.Company;
import src.company.MementoRestorer;
import src.company.SponsorshipMediator;

public class MainFrame {

	private JFrame frame;

	private Container contentPane;
	private JPanel buttonPanel, header;

	private JButton editClient, editEmployee, editSponsor, print, undo;
	private JScrollPane consoleSP;

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

		var console = ConsoleTA.getInstance();
		var windowBorder = WindowBorder.getInstance();

		frame = new JFrame();
		contentPane = frame.getContentPane();
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 730, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(null);
		frame.setResizable(false);
		frame.getRootPane().setBorder(windowBorder);

		/*
		 * JTextArea
		 */

		consoleSP = new JScrollPane();
		consoleSP.setBounds(10, 46, 710, 269);
		contentPane.add(consoleSP);
		consoleSP.setViewportView(console);
		consoleSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		/*
		 * JPanel
		 */
		buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setBorder(null);
		var flowLayout = new FlowLayout();
		buttonPanel.setLayout(flowLayout);
		buttonPanel.setBounds(10, 335, 710, 50);
		contentPane.add(buttonPanel);

		header = new Header(frame, "Talent Agency System", null, true);
		contentPane.add(header);

		/*
		 * JButton
		 */
		editClient = new Button_Skeleton("Edit Client");
		editClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				var editClientDialog = new EditClientDialog(frame);
				editClientDialog.setVisible(true);
			}
		});
		editEmployee = new Button_Skeleton("Edit Employee");
		editEmployee.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				var editEmployeeDialog = new EditEmployeeDialog(frame);
				editEmployeeDialog.setVisible(true);
			}
		});
		editSponsor = new Button_Skeleton("Edit Sponsor");
		editSponsor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				var editSponsorDialog = new EditSponsorDialog(frame);
				editSponsorDialog.setVisible(true);
			}
		});
		print = new Button_Skeleton("Print");
		print.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				var printDialog = new PrintDialog(frame);
				printDialog.setVisible(true);
			}
		});
		undo = new Button_Skeleton("Undo");
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				var mRestorer = MementoRestorer.getInstance();
				var sponsorshipMediator = SponsorshipMediator.getInstance();
				var memento = mRestorer.getLastMemento();
				var company = Company.getInstance();

				/* Checks if the memento is empty. If so do nothing. */
				if (memento == null) {
					console.log("Nothing to undo.");
					return;
				}
				var empToRemove = memento.getEmployee();
				var clientToRemove = memento.getClient();
				var sponsorship = memento.getSponsor();

				if (empToRemove != null) {
					company.removeEmployee(empToRemove);

				} else if (clientToRemove != null) {
					company.removeClient(clientToRemove);

				} else if (sponsorship != null) {
					sponsorshipMediator.discontinueSponsorship(sponsorship);
				}

				/* Undo previous adding action and remove that memento */
				mRestorer.removeLastMemento();

				console.log("Previous action have been undone.");
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
