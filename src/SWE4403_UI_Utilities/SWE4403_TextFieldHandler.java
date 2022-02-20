package SWE4403_UI_Utilities;

import javax.swing.JTextField;

import SWE4403_UI_Components.SWE4403_ConsoleTextArea;

public class SWE4403_TextFieldHandler {

	private static SWE4403_TextFieldHandler instance = null;

	private SWE4403_ConsoleTextArea console;

	private SWE4403_TextFieldHandler() {
		console = SWE4403_ConsoleTextArea.getInstance();
	}

	public static SWE4403_TextFieldHandler getInstance() {
		if (instance == null)
			instance = new SWE4403_TextFieldHandler();

		return instance;
	}

	// for normal text field
	public void handleTextField(JTextField tf) {
	}

	// for sensitive text field
	// when the classes are crated we can just use the converted values from here
	// and input them
	public boolean handleTextField(JTextField tf, String type) {
		String tfContent = tf.getText();

		boolean toReturn = true;
		String temp[] = tfContent.split("/");

		// types = date (date format), wage (double)
		switch (type) {
			case "End Date":
				// first check if the length is correct
				if (temp.length != 3)
					toReturn = false;

				// check if each number is a valid number
				try {
					int day, month;
					day = Integer.parseInt(temp[0]);
					month = Integer.parseInt(temp[1]);

					if (day > 31 || day <= 0 || month > 12 || month <= 0)
						toReturn = false;
				} catch (NumberFormatException e1) {
					toReturn = false;
				}
				if (!toReturn)
					console.log("Invalid  end date input");

				return toReturn;

			case "Start Date":
				// first check if the length is correct
				if (temp.length != 3)
					toReturn = false;

				// check if each number is a valid number
				try {

					int day, month;

					day = Integer.parseInt(temp[0]);
					month = Integer.parseInt(temp[1]);

					if (day > 31 || day <= 0 || month > 12 || month <= 0)
						toReturn = false;

				} catch (NumberFormatException e1) {
					toReturn = false;
				}

				if (!toReturn)
					console.log("Invalid start date input");

				return toReturn;

			case "Wage":
				// check if its a valid number
				try {
					double wage = Double.parseDouble(tfContent);
				} catch (NumberFormatException e1) {
					toReturn = false;
				}

				if (!toReturn)
					console.log("Invalid wage input");

				return toReturn;

			default:
				console.log("Unknown text field from " + tf.getClass().getCanonicalName());
				return false;
		}

	}
}
