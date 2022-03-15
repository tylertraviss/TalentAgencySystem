package UI.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class EditClientDialog extends AbstractEditDialog {

	public EditClientDialog(JFrame parentFrame) {
		super("Add / Remove Client", "Client", parentFrame);
		setLocationRelativeTo(parentFrame);

		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddClientDialog(self).setVisible(true);
			}

		});

		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteClientDialog(self).setVisible(true);
			}
		});
	}
}
