package UI.buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import UI.borders.RoundedBorder;
import UI.fonts.BoldFont;
import UI.fonts.StandardFont;

public class Button_Skeleton extends JButton implements MouseListener {

	public Button_Skeleton(String text) {
		this.setText(text);
		this.setBorder(RoundedBorder.getInstance());
		this.setFont(StandardFont.getInstance());
		this.setFocusPainted(false);
		this.setFocusable(false);
		this.setContentAreaFilled(false);
		this.setPreferredSize(new Dimension(120, 40));
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setFont(BoldFont.getInstance());
		setBorder(RoundedBorder.getInstance(Color.WHITE));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				setFont(StandardFont.getInstance());
				setBorder(RoundedBorder.getInstance());
			}

		});

	}

}
