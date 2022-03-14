package SWE4403_UI_Buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import SWE4403_Font.SWE4403_StandardFont;
import SWE4403_UI_Utilities.SWE4403_ButtonHandler;
import SWE4403_UI_Utilities.SWE4403_RoundedBorder;

public abstract class SWE4403_Button extends JButton implements ActionListener {

	protected SWE4403_ButtonHandler bh = SWE4403_ButtonHandler.getInstance();

	public SWE4403_Button(String text) {
		this.setText(text);
		this.setBorder(SWE4403_RoundedBorder.getInstance());
		this.setFont(SWE4403_StandardFont.getInstance());
		this.setFocusPainted(false);
		this.setFocusable(false);
		this.setContentAreaFilled(false);
		this.setPreferredSize(new Dimension(140, 40));
		addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SWE4403_ButtonHandler.getInstance().handleButton(this);
	}

}
