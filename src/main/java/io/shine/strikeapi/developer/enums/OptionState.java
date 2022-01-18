package io.shine.strikeapi.developer.enums;

public enum OptionState {
	
	DISABLE(0),
	ONLY_FRIENDS(1),
	ENABLE(2);
	
	private int state;
	
	private OptionState(int state) {
		this.state = state;
	}
	
	public int getState() {
		return state;
	}

}
