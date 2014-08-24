package controller;


import static org.junit.Assert.*;
import model.battlefield.BattleField;
import model.units.Unit;

import org.junit.Test;

public class MouseActionsTest {

	@Test
	public void testAddUnit() {
		//Given
		BattleField bf = new BattleField();
		MouseActions SUT = new MouseActions();
		int[]XY={300,200};
		//When
		assertTrue(bf.unitList.isEmpty());
		SUT.addUnit(bf,XY);
		
		//Then
		System.out.println("unit list has: " +bf.unitList.size()+" unit: " +bf.unitList.get(0).getType());
		assertFalse(bf.unitList.isEmpty());
		
		
	
	
	
	}

}
