package org.com1027.question4optional;

public class Flat extends Property {
	private int floor = 0;

	public Flat(int number, String street, String city, String postCode, int numberOfRooms, int floor) {
		super(number, street, city, postCode, numberOfRooms);
		this.floor = floor;
	}

	@Override
	public boolean isAvailable() {
		return (this.getAvailableRooms()>0);
	}

	@Override
	public void occupyRoom(Room room, ITenant tenant) {
		if(this.rooms.keySet().contains(room)) {
			throw new IllegalArgumentException();
		}
		rooms.put(room, tenant);
	}

	@Override
	public String displayOccupiedProperty() {
		double totalPrice = 0.0;
		StringBuffer occupiedPropertiesString = new StringBuffer();
		occupiedPropertiesString.append(super.toString());
		occupiedPropertiesString.append("flat on ");
		occupiedPropertiesString.append(this.floor);
		occupiedPropertiesString.append(" floor :");
		occupiedPropertiesString.append(this.getAvailableRooms());
		occupiedPropertiesString.append(" available)");
		if(this.getAvailableRooms() == 0) {
			for(Room room: this.rooms.keySet()) {
				occupiedPropertiesString.append("\n\tRoom: ");
				occupiedPropertiesString.append(room.getPrice());
				totalPrice += room.getPrice();
			}
			totalPrice = (totalPrice * 12) + 500;
			occupiedPropertiesString.append("\n\tTotal: £");
			occupiedPropertiesString.append(this.totalFormat.format(totalPrice));
			occupiedPropertiesString.append(" (Council Tax: £");
			occupiedPropertiesString.append(this.councilTax);
			occupiedPropertiesString.append(")");
		}
		return occupiedPropertiesString.toString();
	}
	
	@Override
	public String toString() {
		StringBuffer flatString = new StringBuffer();
		flatString.append(super.toString());
		flatString.append("flat on ");
		flatString.append(this.floor);
		flatString.append(" floor :");
		flatString.append(this.getAvailableRooms());
		flatString.append(" available)");
		return flatString.toString();
	}

}
