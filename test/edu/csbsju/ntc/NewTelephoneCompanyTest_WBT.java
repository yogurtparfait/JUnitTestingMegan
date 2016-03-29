package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NewTelephoneCompanyTest_WBT {
	private NewTelephoneCompany comp;
	
	@Before
	public void setup(){
		comp = new NewTelephoneCompany();
	}
	
	//path 1 invalid start tiem
	@Test(expected=UnsupportedOperationException.class)
	public void invalidStart1(){
		comp.setStartTime(-5);
		comp.setDuration(10);
		comp.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void invalidStart2(){
		comp.setStartTime(-1);
		comp.setDuration(10);
		comp.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void invalidStart3(){
		comp.setStartTime(2544);
		comp.setDuration(10);
		comp.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void invalidStart4(){
		comp.setStartTime(2400);
		comp.setDuration(10);
		comp.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void invalidStart5(){
		comp.setStartTime(2401);
		comp.setDuration(10);
		comp.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void invalidStart6(){
		comp.setStartTime(1578);
		comp.setDuration(10);
		comp.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void invalidStart7(){
		comp.setStartTime(1160);
		comp.setDuration(10);
		comp.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void invalidStart8(){
		comp.setStartTime(1161);
		comp.setDuration(10);
		comp.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void invalidStart9(){
		comp.setStartTime(799);
		comp.setDuration(-5);
		comp.computeCharge();
	}
	
	//path 2 invalid duration
	
	@Test(expected=UnsupportedOperationException.class)
	public void invalidDuration1(){
		comp.setStartTime(1800);
		comp.setDuration(0);
		comp.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void invalidDuration2(){
		comp.setStartTime(1801);
		comp.setDuration(-1);
		comp.computeCharge();
	}

	//path 3 Discounted Starttime & discounted duration
	
	@Test
	public void discountedStartAndDuration(){
		double expResult;
		expResult = 1768.0;
		comp.setStartTime(500);
		comp.setDuration(100);
		assertTrue("A call starting at " + comp.getStartTime() + " for a duration of " + comp.getDuration() + " Should be "+ expResult + " But is " + comp.computeCharge(), expResult == comp.computeCharge());
		
		expResult =1078.48;
		comp.setStartTime(759);
		comp.setDuration(61);
		assertTrue("A call starting at " + comp.getStartTime() + " for a duration of " + comp.getDuration() + " Should be "+ expResult + " But is " + comp.computeCharge(), expResult == comp.computeCharge());
		
		expResult = 1078.48;
		comp.setStartTime(1959);
		comp.setDuration(61);
		assertTrue("A call starting at " + comp.getStartTime() + " for a duration of " + comp.getDuration() + " Should be "+ expResult + " But is " + comp.computeCharge(), expResult == comp.computeCharge());
		
		expResult = 1149.20;
		comp.setStartTime(2359);
		comp.setDuration(65);
		assertTrue("A call starting at " + comp.getStartTime() + " for a duration of " + comp.getDuration() + " Should be "+ expResult + " But is " + comp.computeCharge(), expResult == comp.computeCharge());

	}
	
	//path 4 Discounted Starttime only
	@Test
	public void discountedStart(){
		double expResult;
		expResult = 1248.0;
		comp.setStartTime(0);
		comp.setDuration(60);
		assertTrue("A call starting at " + comp.getStartTime() + " for a duration of " + comp.getDuration() + " Should be "+ expResult + " But is " + comp.computeCharge(), expResult == comp.computeCharge());
		
		expResult = 1227.20;
		comp.setStartTime(400);
		comp.setDuration(59);
		assertTrue("A call starting at " + comp.getStartTime() + " for a duration of " + comp.getDuration() + " Should be "+ expResult + " But is " + comp.computeCharge(), expResult == comp.computeCharge());
		
		expResult = 20.80;
		comp.setStartTime(759);
		comp.setDuration(1);
		assertTrue("A call starting at " + comp.getStartTime() + " for a duration of " + comp.getDuration() + " Should be "+ expResult + " But is " + comp.computeCharge(), expResult == comp.computeCharge());
		
		//the next three are listed with expResult = 208.8 in the worksheet but this should be 208.0
		expResult = 208.0;
		comp.setStartTime(1800);
		comp.setDuration(10);
		assertTrue("A call starting at " + comp.getStartTime() + " for a duration of " + comp.getDuration() + " Should be "+ expResult + " But is " + comp.computeCharge(), expResult == comp.computeCharge());
		
		expResult = 208.0;
		comp.setStartTime(1801);
		comp.setDuration(10);
		assertTrue("A call starting at " + comp.getStartTime() + " for a duration of " + comp.getDuration() + " Should be "+ expResult + " But is " + comp.computeCharge(), expResult == comp.computeCharge());
		
		expResult = 208.0;
		comp.setStartTime(2359);
		comp.setDuration(10);
		assertTrue("A call starting at " + comp.getStartTime() + " for a duration of " + comp.getDuration() + " Should be "+ expResult + " But is " + comp.computeCharge(), expResult == comp.computeCharge());
	}
	
	//path 5 Discounted Duration Only
	@Test
	public void discountedDuration(){
		double expResult;
		expResult = 2298.40;
		comp.setStartTime(800);
		comp.setDuration(65);
		assertTrue("A call starting at " + comp.getStartTime() + " for a duration of " + comp.getDuration() + " Should be "+ expResult + " But is " + comp.computeCharge(), expResult == comp.computeCharge());
		
		expResult = 2156.96;
		comp.setStartTime(900);
		comp.setDuration(61);
		assertTrue("A call starting at " + comp.getStartTime() + " for a duration of " + comp.getDuration() + " Should be "+ expResult + " But is " + comp.computeCharge(), expResult == comp.computeCharge());
	}
	
	//path 6 no discounts
	@Test
	public void noDiscount(){
		double expResult;
		expResult = 1664.00;
		comp.setStartTime(1000);
		comp.setDuration(40);
		assertTrue("A call starting at " + comp.getStartTime() + " for a duration of " + comp.getDuration() + " Should be "+ expResult + " But is " + comp.computeCharge(), expResult == comp.computeCharge());
		
		expResult = 41.60;
		comp.setStartTime(800);
		comp.setDuration(1);
		assertTrue("A call starting at " + comp.getStartTime() + " for a duration of " + comp.getDuration() + " Should be "+ expResult + " But is " + comp.computeCharge(), expResult == comp.computeCharge());
		
		expResult = 2454.40;
		comp.setStartTime(801);
		comp.setDuration(59);
		assertTrue("A call starting at " + comp.getStartTime() + " for a duration of " + comp.getDuration() + " Should be "+ expResult + " But is " + comp.computeCharge(), expResult == comp.computeCharge());
		
		expResult = 2496.00;
		comp.setStartTime(1759);
		comp.setDuration(60);
		assertTrue("A call starting at " + comp.getStartTime() + " for a duration of " + comp.getDuration() + " Should be "+ expResult + " But is " + comp.computeCharge(), expResult == comp.computeCharge());
	}
}
