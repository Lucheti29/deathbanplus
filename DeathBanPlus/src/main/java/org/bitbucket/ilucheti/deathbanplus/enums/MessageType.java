package org.bitbucket.ilucheti.deathbanplus.enums;

public enum MessageType 
{
	BANNED("banned");
	
	private String mValue;
	
	MessageType(String value) {
		mValue = value;
	}
	
	public String getValue() {
		return mValue;
	}
}
