package org.com1027.question1;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class House {
	private int houseNumber = 0;
	private String street = null;
	private String city = null;
	private String postCode = null;
	private int numberOfRooms = 0;
	private Map<Room, ITenant> rooms = new HashMap<Room, ITenant>();
	
	public House(int houseNumber, String street, String city, String postCode, int numberOfRooms) {
		super();
		if(this.validateCity(city)&&this.validatePostCode(postCode)) {
			this.houseNumber = houseNumber;
			this.street = street;
			this.city = city;
			this.postCode = postCode;
			this.numberOfRooms = numberOfRooms;
		}else {
			throw new IllegalArgumentException();
		}
	}
	
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
	
	public boolean isAvailable() {
		return (this.getAvailableRooms()>0);
	}
	
	public void occupyRoom(Room room, ITenant tenant) {
		rooms.put(room, tenant);
	}
	
	public String toString() {
		StringBuffer houseString = new StringBuffer();
		houseString.append(this.houseNumber);
		houseString.append(" ");
		houseString.append(this.street);
		houseString.append(", ");
		houseString.append(this.city);
		houseString.append(" ");
		houseString.append(this.postCode);
		houseString.append(" (");
		houseString.append(this.numberOfRooms);
		houseString.append(" bedroom house :");
		houseString.append(this.getAvailableRooms());
		houseString.append(" available)");
		return houseString.toString();
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
