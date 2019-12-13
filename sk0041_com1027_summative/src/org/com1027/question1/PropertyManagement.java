package org.com1027.question1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Ryan Slater
 * @version 1
 * @since 31/11/19
 * 
 * Property Management controls multiple houses by allowing houses to be added, booked and removed along with
 * displaying property details and agency details 
 *
 */
public class PropertyManagement {
	/**
	 * Declare and initialise estate agency to be null by default
	 */
	private Agency estateAgency = null;
	/**
	 * Declare an empty list of houses
	 */
	private List<House> properties = new ArrayList<House>();
	
	/**
	 * @param estateAgency
	 * change agency from null to parameter agency
	 */
	public PropertyManagement(Agency estateAgency) {
		super();
		this.estateAgency = estateAgency;
	}
	
	/**
	 * @param property
	 * Adds a house to the list of houses
	 */
	public void addProperty(House property) {
		this.properties.add(property);
	}
	
	/**
	 * @param property
	 * @param room
	 * @param tenant
	 * For the selected house a tenant is mapped to a room through the house class
	 */
	public void addTenant(House property, Room room, Tenant tenant) {
		property.occupyRoom(room, tenant);
	}
	
	/**
	 * @return StringBuffer
	 * Loops through every house in properties and appends it to a string buffer then returns the result
	 */
	public String displayProperties() {
		StringBuffer propertiesString = new StringBuffer();
		/**
		 * Run through every house to append it to the string buffer
		 */
		for(House property: properties) {
			propertiesString.append(property.toString());
			propertiesString.append("\n");
		}
		return propertiesString.toString();
	}
	
	/**
	 * @return StringBuffer
	 * Appends agency name and phone number to a string buffer and returns the result
	 */
	public String getEstateAgency() {
		StringBuffer agencyString = new StringBuffer();
		agencyString.append("Agency: ");
		agencyString.append(this.estateAgency.getName());
		agencyString.append(", Phone Number: ");
		agencyString.append(this.estateAgency.getPhoneNumber());
		return agencyString.toString();
	}
	
	/**
	 * @param property
	 * If selected house exists in properties then remove that house from the list
	 * If house does not exist in list then throw an illegal argument exception as program has passed invalid house 
	 */
	public void removeProperty(House property) {
		if(this.properties.contains(property)) {
			this.properties.remove(property);
		}else {
			throw new IllegalArgumentException();
		}
	}
}
