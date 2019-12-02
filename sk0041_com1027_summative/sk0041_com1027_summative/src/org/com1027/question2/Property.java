package org.com1027.question2;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class Property {
	private int number = 0;
	private String street = null;
	private String city = null;
	private String postCode = null;
	private int numberOfRooms = 0;
	protected Map<Room, ITenant> rooms = new HashMap<Room, ITenant>();
	
	public Property(int number, String street, String city, String postCode, int numberOfRooms) {
		super();
		if(this.validateCity(city)&&this.validatePostCode(postCode)) {
			this.number = number;
			this.street = street;
			this.city = city;
			this.postCode = postCode;
			this.numberOfRooms = numberOfRooms;
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	public abstract boolean isAvailable();
	
	public abstract void occupyRoom(Room room, ITenant tenant);
	
	public abstract String displayOccupiedProperty();
	
	public int getAvailableRooms() {
		return numberOfRooms - rooms.keySet().size();
	}
	
	public double getPrice() {
		double price = 0;
		for(Room room: rooms.keySet()) {
			price += room.getPrice();
		}
		return price;
	}
	
	public String toString() {
		StringBuffer propertyString = new StringBuffer();
		propertyString.append(this.number);
		propertyString.append(" ");
		propertyString.append(this.street);
		propertyString.append(", ");
		propertyString.append(this.city);
		propertyString.append(" ");
		propertyString.append(this.postCode);
		propertyString.append(" (");
		propertyString.append(this.numberOfRooms);
		propertyString.append(" bedroom ");
		return propertyString.toString();
	}
	
	private boolean validateCity(String city) {
		Pattern cityPattern = Pattern.compile("[A-Z]{1}[a-z]+");
		return cityPattern.matcher(city).matches();
	}
	
	private boolean validatePostCode(String postCode) {
		Pattern postPattern = Pattern.compile("[A-Z]{2}[0-9]{1,2} [0-9]{1}[A-Z]{2}");
		return postPattern.matcher(postCode).matches();
	}
}
