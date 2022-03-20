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
		var fontToUse = (displayPlaceholder) ? PlaceholderFont.getInstance() : StandardFont.getInstance();
		
		this.setFont(fontToUse);
		this.setOpaque(false);

		var customTitledBorder = new CustomTitledBorder(title);

		this.setBorder(customTitledBorder);
		addFocusListener(this);
		setDefaultText();
	}

	@Override
	public void focusGained(FocusEvent e) {

		var placeholderFont = PlaceholderFont.getInstance();
		var standardFont = StandardFont.getInstance();

		if (getFont() == placeholderFont) {
			setText("");
			setForeground(Color.BLACK);
			setFont(standardFont);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (getText().isBlank() && displayPlaceholder) {

			var placeholderFont = PlaceholderFont.getInstance();

			setFont(placeholderFont);
			setDefaultText();
		}
	}

	private void setDefaultText() {
		setText(placeholder);
	}
}
