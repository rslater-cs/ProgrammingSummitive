package org.com1027.question2;

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
		occupiedPropertiesString.append(" floor: ");
		occupiedPropertiesString.append(this.getAvailableRooms());
		occupiedPropertiesString.append(" available)\n");
		for(Room room: this.rooms.keySet()) {
			occupiedPropertiesString.append("Room: ");
			occupiedPropertiesString.append(room.getPrice());
			occupiedPropertiesString.append("\n");
		}
		totalPrice = (totalPrice * 12) + 500;
		occupiedPropertiesString.append("Total: �");
		occupiedPropertiesString.append(totalPrice);
		return occupiedPropertiesString.toString();
	}
	
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
