package org.com1027.question3;

import java.util.ArrayList;
import java.util.List;

public class PropertyManagement {
	private Agency estateAgency = null;
	private List<Property> properties = new ArrayList<Property>();
	
	public PropertyManagement(Agency estateAgency) {
		super();
		this.estateAgency = estateAgency;
	}
	
	public void addProperty(Property property) {
		this.properties.add(property);
	}
	
	public void addTenant(Property property, Room room, Tenant tenant) {
		property.occupyRoom(room, tenant);
	}
	
	public String displayProperties() {
		StringBuffer propertiesString = new StringBuffer();
		for(Property property: properties) {
			propertiesString.append(property.displayOccupiedProperty());
			propertiesString.append("\n");
		}
		return propertiesString.toString();
	}
	
	public String getEstateAgency() {
		StringBuffer agencyString = new StringBuffer();
		agencyString.append("Agency: ");
		agencyString.append(this.estateAgency.getName());
		agencyString.append(", Phone Number: ");
		agencyString.append(this.estateAgency.getPhoneNumber());
		return agencyString.toString();
	}
	
	public void removeProperty(Property property) {
		if(this.properties.contains(property)) {
			this.properties.remove(property);
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	public double percentageCouncilTaxExemption() {
		double amountOfExemptions = 0.0;
		for(Property property: properties) {
			if(property.councilTax == 0) {
				amountOfExemptions++;
			}
		}
		return (amountOfExemptions / this.properties.size())*100;
	}
	
	public String displayAllCouncilTaxExemptProperties() {
		StringBuffer taxExemptString = new StringBuffer();
		for(Property property: properties) {
			if(property.councilTax == 0) {
				taxExemptString.append(property);
				taxExemptString.append("\n");
			}
		}
		return taxExemptString.toString();
	}

}
