package org.com1027.question2;

import java.util.regex.Pattern;

public class Agency {
	private String name;
	private String phoneNumber;
	
	public Agency(String name, String phoneNumber) {
		if(!Pattern.matches("([A-Z]{1}[a-z]+ ?)+", name) || !Pattern.matches("[0-9]{5} [0-9]{6}", phoneNumber)) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public String toString() {
		StringBuffer stringbuf = new StringBuffer();
		stringbuf.append("Agency: ");
		stringbuf.append(this.name);
		stringbuf.append(", Phone Number: ");
		stringbuf.append(this.phoneNumber);
		return stringbuf.toString();
	}

}
