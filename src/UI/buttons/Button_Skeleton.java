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

		var roundedBorder = RoundedBorder.getInstance();
		var standardFont = StandardFont.getInstance();

		this.setText(text);
		this.setBorder(roundedBorder);
		this.setFont(standardFont);
		this.setFocusPainted(false);
		this.setFocusable(false);
		this.setContentAreaFilled(false);

		var dimension = new Dimension(120, 40);

		this.setPreferredSize(dimension);
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// unsued

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// unsued

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// unsued

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		var boldFont = BoldFont.getInstance();
		setFont(boldFont);
		setBorder(RoundedBorder.getInstance(Color.WHITE));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				var roundedBorder = RoundedBorder.getInstance();
				var standardFont = StandardFont.getInstance();
				setFont(standardFont);
				setBorder(roundedBorder);
			}

		});

	}

}
