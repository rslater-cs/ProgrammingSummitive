package org.com1027.question4optional;

public class House extends Property{

	public House(int number, String street, String city, String postCode, int numberOfRooms) {
		super(number, street, city, postCode, numberOfRooms);
	}

	@Override
	public boolean isAvailable() {
		return (this.getAvailableRooms()>0);
	}

	@Override
	public void occupyRoom(Room room, ITenant tenant) {
		if(!this.rooms.keySet().contains(room)) {
			this.rooms.put(room, tenant);
		}
	}

	@Override
	public String displayOccupiedProperty() {
		double totalPrice = 0.0;
		StringBuffer occupiedPropertiesString = new StringBuffer();
		occupiedPropertiesString.append(super.toString());
		occupiedPropertiesString.append("house: ");
		occupiedPropertiesString.append(this.getAvailableRooms());
		occupiedPropertiesString.append(" available)\n");
		for(Room room: this.rooms.keySet()) {
			occupiedPropertiesString.append("Room: ");
			occupiedPropertiesString.append(room.getPrice());
			occupiedPropertiesString.append("\n");
			totalPrice += room.getPrice();
		}
		totalPrice *= 12;
		occupiedPropertiesString.append("Total: £");
		occupiedPropertiesString.append(totalPrice);
		return occupiedPropertiesString.toString();
	}
	
	public String toString() {
		StringBuffer houseString = new StringBuffer();
		houseString.append(super.toString());
		houseString.append("house :");
		houseString.append(this.getAvailableRooms());
		houseString.append(" available)");
		return houseString.toString();
	}

}
