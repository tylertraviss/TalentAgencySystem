package SWE4403_UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class SWE4403_Button extends JButton implements ActionListener {

	protected SWE4403_ButtonHandler bh = SWE4403_ButtonHandler.getInstance();

	public SWE4403_Button(String text) {
		this.setText(text);
		this.setBorder(SWE4403_RoundedBorder.getInstance());
		this.setFont(SWE4403_StandardFont.getInstance());
		this.setFocusPainted(false);
		this.setFocusable(false);
		this.setContentAreaFilled(false);
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		SWE4403_ButtonHandler.getInstance().handleButton(this);
	}

}
