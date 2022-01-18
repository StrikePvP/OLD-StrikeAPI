package io.shine.strikeapi.developer;

import io.shine.strikeapi.developer.enums.OptionState;

public class OptionAPI {
	
	public static OptionState getStateFromInt(int s) {
		for(OptionState ops : OptionState.values()) {
			if(s == ops.getState()) {
				return ops;
			}
			continue;
		}
		return OptionState.ENABLE;
	}
	
	

}
