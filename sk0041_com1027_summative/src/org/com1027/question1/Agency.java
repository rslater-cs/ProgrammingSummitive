package org.com1027.question1;

import java.util.regex.Pattern;

public class Agency {
	private String name = null;
	private String phoneNumber = null;
	
	public Agency(String name, String phoneNumber) {
		super();
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
		StringBuffer agencyString = new StringBuffer();
		agencyString.append("Agency: ");
		agencyString.append(this.name);
		agencyString.append(", Phone Number: ");
		agencyString.append(this.phoneNumber);
		return agencyString.toString();
	}

}
