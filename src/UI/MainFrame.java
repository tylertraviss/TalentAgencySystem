package UI;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import UI.borders.WindowBorder;
import UI.buttons.Button_Skeleton;
import UI.dialogs.EditClientDialog;
import UI.dialogs.EditEmployeeDialog;
import UI.dialogs.EditSponsorDialog;
import UI.dialogs.PrintDialog;
import UI.panels.Header;
import UI.textarea.ConsoleTA;
import src.src.com.company.Company;
import src.src.com.company.Employee;
import src.src.com.company.MementoRestorer;
import src.src.com.company.SponsorshipMediator;

public class MainFrame {

	private JFrame frame;

	private JPanel buttonPanel, header;

	private JTextArea consoleTA;

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
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 730, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.getRootPane().setBorder(WindowBorder.getInstance());

		/*
		 * JTextArea
		 */

		consoleSP = new JScrollPane();
		consoleSP.setBounds(10, 46, 710, 269);
		frame.getContentPane().add(consoleSP);
		consoleTA = ConsoleTA.getInstance();
		consoleSP.setViewportView(consoleTA);
		consoleSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		/*
		 * JPanel
		 */
		buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setBorder(null);
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setBounds(10, 335, 710, 50);
		frame.getContentPane().add(buttonPanel);

		header = new Header(frame, "Talent Agency System", null, true);
		frame.getContentPane().add(header);

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
				MementoRestorer mRestorer = MementoRestorer.getInstance();
				SponsorshipMediator sponsorshipMediator = SponsorshipMediator.getInstance();
				Company company = Company.getInstance();
				var memento = mRestorer.getLastMemento();

				if (memento == null)
					return;
				var empToRemove = memento.getEmployee();
				var clientToRemove = memento.getClient();
				var sponsorship = memento.getSponsor();

				if (empToRemove != null) {
					if (company.getEmployees().contains(empToRemove))
						company.removeEmployee(empToRemove);
					else {
						removeSubordinate(company.getEmployees().get(0), empToRemove);
					}
				} else if (clientToRemove != null) {
					if (company.getClients().contains(clientToRemove))
						company.removeClient(clientToRemove);
					else
						for (var client : company.getClients())
							if (client.getGroup().contains(clientToRemove))
								client.removeFromGroup(clientToRemove);

				} else if (sponsorship != null) {
					sponsorshipMediator.discontinueSponsorship(sponsorship);
				}

				mRestorer.removeLastMemento();
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

	private boolean removeSubordinate(Employee emp, Employee toRemove) {
		if (emp.getSubordinates().contains(toRemove)) {
			emp.removeSubordinate(toRemove);
			return true;
		}

		for (var sub : emp.getSubordinates()) {
			var removed = removeSubordinate(sub, toRemove);

			if (removed) {
				return true;
			}
		}

		return false;

	}
}
