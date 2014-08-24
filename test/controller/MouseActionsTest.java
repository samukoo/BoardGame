package controller;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;

import java.util.ArrayList;

import model.battlefield.BattleField;
import model.units.Unit;
import model.world.Hex;
import model.world.World;

import org.junit.Test;

public class MouseActionsTest {

	@Test
	public void testSelectHex(){
		//Given
		BattleField bfTest = new BattleField();
		ArrayList<Hex> world = bfTest.world;
		MouseActions SUT = new MouseActions();
		
			for(int i = 0; i<world.size();i++){
				assertFalse("should be No hex selected",world.get(i).isSelected());
			}
		//When 
		int[]XY={200,200};
		bfTest = SUT.selectHex(bfTest, XY);
		
		//Then
		world=bfTest.world;
		boolean res=false;
		for(int i = 0; i<world.size();i++){
			if(world.get(i).isSelected())
				res=true;
		}
		assertTrue(res);
		
		
		
	}
	
	
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
