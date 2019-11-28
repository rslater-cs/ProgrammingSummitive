package org.com1027.question2;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class House {
	private int houseNumber;
	private String street;
	private String city;
	private String postCode;
	private int numberOfRooms;
	private Map<Room, ITenant> rooms = new HashMap<Room, ITenant>();
	
	public House(int houseNumber, String street, String city, String postCode, int numberOfRooms) {
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
		if(this.getAvailableRooms()>0) { 
			return true;
		}
		return false;
	}
	
	public void occupyRoom(Room room, ITenant tenant) {
		rooms.put(room, tenant);
	}
	
	public String toString() {
		StringBuffer stringbuf = new StringBuffer();
		stringbuf.append(this.houseNumber);
		stringbuf.append(" ");
		stringbuf.append(this.street);
		stringbuf.append(", ");
		stringbuf.append(this.city);
		stringbuf.append(" ");
		stringbuf.append(this.postCode);
		stringbuf.append(" (");
		stringbuf.append(this.numberOfRooms);
		stringbuf.append(" bedroom house :");
		stringbuf.append(this.getAvailableRooms());
		stringbuf.append(" available)");
		return stringbuf.toString();
	}
	
	private boolean validateCity(String city) {
		Pattern cityPattern = Pattern.compile("[A-Z]{1}[a-z]+");
		return cityPattern.matcher(city).matches();
	}
	
	private boolean validatePostCode(String postCode) {
		postCode = postCode.toUpperCase().replaceAll(" ", "");
		Pattern postPattern = Pattern.compile("[A-Z]{2}[0-9]{2,3}[A-Z]{2}");
		return postPattern.matcher(postCode).matches();
	}
}
