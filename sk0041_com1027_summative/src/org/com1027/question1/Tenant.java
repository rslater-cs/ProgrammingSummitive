package org.com1027.question1;

import java.util.regex.Pattern;

public class Tenant implements ITenant{
	private String name;
	private String surname;
	private int age;
	private TenantType type;
	
	public Tenant(String name, String surname, int age, TenantType type) {
		if(!Pattern.matches("[A-Z]{1}[a-z]+", name) || !Pattern.matches("[A-Z]{1}[a-z]+", surname) 
				|| age>=150 || type == null) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.type = type;
	}
	
	public int getAge() {
		return this.age;
	}

	@Override
	public TenantType getType() {
		return this.type;
	}
	
	@Override
	public String toString() {
		StringBuffer stringbuf = new StringBuffer();
		stringbuf.append(this.name);
		stringbuf.append(" ");
		stringbuf.append(this.surname);
		stringbuf.append(" is ");
		stringbuf.append(this.age);
		stringbuf.append(" years old and a ");
		String typeInTextForm = "professional";
		if(this.type == TenantType.STUDENT) {
			typeInTextForm = "student";
		}
		stringbuf.append(typeInTextForm);
		return stringbuf.toString();
	}

}
