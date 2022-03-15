package UI.panels;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UI.fonts.StandardFont;

public class Header extends JPanel {
	private static final long serialVersionUID = 1L;
	private int mousex, mousey;
	private JLabel LBL_taskbar;
	private boolean focused;

	/**
	 * Create the panel.
	 * 
	 * @wbp.parser.constructor
	 */
	public Header(JFrame frame, String title, ImageIcon icon, boolean isMain) {
		init(frame, null, title, icon, isMain);
	}

	public Header(JDialog dialog, String title, ImageIcon icon, boolean isMain) {
		init(null, dialog, title, icon, isMain);
	}

//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		g.setColor(Color.GRAY);
//		g.fillRect(50, 5, 2, 25);
//	}

	private void init(JFrame frame, JDialog dialog, String title, ImageIcon icon, boolean isMain) {
		setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
		setLayout(null);
		if (frame != null)
			setBounds(0, 0, frame.getWidth(), 35);
		else
			setBounds(0, 0, dialog.getWidth(), 35);
		focused = true;

		if (frame != null)
			frame.addWindowFocusListener(new WindowAdapter() {

				@Override
				public void windowGainedFocus(WindowEvent e) {
					if (frame.getState() == JFrame.NORMAL && !focused) {
						frame.setOpacity(1f);
						focused = true;
					}
				}

			});

		JButton BTN_exit = new JButton("X");
		BTN_exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTN_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (frame != null)
					frame.dispose();
				else
					dialog.dispose();
				if (isMain)
					System.exit(0);
			}
		});
		BTN_exit.setRolloverEnabled(false);
		BTN_exit.setRequestFocusEnabled(false);
		BTN_exit.setOpaque(false);
		BTN_exit.setForeground(Color.RED);
		BTN_exit.setFont(new Font("Consolas", Font.PLAIN, 20));
		BTN_exit.setFocusable(false);
		BTN_exit.setFocusTraversalKeysEnabled(false);
		BTN_exit.setFocusPainted(false);
		BTN_exit.setContentAreaFilled(false);
		BTN_exit.setBorder(null);
		if (frame != null)
			BTN_exit.setBounds((frame.getWidth() - 43), 11, 43, 24);
		else
			BTN_exit.setBounds((dialog.getWidth() - 43), 11, 43, 24);
		add(BTN_exit);

		JButton BTN_minimize = new JButton("\u2014");
		BTN_minimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTN_minimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (frame != null)
					new Thread(() -> {
						float i = 1f;
						while (i >= 0) {
							frame.setOpacity(i);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
							i -= 0.07;
						}
						frame.setState(JFrame.ICONIFIED);
						focused = false;
						Thread.currentThread().interrupt();
					}).start();
			}
		});
		BTN_minimize.setRolloverEnabled(false);
		BTN_minimize.setRequestFocusEnabled(false);
		BTN_minimize.setOpaque(false);
		BTN_minimize.setForeground(Color.RED);
		BTN_minimize.setFont(new Font("Consolas", Font.PLAIN, 20));
		BTN_minimize.setFocusable(false);
		BTN_minimize.setFocusTraversalKeysEnabled(false);
		BTN_minimize.setFocusPainted(false);
		BTN_minimize.setContentAreaFilled(false);
		BTN_minimize.setBorder(null);
		if (frame != null)
			BTN_minimize.setBounds((frame.getWidth() - 70), 11, 43, 24);
		add(BTN_minimize);

		addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (frame != null)
					frame.setLocation(frame.getX() + e.getX() - mousex, frame.getY() + e.getY() - mousey);
				else
					dialog.setLocation(dialog.getX() + e.getX() - mousex, dialog.getY() + e.getY() - mousey);
			}

			@Override
			public void mouseMoved(MouseEvent e) {
			}
		});

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mousex = e.getX();
				mousey = e.getY();
			}

		});

		LBL_taskbar = new JLabel(title);
		LBL_taskbar.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		LBL_taskbar.setForeground(Color.BLACK);
		LBL_taskbar.setFont(StandardFont.getInstance());
		if (frame != null)
			LBL_taskbar.setBounds(66, 11, frame.getWidth() - 63, 24);
		else
			LBL_taskbar.setBounds(66, 11, dialog.getWidth() - 63, 24);
		add(LBL_taskbar);

		JLabel LBL_taskbarIcon = new JLabel(icon, JLabel.CENTER);
		LBL_taskbarIcon.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		LBL_taskbarIcon.setFocusTraversalKeysEnabled(false);
		LBL_taskbarIcon.setFocusable(false);
		LBL_taskbarIcon.setBounds(0, 5, 56, 30);
		add(LBL_taskbarIcon);

		LBL_taskbar.setFont(StandardFont.getInstance());
	}

	public void setTitle(String newTitle) {
		LBL_taskbar.setText(newTitle);
	}

}
