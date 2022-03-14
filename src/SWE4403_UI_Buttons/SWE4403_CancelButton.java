package SWE4403_UI_Buttons;

public class SWE4403_CancelButton extends SWE4403_Button {

	private String type;

	public SWE4403_CancelButton(String text, String type) {
		super(text);
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
