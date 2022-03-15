package UI.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class PrintDialog extends AbstractEditDialog {

	public PrintDialog(JFrame parentFrame) {
		super("Print Company Stats", null, parentFrame);

		addButton.setText("To TextFile");
		removeButton.setText("To Console");
		setLocationRelativeTo(parentFrame);

		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// export fucntion to text file
			}
		});

		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// print company stats
			}

		});
	}

}
