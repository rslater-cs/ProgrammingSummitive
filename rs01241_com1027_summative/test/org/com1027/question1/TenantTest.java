package org.com1027.question1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TenantTest {
	
	@Test
	public void testToString() {
		Tenant tenant = new Tenant("Ryan", "Slater", 18, TenantType.STUDENT);
		assertEquals("Ryan Slater", tenant.toString());
	}
	
	@Test
	public void secondTestToString() {
		Tenant tenant = new Tenant("Michael", "Smith", 24, TenantType.PROFESSIONAL);
		assertEquals("Michael Smith", tenant.toString());
	}
	
	@Test
	public void testGetAge() {
		Tenant tenant = new Tenant("Ryan", "Slater", 18, TenantType.STUDENT);
		assertEquals(18, tenant.getAge());
	}
	
	@Test
	public void testGetType() {
		Tenant tenant = new Tenant("Ryan", "Slater", 18, TenantType.STUDENT);
		assertEquals(TenantType.STUDENT, tenant.getType());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNameValid() {
		Tenant tenant = new Tenant("ryan", "Slater", 18, TenantType.STUDENT);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSurnameValid() {
		Tenant tenant = new Tenant("Ryan", "slater", 18, TenantType.STUDENT);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAgeValid() {
		Tenant tenant = new Tenant("Ryan", "Slater", 180, TenantType.STUDENT);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTypeValid() {
		Tenant tenant = new Tenant("Ryan", "Slater", 18, null);
	}

}
