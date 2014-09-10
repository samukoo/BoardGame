package model.battlefield;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import model.units.Tank;
import model.units.Unit;

import org.junit.Before;
import org.junit.Test;


public class TestField {
	private Field testField;
	
	@Before
	public void setUp() throws Exception {
		testField = new Field();
	}

	@Test
	public void test_OrderToField() {
		//Given data
		String unit = "Tank";
		
		Tank tank = mock(Tank.class);
		when(tank.getType()).thenReturn(unit);
		//When order to field
		List<Unit> res = testField.orderToField(tank);
		//Then unit is deployed
		assertEquals(unit, res.get(0).getType());
	}

	@Test
	public void test_selectUnit(){
		/*
		List list = new LinkedList();
		2	List spy = spy(list);
		3	 
		4	//Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
		5	when(spy.get(0)).thenReturn("foo");
		6	 
		7	//You have to use doReturn() for stubbing
		8	doReturn("foo").when(spy).get(0);
		*/
		//Given test data
		int targetHex[]={3,3};
		int tankHex[]={3,2};
		Tank tank = new Tank("foo");
		tank.setXyHex(targetHex);
		testField.orderToField(tank);
		
		//When hex with unit is selected
		Unit res = testField.selectUnit(targetHex);
		
		//Then result should be like
		assertNotNull(res);
		assertEquals("Tank", res.getType());
		assertEquals("foo", res.getOwner());
	}

	@Test
	public void test_selectUnit_NO_UNIT(){
		//Given test data
		int targetHex[]={3,3};
		int tankHex[]={3,2};
		Tank tank = new Tank("foo");
		tank.setXyHex(tankHex);  	//tank hex has different coordination than clicked hex
		testField.orderToField(tank);
		
		//When hex without unit is selected
		Unit res = testField.selectUnit(targetHex);
		
		//Then result should be like NULL
		assertNull(res);
	}
	
	
}
