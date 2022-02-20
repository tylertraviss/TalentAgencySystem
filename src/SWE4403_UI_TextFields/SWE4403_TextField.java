package SWE4403_UI_TextFields;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import SWE4403_UI_Utilities.SWE4403_StandardFont;
import SWE4403_UI_Utilities.SWE4403_TextFieldHandler;
import SWE4403_UI_Utilities.SWE4403_TitledBorder;

public abstract class SWE4403_TextField extends JTextField implements ActionListener {

	SWE4403_TextFieldHandler tfHandler = SWE4403_TextFieldHandler.getInstance();

	public SWE4403_TextField(String title) {
		this.setFont(SWE4403_StandardFont.getInstance());
		this.setOpaque(false);
		this.setBorder(new SWE4403_TitledBorder(title));
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tfHandler.handleTextField(this);
	}

}
