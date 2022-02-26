package SWE4403_UI_TextFields;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import SWE4403_Font.SWE4403_PlaceholderFont;
import SWE4403_Font.SWE4403_StandardFont;
import SWE4403_UI_Utilities.SWE4403_TextFieldHandler;
import SWE4403_UI_Utilities.SWE4403_TitledBorder;

public abstract class SWE4403_TextField extends JTextField implements ActionListener, FocusListener {

	private SWE4403_TextFieldHandler tfHandler = SWE4403_TextFieldHandler.getInstance();
	private String placeholder;
	private boolean displayPlaceholder;

	public SWE4403_TextField(String title, String placeholder) {
		this.placeholder = placeholder;
		this.displayPlaceholder = placeholder == null ? false : true;
		if (displayPlaceholder)
			this.setFont(SWE4403_PlaceholderFont.getInstance());
		else
			this.setFont(SWE4403_StandardFont.getInstance());
		this.setOpaque(false);
		this.setBorder(new SWE4403_TitledBorder(title));
		addActionListener(this);
		addFocusListener(this);
		setDefaultText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tfHandler.handleTextField(this);
	}

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
		if (getText().isBlank() && displayPlaceholder) {
			setFont(SWE4403_PlaceholderFont.getInstance());
			setDefaultText();
		}
	}

	private void setDefaultText() {
		setText(placeholder);
	}
}
