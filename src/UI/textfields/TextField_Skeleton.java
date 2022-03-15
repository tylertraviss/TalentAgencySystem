package UI.textfields;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import UI.borders.CustomTitledBorder;
import UI.fonts.PlaceholderFont;
import UI.fonts.StandardFont;

public class TextField_Skeleton extends JTextField implements FocusListener {

	private String placeholder;
	private boolean displayPlaceholder;

	public TextField_Skeleton(String title, String placeholder) {
		this.placeholder = placeholder;
		this.displayPlaceholder = placeholder == null ? false : true;
		if (displayPlaceholder)
			this.setFont(PlaceholderFont.getInstance());
		else
			this.setFont(StandardFont.getInstance());
		this.setOpaque(false);
		this.setBorder(new CustomTitledBorder(title));
		addFocusListener(this);
		setDefaultText();
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (getFont() == PlaceholderFont.getInstance()) {
			setText("");
			setForeground(Color.BLACK);
			setFont(StandardFont.getInstance());
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (getText().isBlank() && displayPlaceholder) {
			setFont(PlaceholderFont.getInstance());
			setDefaultText();
		}
	}

	private void setDefaultText() {
		setText(placeholder);
	}
}
