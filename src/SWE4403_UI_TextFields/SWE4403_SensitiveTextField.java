package SWE4403_UI_TextFields;

import java.awt.event.ActionEvent;

import SWE4403_UI_Utilities.SWE4403_TextFieldHandler;

public abstract class SWE4403_SensitiveTextField extends SWE4403_TextField {

	private String title;

	public SWE4403_SensitiveTextField(String title) {
		super(title);
		this.title = title;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SWE4403_TextFieldHandler.getInstance().handleTextField(this, title);
	}
}
