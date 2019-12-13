package org.com1027.question4optional;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
				taxExemptString.append(property.toString());
				taxExemptString.append("\n");
			}
		}
		return taxExemptString.toString();
	}
	
	public String displayAgePriceInfo() {
		final String[] bounds = new String[]{"0-15 ", "16-25", "26-35", "36-45", "46-55", "55+  "};
		final Double[] averagePrices = new Double[] {0.0,0.0,0.0,0.0,0.0,0.0};
		final int[] agesInBounds = new int[] {0,0,0,0,0,0};
		
		for(Property property: properties) {
			for(ITenant tenant: property.rooms.values()) {
				for(Room room: property.rooms.keySet()) {
					if(((Tenant)tenant).getAge() < 16) {
						averagePrices[0] += room.getPrice();
						agesInBounds[0]++;
					}else if((((Tenant)tenant).getAge()-15) < 10) {
						averagePrices[1] += room.getPrice();
						agesInBounds[1]++;
					}else if((((Tenant)tenant).getAge()-25) < 10) {
						averagePrices[2] += room.getPrice();
						agesInBounds[2]++;
					}else if((((Tenant)tenant).getAge()-35) < 10) {
						averagePrices[3] += room.getPrice();
						agesInBounds[3]++;
					}else if((((Tenant)tenant).getAge()-45) < 10) {
						averagePrices[4] += room.getPrice();
						agesInBounds[4]++;
					}else{
						averagePrices[5] += room.getPrice();
						agesInBounds[5]++;
					}
				}
			}
		}
		
		final StringBuffer ageDisplay = new StringBuffer();
		ageDisplay.append("Age to Average Price:\n");
		
		for(int x = 0; x<6; x++) {
			if(averagePrices[x] != null) {
				averagePrices[x] /= (agesInBounds[x]*100);
				ageDisplay.append("\t");
				ageDisplay.append(bounds[x]);
				ageDisplay.append("|");
				for(int i = 0; i<averagePrices[x]; i++) {
					ageDisplay.append("-");
				}
				ageDisplay.append("\n");
			}
		}
		
		try {
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter("AgeToRoomPriceHistograms.txt", true));
			fileWriter.append(ageDisplay);
			fileWriter.close();
		}catch(Exception e) {
			ageDisplay.append(e);
		}
		
		return ageDisplay.toString();            
	}

}
