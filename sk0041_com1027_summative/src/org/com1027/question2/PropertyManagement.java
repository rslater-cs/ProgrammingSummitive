package org.com1027.question2;

import java.util.ArrayList;
import java.util.List;

public class PropertyManagement {
	private Agency estateAgency;
	private List<House> properties = new ArrayList<House>();
	
	public PropertyManagement(Agency estateAgency) {
		this.estateAgency = estateAgency;
	}
	
	public void addProperty(House property) {
		this.properties.add(property);
	}
	
	public void addTenant(House property, Room room, Tenant tenant) {
		property.occupyRoom(room, tenant);
	}
	
	public String displayProperties() {
		StringBuffer stringbuf = new StringBuffer();
		for(House property: properties) {
			stringbuf.append(property.toString());
			stringbuf.append("\n");
		}
		return stringbuf.toString();
	}
	
	public String getEstateAgency() {
		StringBuffer stringbuf = new StringBuffer();
		stringbuf.append("Agency: ");
		stringbuf.append(this.estateAgency.getName());
		stringbuf.append(", Phone Number: ");
		stringbuf.append(this.estateAgency.getPhoneNumber());
		return stringbuf.toString();
	}
	
	public void removeProperty(House property) {
		if(this.properties.contains(property)) {
			this.properties.remove(property);
		}else {
			throw new IllegalArgumentException();
		}
	}

}
