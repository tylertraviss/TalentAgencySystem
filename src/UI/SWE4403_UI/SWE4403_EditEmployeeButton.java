package SWE4403_UI;

import java.awt.event.ActionEvent;

import javax.swing.JDialog;

public class SWE4403_EditEmployeeButton extends SWE4403_Button {

	public SWE4403_EditEmployeeButton(String text) {
		super(text);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog editEmployee = new SWE4403_EditEmployeeDialog();
		editEmployee.setVisible(true);
	}

}
