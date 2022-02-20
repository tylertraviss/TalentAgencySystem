package SWE4403_UI_Buttons;

public class SWE4403_OkButton extends SWE4403_Button {

	private String type;

	public SWE4403_OkButton(String text, String type) {
		super(text);
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
