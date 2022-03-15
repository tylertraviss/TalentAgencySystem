package UI.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class EditSponsorDialog extends AbstractEditDialog {

	public EditSponsorDialog(JFrame parentFrame) {
		super("Add / Remove Sponsors", "Sponsors", parentFrame);
		setLocationRelativeTo(parentFrame);

		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AddSponsorDialog(self).setVisible(true);
			}
		});

		removeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteSponsorDialog(self).setVisible(true);
			}
		});
	}

}
