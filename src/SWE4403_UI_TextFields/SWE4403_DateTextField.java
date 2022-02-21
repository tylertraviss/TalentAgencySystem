package SWE4403_UI_TextFields;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import SWE4403_UI_Utilities.SWE4403_PlaceholderFont;
import SWE4403_UI_Utilities.SWE4403_StandardFont;

public class SWE4403_DateTextField extends SWE4403_SensitiveTextField implements FocusListener {

	public SWE4403_DateTextField(String title) {
		super(title);
		addFocusListener(this);
		noFocusText();
	}

	// This check is to add placeholder text
	@Override
	public void focusGained(FocusEvent e) {
		if (getFont() == SWE4403_PlaceholderFont.getInstance()) {
			setText("");
			setForeground(Color.BLACK);
			setFont(SWE4403_StandardFont.getInstance());
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (getText().isBlank()) {
			noFocusText();
		}
	}

	private void noFocusText() {
		setFont(SWE4403_PlaceholderFont.getInstance());
		setForeground(Color.GRAY);
		setText("dd/mm/yyyy");
	}

}
