package model.battlefield.tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import model.battlefield.BattleField;
import model.units.Infantry;
import model.units.Tank;

import org.junit.Test;

public class BattleFieldTest {

	@Test
	public void testAddUnit() {
		//Given
		BattleField SUT = new BattleField();
		//When
		int[]mockInt={10,10};
		SUT.unitList.add(new Tank(mockInt, mockInt));
		String res = SUT.unitList.get(0).getType();
		//Then
		assertEquals("List should contain Tank","Tank", res);
	}

	@Test
	public void testMoveUnitCantEnterSea() {
		//given
		BattleField aBf = spy(new BattleField());
		when(aBf.getWorldType(0, 0)).thenReturn("s");
		//when
		String res = aBf.moveUnit(0, 0);
		//then
		assertEquals("Unit should not move into sea","Hexaan ei voi liikkua" ,res);
	}

	@Test
	public void testUnitCantEnterTooFar(){
		//given 
		BattleField aBf = spy(new BattleField());
		when(aBf.getWorldType(0, 0)).thenReturn("f");
	//	when(aBf.isNextHex(0, 0)).thenReturn(false);
		//when
		String res = aBf.moveUnit(0, 0);
		//then
		assertEquals("Unit cant move too far","Hexaan ei voi liikkua",res);
	}
	
	@Test
	public void testMoveUnitToLand(){
		//given
		BattleField aMock = spy(new BattleField());
		int[]mockInt={10,10};
		aMock.unitList.add(new Tank(mockInt,mockInt));
		when(aMock.getWorldType(0, 0)).thenReturn("f");
		when(aMock.isNextHex(0, 0)).thenReturn(true);
		//when
		String res = aMock.moveUnit(0, 0);
		//then
		assertEquals("Unit Can move to land","ok" ,res);	
	}
	
	@Test
	public void testIsNotNextHex(){
		//kova koodattu 3,3 starthex
		BattleField SUT = new BattleField();
		boolean res = SUT.isNextHex(4, 1);
		assertFalse(res);
	}
	
	@Test
	public void testIsNextHex(){
		//kova koodattu 3,3 starthex
		BattleField SUT = new BattleField();
		boolean res = SUT.isNextHex(4, 4);
		assertTrue(res);
		
	}
	
	@Test
	public void testGetWorldType() {
		//Given
		BattleField SUT = new BattleField();
		//When
		String res = SUT.getWorldType(3, 3);
		//Then
		assertEquals("Hex 3,3 should be forest","f",res);
	}
}
