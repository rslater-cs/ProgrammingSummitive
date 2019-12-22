package org.com1027.question3;

import java.util.regex.Pattern;

public class Tenant implements ITenant{
	private String name = null;
	private String surname = null;
	private int age = 0;
	private TenantType type = null;
	
	public Tenant(String name, String surname, int age, TenantType type) {
		super();
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
		StringBuffer tenantString = new StringBuffer();
		tenantString.append(this.name);
		tenantString.append(" ");
		tenantString.append(this.surname);
		tenantString.append(" is ");
		tenantString.append(this.age);
		tenantString.append(" years old and a ");
		String typeInTextForm = "professional";
		if(this.type == TenantType.STUDENT) {
			typeInTextForm = "student";
		}
		tenantString.append(typeInTextForm);
		return tenantString.toString();
	}

}
