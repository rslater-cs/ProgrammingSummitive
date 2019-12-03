package org.com1027.question4optional;

public class main {

	public static void main(String[] args) {
		Agency estate = new Agency("Real Agency", "12345 123456");
		
		PropertyManagement pm = new PropertyManagement(estate);

		Property house1 = new House(1, "Percy Road", "Guildford", "GU2 7XH", 1);
		Property house2 = new House(1, "The Chase", "Guildford", "GU2 7UB", 1);
		Property flat1 = new Flat(1, "Andrew Road", "Guildford", "GU2 7XH", 1, 1);
		Property flat2 = new Flat(1, "Andrew Road", "Guildford", "GU2 7XH", 1, 2);
		Property flat3 = new Flat(1, "Woodland Lane", "Guildford", "GU2 3WW", 1, 1);

		Room room1 = new Room(1500);
		Room room2 = new Room(1000);
		Room room3 = new Room(200);
		Room room4 = new Room(500);
		Room room5 = new Room(440);
		

		Tenant tenant1 = new Tenant("Alice", "Wonderland", 18, TenantType.STUDENT);
		Tenant tenant2 = new Tenant("Real", "Student", 26, TenantType.STUDENT);
		Tenant tenant3 = new Tenant("Real", "Person", 27, TenantType.PROFESSIONAL);
		Tenant tenant4 = new Tenant("Fake", "Person", 35, TenantType.PROFESSIONAL);
		Tenant tenant5 = new Tenant("Actual", "Person", 50, TenantType.PROFESSIONAL);


		pm.addProperty(house1);
		pm.addProperty(house2);
		pm.addProperty(flat1);
		pm.addProperty(flat2);
		pm.addProperty(flat3);

		pm.addTenant(house1, room1, tenant1);
		pm.addTenant(house2, room2, tenant2);
		pm.addTenant(flat1, room3, tenant3);
		pm.addTenant(flat2, room4, tenant4);
		pm.addTenant(flat3, room5, tenant5);
		
		System.out.println(pm.displayAgePriceInfo());
		
	}

}

/*
1 Percy Road, Guildford GU2 7XH (1 bedroom house :0 available)\n\tRoom: 900.0\n\tTotal: £10800.00 (Council Tax: £0.0)\n
1 The Chase, Guildford GU2 7UB (1 bedroom house :0 available)\n\tRoom: 900.0\n\tTotal: £10800.00 (Council Tax: £0.0)\n
1 Andrew Road, Guildford GU2 7XH (1 bedroom flat on 1 floor :0 available)\n\tRoom: 900.0\n\tTotal: £11300.00 (Council Tax: £0.0)\n
1 Andrew Road, Guildford GU2 7XH (1 bedroom flat on 2 floor :0 available)\n\tRoom: 900.0\n\tTotal: £11300.00 (Council Tax: £0.0)\n
1 Woodland Lane, Guildford GU2 3WW (1 bedroom flat on 1 floor :0 available)\n\tRoom: 900.0\n\tTotal: £11300.00 (Council Tax: £0.0)\n


*/
